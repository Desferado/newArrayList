package org.example;

public class StringArrayFullException extends RuntimeException {
    public StringArrayFullException() {
    }

    public StringArrayFullException(String message) {
        super(message);
    }

    public StringArrayFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringArrayFullException(Throwable cause) {
        super(cause);
    }

    public StringArrayFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
