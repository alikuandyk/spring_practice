package org.example.spring_practice.exception;

public class InvalidTitleException extends Exception {
    public InvalidTitleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
