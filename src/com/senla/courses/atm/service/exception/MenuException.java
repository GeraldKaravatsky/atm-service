package com.senla.courses.atm.service.exception;

public class MenuException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Incorrect program menu. Try later";

    public MenuException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
