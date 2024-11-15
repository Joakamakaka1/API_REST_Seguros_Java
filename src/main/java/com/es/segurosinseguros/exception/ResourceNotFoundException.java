package com.es.segurosinseguros.exception;

/**
 * The type Resource not found exception.
 */
public class ResourceNotFoundException extends RuntimeException{
    private static final String DESCRIPCION = "Not found exception (404)";

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
