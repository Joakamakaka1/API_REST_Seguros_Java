package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.ErrorMsgForClient;
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
@RequestMapping("/asistencias") // -> http://localhost:8080/asistencias
public class AsistenciaMedicaController {
    @Autowired
    private AsistenciaMedicaService asistenciaMedicaService;

    /**
     * Gets all asistencias medicas.
     *
     * @return the all asistencias medicas
     */
    @GetMapping // -> http://localhost:8080/asistencias
    public ResponseEntity<?> getAllAsistenciasMedicas() {
        try {
            List<AsistenciaMedicaDTO> asistenciasMedicas = asistenciaMedicaService.getAll(); // Lista con todas las asistencias médicas
            return new ResponseEntity<>(asistenciasMedicas, HttpStatus.OK); // Devuelve la lista de asistencias médicas
        } catch (BadRequestException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets asistencia medica by id.
     *
     * @param idAsistenciaMedica the id asistencia medica
     * @return the asistencia medica by id
     */
    @GetMapping("/{idAsistenciaMedica}") // -> http://localhost:8080/asistencias/{idAsistenciaMedica}
    public ResponseEntity<?> getAsistenciaMedicaById(@PathVariable String idAsistenciaMedica) {
        try {
            AsistenciaMedicaDTO asistenciaMedica = asistenciaMedicaService.getById(idAsistenciaMedica); // Busca la asistencia médica por su ID
            return new ResponseEntity<>(asistenciaMedica, HttpStatus.OK); // Devuelve la asistencia medica
        } catch (BadRequestException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create asistencia medica response entity.
     *
     * @param asistenciaMedicaDTO the asistencia medica dto
     * @return the response entity
     */
    @PostMapping // -> http://localhost:8080/asistencias
    public ResponseEntity<?> createAsistenciaMedica(@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            AsistenciaMedicaDTO creado = asistenciaMedicaService.createAsistenciaMedica(asistenciaMedicaDTO); // Crea la asistencia médica
            return new ResponseEntity<>(creado, HttpStatus.CREATED); // Devuelve la asistencia médica creada
        } catch (BadRequestException | ValidationException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update asistencia medica response entity.
     *
     * @param idAsistenciaMedica  the id asistencia medica
     * @param asistenciaMedicaDTO the asistencia medica dto
     * @return the response entity
     */
    @PutMapping("/{idAsistenciaMedica}") // -> http://localhost:8080/asistencias/{idAsistenciaMedica}
    public ResponseEntity<?> updateAsistenciaMedica(@PathVariable String idAsistenciaMedica, @RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            AsistenciaMedicaDTO actualizado = asistenciaMedicaService.updateAsistenciaMedica(idAsistenciaMedica, asistenciaMedicaDTO); // Actualiza la asistencia médica
            return new ResponseEntity<>(actualizado, HttpStatus.OK); // Devuelve la asistencia médica actualizada
        } catch (BadRequestException | ValidationException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete asistencia medica response entity.
     *
     * @param idAsistenciaMedica the id asistencia medica
     * @return the response entity
     */
    @DeleteMapping("/{idAsistenciaMedica}") // -> http://localhost:8080/asistencias/{idAsistenciaMedica}
    public ResponseEntity<?> deleteAsistenciaMedica(@PathVariable String idAsistenciaMedica) {
        try {
            asistenciaMedicaService.deleteAsistenciaMedica(idAsistenciaMedica); // Elimina la asistencia médica
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve la asistencia médica eliminada
        } catch (BadRequestException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/asistencias/" + idAsistenciaMedica);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
