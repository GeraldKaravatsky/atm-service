package com.senla.courses.atm.service.exception;

public class AuthorizationException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "You are not authorized to do this action! Please authorize";

    public AuthorizationException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

}
