package com.es.segurosinseguros.exception;

public class GenericException extends RuntimeException{
    private static final String DESCRIPCION = "Not found exception (505)";
    public GenericException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
