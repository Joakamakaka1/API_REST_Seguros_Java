package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.ValidationException;

public class SeguroValidator {

    public static void validateSeguro(SeguroDTO seguroDTO) throws ValidationException {
        if (seguroDTO.getNif() == null || !seguroDTO.getNif().matches("^[A-Z0-9]{8}[A-Z]$"))
            throw new ValidationException("El NIF debe tener un formato válido");

        if (seguroDTO.getNombre() == null || seguroDTO.getNombre().isEmpty())
            throw new ValidationException("El nombre del asegurado no puede estar vacío");

        if (seguroDTO.getApe1() == null || seguroDTO.getApe1().isEmpty())
            throw new ValidationException("El primer apellido del asegurado no puede estar vacío");

        if (seguroDTO.getEdad() <= 0)
            throw new ValidationException("La edad debe ser mayor que 0");

        if (seguroDTO.getEdad() < 18)
            throw new ValidationException("El asegurado no puede ser menor de edad");

        if (seguroDTO.getNumHijos() < 0)
            throw new ValidationException("El número de hijos no puede ser menor que 0");

        if (seguroDTO.getSexo() == null)
            throw new ValidationException("El sexo no puede ser nulo");

        if (seguroDTO.isCasado() && seguroDTO.getNumHijos() == 0)
            throw new ValidationException("El número de hijos debe ser mayor que 0 si está casado");

        if (seguroDTO.isEmbarazada()) {
            if ("Hombre".equalsIgnoreCase(seguroDTO.getSexo()))
                throw new ValidationException("El campo embarazada no es válido para hombres");
            if (!"Mujer".equalsIgnoreCase(seguroDTO.getSexo()))
                throw new ValidationException("Solo las mujeres pueden estar embarazadas");
        }
    }
}
