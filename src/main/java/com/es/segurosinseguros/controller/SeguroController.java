package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.ErrorMsgForClient;
import com.es.segurosinseguros.exception.ResourceNotFoundException;
import com.es.segurosinseguros.exception.ValidationException;
import com.es.segurosinseguros.service.SegurosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Seguro controller.
 */
@RestController
@RequestMapping("/seguros") // -> http://localhost:8080/seguros
public class SeguroController {
    @Autowired
    private SegurosService segurosService;

    /**
     * Gets all seguros.
     *
     * @return the all seguros
     */
    @GetMapping // -> http://localhost:8080/seguros
    public ResponseEntity<?> getAllSeguros() {
        try {
            List<SeguroDTO> seguros = segurosService.getAll(); // Lista con todos los seguros
            return new ResponseEntity<>(seguros, HttpStatus.OK); // Devuelve la lista de seguros
        } catch (BadRequestException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets seguro by id.
     *
     * @param idSeguro the id seguro
     * @return the seguro by id
     */
    @GetMapping("/{idSeguro}") // -> http://localhost:8080/seguros/{idSeguro}
    public ResponseEntity<?> getSeguroById(@PathVariable String idSeguro) {
        try {
            SeguroDTO seguro = segurosService.getById(idSeguro); // Busca el seguro en la base de datos
            return new ResponseEntity<>(seguro, HttpStatus.OK); // Devuelve el seguro
        } catch (BadRequestException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create seguro response entity.
     *
     * @param seguroDTO the seguro dto
     * @return the response entity
     */
    @PostMapping // -> http://localhost:8080/seguros
    public ResponseEntity<?> createSeguro(@RequestBody SeguroDTO seguroDTO) {
        try {
            SeguroDTO creado = segurosService.createSeguro(seguroDTO); // Crea el seguro
            return new ResponseEntity<>(creado, HttpStatus.CREATED); // Devuelve el seguro creado
        } catch (BadRequestException | ValidationException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update seguro response entity.
     *
     * @param idSeguro  the id seguro
     * @param seguroDTO the seguro dto
     * @return the response entity
     */
    @PutMapping("/{idSeguro}") // -> http://localhost:8080/seguros/{idSeguro}
    public ResponseEntity<?> updateSeguro(@PathVariable String idSeguro, @RequestBody SeguroDTO seguroDTO) {
        try {
            SeguroDTO actualizado = segurosService.updateSeguro(idSeguro, seguroDTO); // Actualiza el seguro
            return new ResponseEntity<>(actualizado, HttpStatus.OK); // Devuelve el seguro actualizado
        } catch (BadRequestException | ValidationException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete seguro response entity.
     *
     * @param idSeguro the id seguro
     * @return the response entity
     */
    @DeleteMapping("/{idSeguro}") // -> http://localhost:8080/seguros/{idSeguro}
    public ResponseEntity<?> deleteSeguro(@PathVariable String idSeguro) {
        try {
            segurosService.deleteSeguro(idSeguro); // Elimina el seguro
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve el seguro eliminado
        } catch (BadRequestException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ErrorMsgForClient error = new ErrorMsgForClient(ex.getMessage(), "/seguros/" + idSeguro);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
