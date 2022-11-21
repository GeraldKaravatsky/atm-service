package com.senla.courses.atm.service.exception;

public class IncorrectPinCodeException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Incorrect pin-code. Try again";

    public IncorrectPinCodeException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
