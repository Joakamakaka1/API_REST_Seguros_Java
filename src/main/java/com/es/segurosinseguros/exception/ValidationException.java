package com.es.segurosinseguros.exception;

public class ValidationException extends RuntimeException{
    private static final String DESCRIPCION = "Not found exception (404)";
    public ValidationException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
