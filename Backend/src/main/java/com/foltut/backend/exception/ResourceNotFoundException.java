package com.foltut.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue){
        super(String.format("%s not found with %s: '%s'",resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
