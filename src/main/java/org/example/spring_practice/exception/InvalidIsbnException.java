package org.example.spring_practice.exception;

public class InvalidIsbnException extends Exception {
    public InvalidIsbnException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
