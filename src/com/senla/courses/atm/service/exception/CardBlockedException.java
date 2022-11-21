package com.senla.courses.atm.service.exception;

public class CardBlockedException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Your card is blocked! The card will be unblocked one day after the blocking started";

    public CardBlockedException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
