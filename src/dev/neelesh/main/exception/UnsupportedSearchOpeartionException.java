package dev.neelesh.main.exception;

public class UnsupportedSearchOpeartionException extends Exception {
    private String message;

    public UnsupportedSearchOpeartionException(String message) {
        super(message);
        this.message = message;
    }
}
