package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seguros") // -> http://localhost:8080/seguros
public class SeguroController {
    @GetMapping ("/{idSeguro}") // -> http://localhost:8080/seguros/1
    public ResponseEntity<SeguroDTO> getById(@PathVariable String idSeguro) {
        if(idSeguro == null || idSeguro.isBlank()) {
            throw new BadRequestException("El id del seguro no puede ser nulo");
        }
        return ResponseEntity.ok(new SeguroDTO());
    }
}
