package com.es.segurosinseguros.exception;

public class DuplicateException extends RuntimeException{
    private static final String DESCRIPCION = "Conflict. User already exists (409)";

    /**
     * Instantiates a new Bad request exception.
     *
     * @param message the message
     */
    public DuplicateException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
