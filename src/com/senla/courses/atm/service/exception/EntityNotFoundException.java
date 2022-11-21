package com.senla.courses.atm.service.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message, Object... args) {
        super(String.format(message, args));
    }

}
