package com.senla.courses.atm.service.dao;

import com.senla.courses.atm.service.model.Card;

public interface CardDao {

    Card getByCardNumber(String cardNumber);

    void update(Card updatedCard);

}
