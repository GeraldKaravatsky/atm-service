package com.senla.courses.atm.service.service;

import com.senla.courses.atm.service.dao.*;
import com.senla.courses.atm.service.exception.BusinessException;
import com.senla.courses.atm.service.exception.ExceptionConstants;
import com.senla.courses.atm.service.model.Account;

import java.math.BigDecimal;

public class AtmServiceImpl implements AtmService {

    private static final BigDecimal MAX_REPLENISHMENT_AMOUNT = new BigDecimal("1000000");

    private static AtmService instance;

    private final CardDao cardDao;

    private final ClientDao clientDao;

    private final AccountDao accountDao;

    private final AtmDao atmDao;

    private final ClientSession clientSession;

    private AtmServiceImpl() {
        cardDao = CardDaoImpl.getInstance();
        clientDao = ClientDaoImpl.getInstance();
        accountDao = AccountDaoImpl.getInstance();
        atmDao = AtmDaoImpl.getInstance();
        clientSession = ClientSession.getInstance();
    }

    public static AtmService getInstance() {
        if (instance == null) {
            instance = new AtmServiceImpl();
        }

        return instance;
    }

    @Override
    public String checkBalance() {
        checkAuthorization();

        Account account = accountDao.getByAccountId(clientSession.getCard().getAccountId());

        return account.getBalance();
    }

    @Override
    public void withdrawMoney(String money) {
        checkAuthorization();

        BigDecimal bigDecimalMoney = parseBigDecimal(money);
        Account account = accountDao.getByAccountId(clientSession.getCard().getAccountId());

        if (atmDao.getLimit().compareTo(bigDecimalMoney) < 0 || account.getAmount().compareTo(bigDecimalMoney) < 0) {
            throw new BusinessException(ExceptionConstants.NO_MONEY_ERROR_MESSAGE);
        }

        account.setAmount(account.getAmount().subtract(bigDecimalMoney));
        accountDao.update(account);
    }

    @Override
    public void replenishBalance(String money) {
        checkAuthorization();

        BigDecimal bigDecimalMoney = parseBigDecimal(money);

        if (MAX_REPLENISHMENT_AMOUNT.compareTo(bigDecimalMoney) < 0) {
            throw new BusinessException(ExceptionConstants.REPLENISHMENT_AMOUNT_ERROR);
        }

        Account account = accountDao.getByAccountId(clientSession.getCard().getAccountId());
        account.setAmount(account.getAmount().add(bigDecimalMoney));
        accountDao.update(account);
    }

    private BigDecimal parseBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            throw new BusinessException(ExceptionConstants.INCORRECT_VALUE);
        }
    }

    private void checkAuthorization() {
        if (!clientSession.isAuthorized()) {
            throw new BusinessException(ExceptionConstants.AUTHORIZATION_ERROR_MESSAGE);
        }
    }

}
