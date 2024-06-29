package com.publicis.assignment.exception;

import org.springframework.http.HttpStatus;

public class SeatsNotAvailableException extends RuntimeException {

    protected HttpStatus httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    public SeatsNotAvailableException(String message) {
        super(message);
    }





}