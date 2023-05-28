package org.example;

public class IntegerArrayFullException extends RuntimeException {
    public IntegerArrayFullException() {
    }

    public IntegerArrayFullException(String message) {
        super(message);
    }

    public IntegerArrayFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerArrayFullException(Throwable cause) {
        super(cause);
    }

    public IntegerArrayFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
