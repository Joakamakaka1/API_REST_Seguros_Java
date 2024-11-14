package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.GenericException;
import com.es.segurosinseguros.exception.ResourceNotFoundException;
import com.es.segurosinseguros.exception.ValidationException;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.repository.AsistenciaMedicaRepository;
import com.es.segurosinseguros.utils.AsistenciaMedicaValidator;
import com.es.segurosinseguros.utils.Mapper;
import com.es.segurosinseguros.utils.StringToLong;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsistenciaMedicaService {

    private final AsistenciaMedicaRepository asistenciaMedicaRepository;
    private Mapper mapper;

    public AsistenciaMedicaService(AsistenciaMedicaRepository asistenciaMedicaRepository, Mapper mapper) {
        this.asistenciaMedicaRepository = asistenciaMedicaRepository;
        this.mapper = mapper;
    }

    public List<AsistenciaMedicaDTO> getAll() {
        try {
            List<AsistenciaMedica> asistenciaMedicas = asistenciaMedicaRepository.findAll();
            if (asistenciaMedicas.isEmpty()) {
                throw new ResourceNotFoundException("No existen asistencias médicas en la base de datos");
            }
            List<AsistenciaMedicaDTO> asistenciaMedicaDTOS = new ArrayList<>();
            asistenciaMedicas.forEach(asistenciaMedica -> asistenciaMedicaDTOS.add(mapper.mapToDto(asistenciaMedica)));
            return asistenciaMedicaDTOS;
        } catch (ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al obtener las asistencias médicas: " + e.getMessage());
        }
    }

    public AsistenciaMedicaDTO getById(String idAsistenciaMedica) {
        try {
            if (idAsistenciaMedica == null || idAsistenciaMedica.isBlank()) {
                throw new BadRequestException("El id de la asistencia médica no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idAsistenciaMedica);
            AsistenciaMedica asistenciaMedica = asistenciaMedicaRepository.findById(idLong).orElse(null);
            if (asistenciaMedica == null) {
                throw new ResourceNotFoundException("No se encontró la asistencia médica con ID: " + idAsistenciaMedica);
            }
            return mapper.mapToDto(asistenciaMedica);
        } catch (BadRequestException | ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al obtener la asistencia médica: " + e.getMessage());
        }
    }

    public AsistenciaMedicaDTO createAsistenciaMedica(AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            if (asistenciaMedicaDTO == null) {
                throw new BadRequestException("La asistencia médica no puede ser nula");
            }
            AsistenciaMedicaValidator.validateAsistenciaMedica(asistenciaMedicaDTO);
            AsistenciaMedica asistenciaMedica = mapper.mapToEntity(asistenciaMedicaDTO);
            asistenciaMedicaRepository.save(asistenciaMedica);
            return mapper.mapToDto(asistenciaMedica);
        } catch (BadRequestException | ValidationException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al crear la asistencia médica: " + e.getMessage());
        }
    }

    public AsistenciaMedicaDTO updateAsistenciaMedica(String idAsistenciaMedica, AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            if (idAsistenciaMedica == null || idAsistenciaMedica.isBlank()) {
                throw new BadRequestException("El id de la asistencia médica no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idAsistenciaMedica);
            AsistenciaMedica asistenciaMedicaExistente = asistenciaMedicaRepository.findById(idLong).orElse(null);
            if (asistenciaMedicaExistente == null) {
                throw new ResourceNotFoundException("No se encontró la asistencia médica con ID: " + idAsistenciaMedica);
            }
            if (asistenciaMedicaDTO == null) {
                throw new BadRequestException("La asistencia médica no puede ser nula");
            }
            AsistenciaMedicaValidator.validateAsistenciaMedica(asistenciaMedicaDTO);
            AsistenciaMedica asistenciaMedicaActualizada = mapper.mapToEntity(asistenciaMedicaDTO);
            asistenciaMedicaActualizada.setIdAsistenciaMedica(idLong);
            asistenciaMedicaRepository.save(asistenciaMedicaActualizada);
            return mapper.mapToDto(asistenciaMedicaActualizada);
        } catch (BadRequestException | ValidationException | ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al actualizar la asistencia médica: " + e.getMessage());
        }
    }

    public void deleteAsistenciaMedica(String idAsistenciaMedica) {
        try {
            if (idAsistenciaMedica == null || idAsistenciaMedica.isBlank()) {
                throw new BadRequestException("El id de la asistencia médica no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idAsistenciaMedica);
            if (!asistenciaMedicaRepository.existsById(idLong)) {
                throw new ResourceNotFoundException("No se encontró la asistencia médica con ID: " + idAsistenciaMedica);
            }
            asistenciaMedicaRepository.deleteById(idLong);
        } catch (BadRequestException | ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al eliminar la asistencia médica: " + e.getMessage());
        }
    }
}