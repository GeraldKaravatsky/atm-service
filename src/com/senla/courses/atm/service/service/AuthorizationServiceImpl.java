package com.senla.courses.atm.service.service;

import com.senla.courses.atm.service.dao.CardDao;
import com.senla.courses.atm.service.dao.CardDaoImpl;
import com.senla.courses.atm.service.dao.ClientDao;
import com.senla.courses.atm.service.dao.ClientDaoImpl;
import com.senla.courses.atm.service.exception.BusinessException;
import com.senla.courses.atm.service.exception.ExceptionConstants;
import com.senla.courses.atm.service.model.Card;
import com.senla.courses.atm.service.model.CardStatus;
import com.senla.courses.atm.service.model.Client;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthorizationServiceImpl implements AuthorizationService {

    private static final String CARD_NUMBER_PATTERN = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";

    private static final int DEFAULT_ATTEMPTS_NUMBER = 3;

    private static AuthorizationService instance;

    private final CardDao cardDao;

    private final ClientDao clientDao;

    private final ClientSession clientSession;

    private AuthorizationServiceImpl() {
        cardDao = CardDaoImpl.getInstance();
        clientDao = ClientDaoImpl.getInstance();
        clientSession = ClientSession.getInstance();
    }

    public static AuthorizationService getInstance() {
        if (instance == null) {
            instance = new AuthorizationServiceImpl();
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

    private void checkCardNumber(String cardNumber) {
        Pattern pattern = Pattern.compile(CARD_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(cardNumber);
        if (!matcher.find()) {
            throw new BusinessException(ExceptionConstants.INCORRECT_CARD_NUMBER_ERROR_MESSAGE);
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

            throw new BusinessException(ExceptionConstants.CARD_BLOCKED_ERROR_MESSAGE);
        }
    }

    private void checkPinCode(Card card, String pinCode) {
        if (!card.getPinCode().equals(pinCode)) {
            if (card.getAttemptsCount() <= 0) {
                card.setStatus(CardStatus.BLOCKED);
                card.setBlockDate(LocalDateTime.now());
                cardDao.update(card);
                throw new BusinessException(ExceptionConstants.ATTEMPTS_EXCEEDED_ERROR_MESSAGE);
            }

            card.setAttemptsCount(card.getAttemptsCount() - 1);
            cardDao.update(card);
            throw new BusinessException(ExceptionConstants.INCORRECT_PIN_CODE_ERROR_MESSAGE);
        }
    }

}
