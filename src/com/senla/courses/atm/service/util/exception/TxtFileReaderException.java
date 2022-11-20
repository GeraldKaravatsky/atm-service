package com.senla.courses.atm.service.util.exception;

public class TxtFileReaderException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Error while reading txt file";

    public TxtFileReaderException(Throwable e) {
        super(DEFAULT_ERROR_MESSAGE, e);
    }

}
