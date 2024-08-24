package org.example.spring_practice.exception;

public class InvalidPublishedDateException extends RuntimeException {
    public InvalidPublishedDateException(String message) {
        super(message);
    }
}
