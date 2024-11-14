package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.GenericException;
import com.es.segurosinseguros.exception.ResourceNotFoundException;
import com.es.segurosinseguros.exception.ValidationException;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SegurosRepository;
import com.es.segurosinseguros.utils.Mapper;
import com.es.segurosinseguros.utils.SeguroValidator;
import com.es.segurosinseguros.utils.StringToLong;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SegurosService {

    private final SegurosRepository seguroRepository;
    private final Mapper mapper;

    public SegurosService(SegurosRepository seguroRepository, Mapper mapper) {
        this.seguroRepository = seguroRepository;
        this.mapper = mapper;
    }

    public List<SeguroDTO> getAll() {
        try {
            List<Seguro> seguros = seguroRepository.findAll();
            if (seguros.isEmpty()) {
                throw new ResourceNotFoundException("No existen seguros en la base de datos");
            }
            List<SeguroDTO> seguroDTOS = new ArrayList<>();
            seguros.forEach(seguro -> seguroDTOS.add(mapper.mapToDto(seguro)));
            return seguroDTOS;
        } catch (ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al obtener todos los seguros: " + e.getMessage());
        }
    }

    public SeguroDTO getById(String idSeguro) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) {
                throw new BadRequestException("El id del seguro no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            Seguro seguro = seguroRepository.findById(idLong).orElse(null);
            if (seguro == null) {
                throw new ResourceNotFoundException("No se encontró el seguro con ID: " + idSeguro);
            }
            return mapper.mapToDto(seguro);
        } catch (BadRequestException | ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al obtener el seguro: " + e.getMessage());
        }
    }

    public SeguroDTO createSeguro(SeguroDTO seguroDTO) {
        try {
            if (seguroDTO == null) {
                throw new BadRequestException("El seguro no puede ser nulo");
            }
            SeguroValidator.validateSeguro(seguroDTO);
            Seguro seguro = mapper.mapToEntity(seguroDTO);
            seguroRepository.save(seguro);
            return mapper.mapToDto(seguro);
        } catch (BadRequestException | ValidationException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al crear el seguro: " + e.getMessage());
        }
    }

    public SeguroDTO updateSeguro(String idSeguro, SeguroDTO seguroDTO) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) {
                throw new BadRequestException("El id del seguro no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            Seguro seguroExistente = seguroRepository.findById(idLong).orElse(null);
            if (seguroExistente == null) {
                throw new ResourceNotFoundException("No se encontró el seguro con ID: " + idSeguro);
            }
            if (seguroDTO == null) {
                throw new BadRequestException("El seguro no puede ser nulo");
            }
            SeguroValidator.validateSeguro(seguroDTO);
            Seguro seguroActualizado = mapper.mapToEntity(seguroDTO);
            seguroActualizado.setIdSeguro(idLong);
            seguroRepository.save(seguroActualizado);
            return mapper.mapToDto(seguroActualizado);
        } catch (BadRequestException | ValidationException | ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al actualizar el seguro: " + e.getMessage());
        }
    }

    public void deleteSeguro(String idSeguro) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) {
                throw new BadRequestException("El id del seguro no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            if (!seguroRepository.existsById(idLong)) {
                throw new ResourceNotFoundException("No se encontró el seguro con ID: " + idSeguro);
            }
            seguroRepository.deleteById(idLong);
        } catch (BadRequestException | ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al eliminar el seguro: " + e.getMessage());
        }
    }
}
