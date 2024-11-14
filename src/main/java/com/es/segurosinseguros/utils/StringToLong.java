package com.es.segurosinseguros.utils;

import org.springframework.stereotype.Component;

/**
 * The type String to long.
 */
@Component
public class StringToLong {
    /**
     * String to long.
     *
     * @param id the id
     * @return the long
     */
    public static Long stringToLong(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El id debe ser un número");
        }
    }
}
