package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.ResourceNotFoundException;
import com.es.segurosinseguros.exception.ValidationException;
import com.es.segurosinseguros.service.AsistenciaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Asistencia medica controller.
 */
@RestController
@RequestMapping("/asistencias")
public class AsistenciaMedicaController {
    @Autowired
    private final AsistenciaMedicaService asistenciaMedicaService;

    /**
     * Instantiates a new Asistencia medica controller.
     *
     * @param asistenciaMedicaService the asistencia medica service
     */
    public AsistenciaMedicaController(AsistenciaMedicaService asistenciaMedicaService) {
        this.asistenciaMedicaService = asistenciaMedicaService;
    }

    /**
     * Gets all asistencias medicas.
     *
     * @return the all asistencias medicas
     */
    @GetMapping
    public ResponseEntity<List<AsistenciaMedicaDTO>> getAllAsistenciasMedicas() {
        try {
            List<AsistenciaMedicaDTO> asistenciasMedicas = asistenciaMedicaService.getAll();
            return new ResponseEntity<>(asistenciasMedicas, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets asistencia medica by id.
     *
     * @param idAsistenciaMedica the id asistencia medica
     * @return the asistencia medica by id
     */
    @GetMapping("/{idAsistenciaMedica}")
    public ResponseEntity<AsistenciaMedicaDTO> getAsistenciaMedicaById(@PathVariable String idAsistenciaMedica) {
        try {
            AsistenciaMedicaDTO asistenciaMedica = asistenciaMedicaService.getById(idAsistenciaMedica);
            return new ResponseEntity<>(asistenciaMedica, HttpStatus.OK);
        } catch (BadRequestException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create asistencia medica response entity.
     *
     * @param asistenciaMedicaDTO the asistencia medica dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<AsistenciaMedicaDTO> createAsistenciaMedica(@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            AsistenciaMedicaDTO creado = asistenciaMedicaService.createAsistenciaMedica(asistenciaMedicaDTO);
            return new ResponseEntity<>(creado, HttpStatus.CREATED);
        } catch (BadRequestException | ValidationException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update asistencia medica response entity.
     *
     * @param idAsistenciaMedica  the id asistencia medica
     * @param asistenciaMedicaDTO the asistencia medica dto
     * @return the response entity
     */
    @PutMapping("/{idAsistenciaMedica}")
    public ResponseEntity<AsistenciaMedicaDTO> updateAsistenciaMedica(@PathVariable String idAsistenciaMedica, @RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            AsistenciaMedicaDTO actualizado = asistenciaMedicaService.updateAsistenciaMedica(idAsistenciaMedica, asistenciaMedicaDTO);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (BadRequestException | ValidationException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete asistencia medica response entity.
     *
     * @param idAsistenciaMedica the id asistencia medica
     * @return the response entity
     */
    @DeleteMapping("/{idAsistenciaMedica}")
    public ResponseEntity<AsistenciaMedicaDTO> deleteAsistenciaMedica(@PathVariable String idAsistenciaMedica) {
        try {
            asistenciaMedicaService.deleteAsistenciaMedica(idAsistenciaMedica);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (BadRequestException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
