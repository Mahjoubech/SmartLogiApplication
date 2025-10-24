package io.github.Mahjoubech.smartlogi.exception;

public class LivreurNotFoundException extends RuntimeException {

    public LivreurNotFoundException(String message) {
        super(message);
    }

    public LivreurNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}