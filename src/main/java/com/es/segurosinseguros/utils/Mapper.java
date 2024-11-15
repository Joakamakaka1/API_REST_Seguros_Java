package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;
import org.springframework.stereotype.Component;

/**
 * The type Mapper.
 */
@Component
public class Mapper {
    /**
     * Map to entity seguro.
     *
     * @param seguroDTO the seguro dto
     * @return the seguro
     */
    public Seguro mapToEntity(SeguroDTO seguroDTO) {
        Seguro seguro = new Seguro();
        seguro.setNif(seguroDTO.getNif());
        seguro.setNombre(seguroDTO.getNombre());
        seguro.setApe1(seguroDTO.getApe1());
        seguro.setApe2(seguroDTO.getApe2());
        seguro.setEdad(seguroDTO.getEdad());
        seguro.setNumHijos(seguroDTO.getNumHijos());
        seguro.setSexo(seguroDTO.getSexo());
        seguro.setCasado(seguroDTO.isCasado());
        seguro.setEmbarazada(seguroDTO.isEmbarazada());
        return seguro;
    }

    /**
     * Map to dto seguro dto.
     *
     * @param seguro the seguro
     * @return the seguro dto
     */
    public SeguroDTO mapToDto(Seguro seguro) {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNif(seguro.getNif());
        seguroDTO.setNombre(seguro.getNombre());
        seguroDTO.setApe1(seguro.getApe1());
        seguroDTO.setApe2(seguro.getApe2());
        seguroDTO.setEdad(seguro.getEdad());
        seguroDTO.setNumHijos(seguro.getNumHijos());
        seguroDTO.setSexo(seguro.getSexo());
        seguroDTO.setCasado(seguro.isCasado());
        seguroDTO.setEmbarazada(seguro.isEmbarazada());
        return seguroDTO;
    }

    /**
     * Map to entity asistencia medica.
     *
     * @param asistenciaMedicaDTO the asistencia medica dto
     * @return the asistencia medica
     */
    public AsistenciaMedica mapToEntity(AsistenciaMedicaDTO asistenciaMedicaDTO) {
        AsistenciaMedica asistenciaMedica = new AsistenciaMedica();
        asistenciaMedica.setFecha(asistenciaMedicaDTO.getFecha());
        asistenciaMedica.setHora(asistenciaMedicaDTO.getHora());
        asistenciaMedica.setLugar(asistenciaMedicaDTO.getLugar());
        asistenciaMedica.setImporte(asistenciaMedicaDTO.getImporte());
        asistenciaMedica.setExplicacion(asistenciaMedicaDTO.getExplicacion());
        return asistenciaMedica;
    }

    /**
     * Map to dto asistencia medica dto.
     *
     * @param asistenciaMedica the asistencia medica
     * @return the asistencia medica dto
     */
    public AsistenciaMedicaDTO mapToDto(AsistenciaMedica asistenciaMedica) {
        AsistenciaMedicaDTO asistenciaMedicaDTO = new AsistenciaMedicaDTO();
        asistenciaMedicaDTO.setFecha(asistenciaMedica.getFecha());
        asistenciaMedicaDTO.setHora(asistenciaMedica.getHora());
        asistenciaMedicaDTO.setLugar(asistenciaMedica.getLugar());
        asistenciaMedicaDTO.setImporte(asistenciaMedica.getImporte());
        asistenciaMedicaDTO.setExplicacion(asistenciaMedica.getExplicacion());
        return asistenciaMedicaDTO;
    }
}
