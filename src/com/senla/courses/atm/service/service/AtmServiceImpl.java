package com.senla.courses.atm.service.service;

import com.senla.courses.atm.service.dao.*;
import com.senla.courses.atm.service.exception.*;
import com.senla.courses.atm.service.model.Account;
import com.senla.courses.atm.service.model.Card;
import com.senla.courses.atm.service.model.CardStatus;
import com.senla.courses.atm.service.model.Client;
import com.senla.courses.atm.service.view.actions.ClientSession;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtmServiceImpl implements AtmService {

    private static final String CARD_NUMBER_PATTERN = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";

    private static final int DEFAULT_ATTEMPTS_NUMBER = 3;

    private static AtmService instance;

    private final CardDao cardDao;

    private final ClientDao clientDao;

    private final AccountDao accountDao;

    private final ClientSession clientSession;

    private AtmServiceImpl() {
        cardDao = CardDaoImpl.getInstance();
        clientDao = ClientDaoImpl.getInstance();
        accountDao = AccountDaoImpl.getInstance();
        clientSession = ClientSession.getInstance();
    }

    public static AtmService getInstance() {
        if (instance == null) {
            instance = new AtmServiceImpl();
        }

        return instance;
    }

    @Override
    public void authorize(String cardNumber, String pinCode) {
        checkCardNumber(cardNumber);

        Card card = cardDao.getByCardNumber(cardNumber);

        checkClientStatus(card);
        checkPinCode(card, pinCode);

        Client client = clientDao.getByClientId(card.getClientId());
        clientSession.setAuthorized(true);
        clientSession.setClient(client);
        clientSession.setCard(card);
    }

    @Override
    public String checkBalance() {
        checkAuthorization();

        Account account = accountDao.getByAccountId(clientSession.getCard().getAccountId());

        return account.getBalance();
    }

    private void checkCardNumber(String cardNumber) {
        Pattern pattern = Pattern.compile(CARD_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(cardNumber);
        if (!matcher.find()) {
            throw new IncorrectCardNumberException();
        }
    }

    private void checkClientStatus(Card card) {
        if (CardStatus.BLOCKED.equals(card.getStatus())) {
            if (LocalDateTime.now().isAfter(card.getBlockDate().plusDays(1))) {
                card.setStatus(CardStatus.ACTIVE);
                card.setAttemptsCount(DEFAULT_ATTEMPTS_NUMBER);
                card.setBlockDate(null);
                cardDao.update(card);
                return;
            }

            throw new CardBlockedException();
        }
    }

    private void checkPinCode(Card card, String pinCode) {
        if (!card.getPinCode().equals(pinCode)) {
            if (card.getAttemptsCount() <= 0) {
                card.setStatus(CardStatus.BLOCKED);
                card.setBlockDate(LocalDateTime.now());
                cardDao.update(card);
                throw new AttemptsExceededException();
            }

            card.setAttemptsCount(card.getAttemptsCount() - 1);
            cardDao.update(card);
            throw new IncorrectPinCodeException();
        }
    }

    private void checkAuthorization() {
        if (!clientSession.isAuthorized()) {
            throw new AuthorizationException();
        }
    }

}
