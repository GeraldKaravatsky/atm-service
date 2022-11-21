package com.senla.courses.atm.service.exception;

public class TxtFileWriterException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Error while writing txt file";

    public TxtFileWriterException(Throwable e) {
        super(DEFAULT_ERROR_MESSAGE, e);
    }

}
