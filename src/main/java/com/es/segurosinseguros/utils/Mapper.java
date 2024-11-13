package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SegurosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private SegurosRepository seguroRepository;

    public Seguro mapToEntity(SeguroDTO seguroDTO) {
        Seguro seguro = new Seguro();
        seguro.setNif(seguroDTO.getNif());
        seguro.setApe1(seguroDTO.getApe1());
        seguro.setApe2(seguroDTO.getApe2());
        seguro.setEdad(seguroDTO.getEdad());
        seguro.setCasado(seguroDTO.isCasado());
        seguro.setSexo(seguroDTO.getSexo());
        return seguro;
    }

    public SeguroDTO mapToDto(Seguro seguro) {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNif(seguro.getNif());
        seguroDTO.setApe1(seguro.getApe1());
        seguroDTO.setApe2(seguro.getApe2());
        seguroDTO.setEdad(seguro.getEdad());
        seguroDTO.setCasado(seguro.isCasado());
        seguroDTO.setSexo(seguro.getSexo());
        return seguroDTO;
    }
}
