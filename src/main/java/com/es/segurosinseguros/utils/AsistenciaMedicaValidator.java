package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.ValidationException;

import java.text.DecimalFormat;

/**
 * The type Asistencia medica validator.
 */
public class AsistenciaMedicaValidator {

    /**
     * Validate asistencia medica.
     *
     * @param asistenciaMedicaDTO the asistencia medica dto
     * @throws ValidationException the validation exception
     */
    public static void validateAsistenciaMedica(AsistenciaMedicaDTO asistenciaMedicaDTO) throws ValidationException {
        if (asistenciaMedicaDTO.getBreveDescripcion() == null || asistenciaMedicaDTO.getBreveDescripcion().isEmpty()) {
            throw new ValidationException("La breve descripción no puede ser vacía");
        }
        if (asistenciaMedicaDTO.getLugar() == null || asistenciaMedicaDTO.getLugar().isEmpty()) {
            throw new ValidationException("El lugar no puede ser vacío");
        }
        if (asistenciaMedicaDTO.getExplicacion() == null || asistenciaMedicaDTO.getExplicacion().isEmpty()) {
            throw new ValidationException("La explicación no puede ser vacía");
        }
        if (asistenciaMedicaDTO.getTipoAsistencia() == null) {
            throw new ValidationException("El tipo de asistencia no puede ser nulo");
        }
        if (asistenciaMedicaDTO.getFecha() == null) {
            throw new ValidationException("La fecha no puede ser nula");
        }
        if (asistenciaMedicaDTO.getHora() == null) {
            throw new ValidationException("La hora no puede ser nula");
        }
        if (asistenciaMedicaDTO.getImporte() <= 0) {
            throw new ValidationException("El importe debe ser mayor que 0");
        }
    }
}
