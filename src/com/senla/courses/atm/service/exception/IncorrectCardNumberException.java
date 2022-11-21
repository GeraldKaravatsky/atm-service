package com.senla.courses.atm.service.exception;

public class IncorrectCardNumberException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Incorrect card number format. " +
            "Please use this format: 'XXXX-XXXX-XXXX-XXXX' and try again";

    public IncorrectCardNumberException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
