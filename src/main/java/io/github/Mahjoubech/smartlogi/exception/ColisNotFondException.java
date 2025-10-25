package io.github.Mahjoubech.smartlogi.exception;

public class ColisNotFondException extends RuntimeException {
    public ColisNotFondException(String message) {
        super(message);
    }
    public ColisNotFondException(String message, Throwable cause) {
        super(message, cause);
    }
}