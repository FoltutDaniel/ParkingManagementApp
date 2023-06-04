package com.foltut.backend.exception;

import org.springframework.http.HttpStatus;

public class SubscriptionExpiredException extends RuntimeException{

    public static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
    private final String licensePlate;

    public SubscriptionExpiredException(String licensePlate){
        super(String.format("Subscription expired for car with license plate: '%s'",licensePlate));
        this.licensePlate = licensePlate;
    }
}
