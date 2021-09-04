package com.tdd.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BirthDateException extends RuntimeException {

    public BirthDateException() {
        super("Idade Invalida");
    }

    public BirthDateException(String message) {
        super(message);
    }

    public BirthDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
