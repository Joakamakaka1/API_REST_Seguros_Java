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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Seguros service.
 */
@Service
public class SegurosService {

    @Autowired
    private SegurosRepository seguroRepository;
    @Autowired
    private Mapper mapper;

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<SeguroDTO> getAll() {
        try {
            List<Seguro> seguros = seguroRepository.findAll(); // Lista con todos las seguros
            if (seguros.isEmpty()) {
                throw new ResourceNotFoundException("No existen seguros en la base de datos");
            }
            List<SeguroDTO> seguroDTOS = new ArrayList<>(); // Lista con los DTOs de las seguros
            seguros.forEach(seguro -> seguroDTOS.add(mapper.mapToDto(seguro))); // Mapeo de cada seguro a su DTO
            return seguroDTOS;
        } catch (ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al obtener todos los seguros: " + e.getMessage());
        }
    }

    /**
     * Gets by id.
     *
     * @param idSeguro the id seguro
     * @return the by id
     */
    public SeguroDTO getById(String idSeguro) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) {
                throw new BadRequestException("El id del seguro no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            Seguro seguro = seguroRepository.findById(idLong).orElse(null); // Busca el seguro en la base de datos
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

    /**
     * Create seguro seguro dto.
     *
     * @param seguroDTO the seguro dto
     * @return the seguro dto
     */
    public SeguroDTO createSeguro(SeguroDTO seguroDTO) {
        try {
            if (seguroDTO == null) {
                throw new BadRequestException("El seguro no puede ser nulo");
            }
            SeguroValidator.validateSeguro(seguroDTO);
            Seguro seguro = mapper.mapToEntity(seguroDTO); // Mapeo de DTO a Entidad
            seguroRepository.save(seguro); // Guarda el seguro
            return mapper.mapToDto(seguro); // Mapeo de Entidad a DTO para mostrar el resultado
        } catch (BadRequestException | ValidationException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al crear el seguro: " + e.getMessage());
        }
    }

    /**
     * Update seguro seguro dto.
     *
     * @param idSeguro  the id seguro
     * @param seguroDTO the seguro dto
     * @return the seguro dto
     */
    public SeguroDTO updateSeguro(String idSeguro, SeguroDTO seguroDTO) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) { // Verifica si el id del seguro es nulo o vacio
                throw new BadRequestException("El id del seguro no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            if (!seguroRepository.existsById(idLong)) { // Verifica si el seguro existe en la base de datos
                throw new ResourceNotFoundException("No se encontró el seguro con ID: " + idSeguro);
            }
            if (seguroDTO == null) {
                throw new BadRequestException("El seguro no puede ser nulo");
            }
            SeguroValidator.validateSeguro(seguroDTO);
            Seguro seguroActualizado = mapper.mapToEntity(seguroDTO); // Mapeo de DTO a Entidad
            seguroActualizado.setIdSeguro(idLong); // Actualiza el id del seguro
            seguroRepository.save(seguroActualizado); // Guarda el seguro
            return mapper.mapToDto(seguroActualizado); // Mapeo de Entidad a DTO para mostrar el resultado
        } catch (BadRequestException | ValidationException | ResourceNotFoundException ex) {
            throw ex; // Se vuelve a lanzar la excepción para que el RestExceptionHandler la maneje
        } catch (Exception e) {
            throw new GenericException("Error inesperado al actualizar el seguro: " + e.getMessage());
        }
    }

    /**
     * Delete seguro.
     *
     * @param idSeguro the id seguro
     */
    public void deleteSeguro(String idSeguro) {
        try {
            if (idSeguro == null || idSeguro.isBlank()) { // Verifica si el id del seguro es nulo o vacio
                throw new BadRequestException("El id del seguro no puede ser nulo o vacío");
            }
            Long idLong = StringToLong.stringToLong(idSeguro);
            if (!seguroRepository.existsById(idLong)) { // Verifica si el seguro existe en la base de datos
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
