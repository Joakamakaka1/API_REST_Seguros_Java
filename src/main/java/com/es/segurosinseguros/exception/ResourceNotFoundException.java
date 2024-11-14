package com.es.segurosinseguros.exception;

public class ResourceNotFoundException extends RuntimeException{
    private static final String DESCRIPCION = "Not found exception (404)";
    public ResourceNotFoundException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
