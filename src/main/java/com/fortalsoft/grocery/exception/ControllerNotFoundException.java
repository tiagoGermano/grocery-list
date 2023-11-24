package com.fortalsoft.grocery.exception;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String message) {
        super(message);
    }
}
