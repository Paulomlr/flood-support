package com.paulo.FloodSupport.core.domain.exceptions;

public class ItemCapacityExceededException extends RuntimeException {

    public ItemCapacityExceededException(String message) {
        super(message);
    }
}
