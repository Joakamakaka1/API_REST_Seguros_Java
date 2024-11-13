package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SegurosRepository;
import com.es.segurosinseguros.utils.Mapper;
import com.es.segurosinseguros.utils.StringToLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SegurosService {

    @Autowired
    private final SegurosRepository seguroRepository;

    @Autowired
    private Mapper mapper;

    public SegurosService(SegurosRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
    }

    public List<SeguroDTO> getAll() {
        try {
            List<Seguro> seguros = seguroRepository.findAll();
            if (seguros.isEmpty()) {
                throw new BadRequestException("No existen seguros");
            }
            List<SeguroDTO> seguroDTOS = new ArrayList<>();
            seguros.forEach(seguro -> seguroDTOS.add(mapper.mapToDto(seguro)));
            return seguroDTOS;
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public SeguroDTO createSeguro(SeguroDTO seguroDTO) {
        try {
            if (seguroDTO == null) {
                throw new BadRequestException("El seguro no puede ser nulo");
            }
            Seguro seguro = mapper.mapToEntity(seguroDTO);
            seguroRepository.save(seguro);
            return mapper.mapToDto(seguro);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public SeguroDTO getById(String idSeguro) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) {
                throw new BadRequestException("El id del seguro no puede ser nulo");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            Seguro seguro = seguroRepository.findById(idLong).orElse(null);
            return mapper.mapToDto(seguro);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public SeguroDTO updateSeguro(String idSeguro, SeguroDTO seguroDTO) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) {
                throw new BadRequestException("El id del seguro no puede ser nulo");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            Seguro seguroActualizado = mapper.mapToEntity(seguroDTO);
            seguroActualizado.setIdSeguro(idLong);
            seguroRepository.save(seguroActualizado);
            return mapper.mapToDto(seguroActualizado);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public void deleteSeguro(String idSeguro) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) {
                throw new BadRequestException("El id del seguro no puede ser nulo");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            seguroRepository.deleteById(idLong);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
