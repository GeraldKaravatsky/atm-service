package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.database.DataBase;
import com.senla.courses.atm.service.exception.EntityNotFoundException;
import com.senla.courses.atm.service.model.Card;

import java.util.List;
import java.util.stream.Collectors;

public class CardDaoImpl implements CardDao {

    private final DataBase dataBase;

    private static CardDao instance;

    private CardDaoImpl() {
        dataBase = DataBase.getInstance();
    }

    public static CardDao getInstance() {
        if (instance == null) {
            instance = new CardDaoImpl();
        }

        return instance;
    }

    @Override
    public Card getByCardNumber(String cardNumber) {
        return dataBase.getCards()
                .stream()
                .filter(card -> cardNumber.equals(card.getNumber()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Card not found by card number %s", cardNumber));
    }

    @Override
    public void update(Card updatedCard) {
        // exclude old card
        final List<Card> cards = dataBase.getCards()
                .stream()
                .filter(card -> !updatedCard.getNumber().equals(card.getNumber()))
                .collect(Collectors.toList());

        cards.add(updatedCard);

        dataBase.setCards(cards);
    }

}
