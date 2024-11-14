package com.es.segurosinseguros.exception;

public class ResourceNotFoundException extends RuntimeException{
    private static final String DESCRIPCION = "Bad validation exception (400)";
    public ResourceNotFoundException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
