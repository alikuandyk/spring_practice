package org.example.spring_practice.exception;

public class InvalidPublishedDateException extends Exception {
    public InvalidPublishedDateException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
