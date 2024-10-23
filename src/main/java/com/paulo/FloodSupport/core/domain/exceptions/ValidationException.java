package com.paulo.FloodSupport.core.domain.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
