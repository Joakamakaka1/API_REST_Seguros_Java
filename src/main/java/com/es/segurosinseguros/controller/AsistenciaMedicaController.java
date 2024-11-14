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

@RestController
@RequestMapping("/asistencias")
public class AsistenciaMedicaController {
    @Autowired
    private final AsistenciaMedicaService asistenciaMedicaService;

    public AsistenciaMedicaController(AsistenciaMedicaService asistenciaMedicaService) {
        this.asistenciaMedicaService = asistenciaMedicaService;
    }

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
