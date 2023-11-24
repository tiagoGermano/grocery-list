package com.fortalsoft.grocery.exception;

import java.time.Instant;

public class DefaultError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    private String method;

    public DefaultError() {}

    public DefaultError(Instant timestamp, Integer status, String error, String message, String path, String method) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.method = method;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
