package com.es.segurosinseguros.exception;

/**
 * The type Generic exception.
 */
public class GenericException extends RuntimeException{
    private static final String DESCRIPCION = "Not found exception (500)";

    /**
     * Instantiates a new Generic exception.
     *
     * @param message the message
     */
    public GenericException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
