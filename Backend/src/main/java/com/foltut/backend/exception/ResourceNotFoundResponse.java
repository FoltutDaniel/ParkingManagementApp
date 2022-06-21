package com.foltut.backend.exception;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResourceNotFoundResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final Integer status = 404;
    private final HttpStatus error = HttpStatus.NOT_FOUND;

    private String path;
    private String message;


    public ResourceNotFoundResponse(String message, String path) {
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public HttpStatus getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
