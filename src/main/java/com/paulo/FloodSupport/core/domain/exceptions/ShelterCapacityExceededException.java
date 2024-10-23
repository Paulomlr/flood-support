package com.paulo.FloodSupport.core.domain.exceptions;

public class ShelterCapacityExceededException extends RuntimeException {

    public ShelterCapacityExceededException(String message) {
        super(message);
    }
}
