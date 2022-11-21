package com.senla.courses.atm.service.exception;

public class AttemptsExceededException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Attempts exceeded! The card will be blocked";

    public AttemptsExceededException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}