package ru.akbirov.emailnotificationservice.exception;

public class RetryableException extends RuntimeException{

    public RetryableException(String message) {
        super(message);
    }

    public RetryableException(Throwable cause) {
        super(cause);
    }
}
