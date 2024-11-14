package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.ResourceNotFoundException;
import com.es.segurosinseguros.exception.ValidationException;
import com.es.segurosinseguros.service.SegurosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros") // -> http://localhost:8080/seguros
public class SeguroController {
    private final SegurosService segurosService;
    public SeguroController(SegurosService segurosService) {
        this.segurosService = segurosService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllSeguros() {
        try {
            List<SeguroDTO> seguros = segurosService.getAll();
            return new ResponseEntity<>(seguros, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idSeguro}")
    public ResponseEntity<?> getSeguroById(@PathVariable String idSeguro) {
        try {
            SeguroDTO seguro = segurosService.getById(idSeguro);
            return new ResponseEntity<>(seguro, HttpStatus.OK);
        } catch (BadRequestException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createSeguro(@RequestBody SeguroDTO seguroDTO) {
        try {
            SeguroDTO creado = segurosService.createSeguro(seguroDTO);
            return new ResponseEntity<>(creado, HttpStatus.CREATED);
        } catch (BadRequestException | ValidationException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idSeguro}")
    public ResponseEntity<?> updateSeguro(@PathVariable String idSeguro, @RequestBody SeguroDTO seguroDTO) {
        try {
            SeguroDTO actualizado = segurosService.updateSeguro(idSeguro, seguroDTO);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (BadRequestException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (ValidationException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idSeguro}")
    public ResponseEntity<?> deleteSeguro(@PathVariable String idSeguro) {
        try {
            segurosService.deleteSeguro(idSeguro);
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
