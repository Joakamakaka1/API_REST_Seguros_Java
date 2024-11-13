package com.es.segurosinseguros.utils;

import org.springframework.stereotype.Component;

@Component
public class StringToLong {

    public static Long stringToLong(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El id debe ser un número");
        }
    }
}
