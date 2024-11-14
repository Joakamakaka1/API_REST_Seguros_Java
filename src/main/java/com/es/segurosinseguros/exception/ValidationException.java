package com.es.segurosinseguros.exception;

/**
 * The type Validation exception.
 */
public class ValidationException extends RuntimeException{
    private static final String DESCRIPCION = "Bad validation exception (400)";

    /**
     * Instantiates a new Validation exception.
     *
     * @param message the message
     */
    public ValidationException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
