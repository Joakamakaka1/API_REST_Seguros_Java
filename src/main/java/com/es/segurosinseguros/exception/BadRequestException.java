package com.es.segurosinseguros.exception;

/**
 * The type Bad request exception.
 */
public class BadRequestException extends RuntimeException{
    private static final String DESCRIPCION = "Bad request exception (400)";

    /**
     * Instantiates a new Bad request exception.
     *
     * @param message the message
     */
    public BadRequestException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
