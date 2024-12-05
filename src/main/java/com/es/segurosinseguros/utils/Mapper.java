package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.model.Usuario;
import org.springframework.stereotype.Component;

/**
 * The type Mapper.
 */
@Component
public class Mapper {
    /**
     * Map to entity seguro.
     *
     * @param seguro the seguro
     * @return the seguro
     */
    public SeguroDTO mapToDto(Seguro seguro) {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNif(seguro.getNif());
        seguroDTO.setApe1(seguro.getApe1());
        seguroDTO.setApe2(seguro.getApe2());
        seguroDTO.setNombre(seguro.getNombre());
        seguroDTO.setEdad(seguro.getEdad());
        seguroDTO.setCasado(seguro.isCasado());
        seguroDTO.setSexo(seguro.getSexo());
        seguroDTO.setId_usuario(seguro.getIdSeguro());
        return seguroDTO;
    }

    /**
     * Map to seguro seguro.
     *
     * @param seguroDTO the seguro dto
     * @param usuario   the usuario
     * @return the seguro
     */
    public Seguro mapToSeguro(SeguroDTO seguroDTO, Usuario usuario) {
        Seguro seguro = new Seguro();
        seguro.setNif(seguroDTO.getNif());
        seguro.setApe1(seguroDTO.getApe1());
        seguro.setApe2(seguroDTO.getApe2());
        seguro.setNombre(seguroDTO.getNombre());
        seguro.setEdad(seguroDTO.getEdad());
        seguro.setCasado(seguroDTO.isCasado());
        seguro.setSexo(seguroDTO.getSexo());
        seguro.setIdSeguro(seguroDTO.getId_usuario());
        return seguro;
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
        asistenciaMedica.setBreveDescripcion(asistenciaMedicaDTO.getBreveDescripcion());
        asistenciaMedica.setTipoAsistencia(asistenciaMedicaDTO.getTipoAsistencia());
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
        asistenciaMedicaDTO.setBreveDescripcion(asistenciaMedica.getBreveDescripcion());
        asistenciaMedicaDTO.setTipoAsistencia(asistenciaMedica.getTipoAsistencia());
        return asistenciaMedicaDTO;
    }
}
