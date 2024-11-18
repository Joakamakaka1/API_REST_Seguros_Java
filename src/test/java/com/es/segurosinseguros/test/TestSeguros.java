package com.es.segurosinseguros.test;

import com.es.segurosinseguros.controller.SeguroController;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.service.SegurosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestSeguros {

    @Autowired
    private SeguroController seguroController;

    @Autowired
    private SegurosService segurosService;

    @Test
    void contextLoads() {
        // Verifica que el contexto de la aplicación se carga correctamente
        assertNotNull(seguroController, "El controlador de seguros debe estar disponible en el contexto.");
        assertNotNull(segurosService, "El servicio de seguros debe estar disponible en el contexto.");
    }

    @Test
    void testGetAllSeguros() {
        // Llama al método del controlador sin usar MockMvc
        ResponseEntity response = seguroController.getAllSeguros();

        // Verifica que la respuesta sea exitosa
        assertEquals(HttpStatus.OK, response.getStatusCode(), "La respuesta debe ser 200 OK.");
    }

    @Test
    void testGetSeguroById() {
        // Prueba que al obtener un seguro por ID, la respuesta sea correcta
        ResponseEntity response = seguroController.getSeguroById("1");

        // Verifica que la respuesta sea 200 OK (en este caso, deberías tener un seguro con ID "1" en tu base de datos)
        assertEquals(HttpStatus.OK, response.getStatusCode(), "La respuesta debe ser 200 OK.");
    }

    @Test
    void testCreateSeguro() {
        // Crea un nuevo seguro en formato DTO (sin validación de datos)
        SeguroDTO nuevoSeguro = new SeguroDTO();
        nuevoSeguro.setNif("12345678A");
        nuevoSeguro.setNombre("Juan Pérez");
        nuevoSeguro.setApe1("Pérez");
        nuevoSeguro.setApe2("González");
        nuevoSeguro.setEdad(30);
        nuevoSeguro.setNumHijos(2);
        nuevoSeguro.setSexo("M");
        nuevoSeguro.setCasado(true);
        nuevoSeguro.setEmbarazada(false);

        // Llama al método de creación
        ResponseEntity<SeguroDTO> response = seguroController.createSeguro(nuevoSeguro);

        // Verifica que la respuesta sea correcta (201 CREATED)
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "La respuesta debe ser 201 CREATED.");
        assertNotNull(response.getBody(), "El cuerpo de la respuesta no debe ser nulo.");
        assertNotNull(response.getBody().getNif(), "El NIF no debe ser nulo.");
    }

    @Test
    void testUpdateSeguro() {
        // Crea un seguro DTO para actualizar
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setNif("12345678B");
        seguroDTO.setNombre("Ana García");
        seguroDTO.setApe1("García");
        seguroDTO.setApe2("Martínez");
        seguroDTO.setEdad(40);
        seguroDTO.setNumHijos(1);
        seguroDTO.setSexo("F");
        seguroDTO.setCasado(false);
        seguroDTO.setEmbarazada(false);

        // Llama al método de actualización
        ResponseEntity<SeguroDTO> response = seguroController.updateSeguro("1", seguroDTO);

        // Verifica que la respuesta sea correcta (200 OK)
        assertEquals(HttpStatus.OK, response.getStatusCode(), "La respuesta debe ser 200 OK.");
        assertNotNull(response.getBody(), "El cuerpo de la respuesta no debe ser nulo.");
        assertEquals("Seguro actualizado", response.getBody().getNombre(), "El nombre del seguro debe ser 'Seguro actualizado'.");
    }

    @Test
    void testDeleteSeguro() {
        // Llama al método de eliminación (suponiendo que existe un seguro con ID "1")
        ResponseEntity<SeguroDTO> response = seguroController.deleteSeguro("1");

        // Verifica que la respuesta sea correcta (204 NO CONTENT)
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode(), "La respuesta debe ser 204 NO CONTENT.");
    }
}
