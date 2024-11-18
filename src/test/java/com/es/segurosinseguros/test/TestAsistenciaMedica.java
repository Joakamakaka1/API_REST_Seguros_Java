package com.es.segurosinseguros.test;

import com.es.segurosinseguros.controller.AsistenciaMedicaController;
import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.service.AsistenciaMedicaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestAsistenciaMedica {

    @Autowired
    private AsistenciaMedicaController asistenciaMedicaController;

    @Autowired
    private AsistenciaMedicaService asistenciaMedicaService;

    @Test
    void contextLoads() {
        // Verifica que el contexto de la aplicación se carga correctamente
        assertNotNull(asistenciaMedicaController, "El controlador de asistencia médica debe estar disponible en el contexto.");
        assertNotNull(asistenciaMedicaService, "El servicio de asistencia médica debe estar disponible en el contexto.");
    }

    @Test
    void testGetAllAsistenciasMedicas() {
        // Llama al método del controlador sin usar MockMvc
        ResponseEntity response = asistenciaMedicaController.getAllAsistenciasMedicas();

        // Verifica que la respuesta sea exitosa
        assertEquals(HttpStatus.OK, response.getStatusCode(), "La respuesta debe ser 200 OK.");
        assertNotNull(response.getBody(), "El cuerpo de la respuesta no debe ser nulo.");
    }

    @Test
    void testGetAsistenciaMedicaById() {
        // Suponiendo que existe una asistencia médica con ID 1 en la base de datos
        ResponseEntity response = asistenciaMedicaController.getAsistenciaMedicaById("1");

        // Verifica que la respuesta sea correcta (200 OK)
        assertEquals(HttpStatus.OK, response.getStatusCode(), "La respuesta debe ser 200 OK.");
        assertNotNull(response.getBody(), "El cuerpo de la respuesta no debe ser nulo.");
    }

    @Test
    void testCreateAsistenciaMedica() {
        // Crea una nueva asistencia médica en formato DTO (sin validación de datos)
        AsistenciaMedicaDTO nuevaAsistencia = new AsistenciaMedicaDTO();
        nuevaAsistencia.setBreveDescripcion("Consulta general");
        nuevaAsistencia.setLugar("Hospital ABC");
        nuevaAsistencia.setExplicacion("Consulta médica para chequeo anual");
        nuevaAsistencia.setTipoAsistencia("General");
        nuevaAsistencia.setFecha(java.time.LocalDate.now());
        nuevaAsistencia.setHora(java.time.LocalTime.now());
        nuevaAsistencia.setImporte(100.0);

        // Llama al método de creación
        ResponseEntity<AsistenciaMedicaDTO> response = asistenciaMedicaController.createAsistenciaMedica(nuevaAsistencia);

        // Verifica que la respuesta sea correcta (201 CREATED)
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "La respuesta debe ser 201 CREATED.");
        assertNotNull(response.getBody(), "El cuerpo de la respuesta no debe ser nulo.");
        assertNotNull(response.getBody().getBreveDescripcion(), "La breve descripción no debe ser nula.");
    }

    @Test
    void testUpdateAsistenciaMedica() {
        // Suponiendo que tenemos una asistencia médica con ID 1 en la base de datos
        AsistenciaMedicaDTO asistenciaMedicaDTO = new AsistenciaMedicaDTO();
        asistenciaMedicaDTO.setBreveDescripcion("Consulta especializada");
        asistenciaMedicaDTO.setLugar("Clínica XYZ");
        asistenciaMedicaDTO.setExplicacion("Consulta con especialista para tratamiento específico");
        asistenciaMedicaDTO.setTipoAsistencia("Especializada");
        asistenciaMedicaDTO.setFecha(java.time.LocalDate.now());
        asistenciaMedicaDTO.setHora(java.time.LocalTime.now());
        asistenciaMedicaDTO.setImporte(200.0);

        // Llama al método de actualización
        ResponseEntity<AsistenciaMedicaDTO> response = asistenciaMedicaController.updateAsistenciaMedica("1", asistenciaMedicaDTO);

        // Verifica que la respuesta sea correcta (200 OK)
        assertEquals(HttpStatus.OK, response.getStatusCode(), "La respuesta debe ser 200 OK.");
        assertNotNull(response.getBody(), "El cuerpo de la respuesta no debe ser nulo.");
        assertEquals("Consulta especializada", response.getBody().getBreveDescripcion(), "La breve descripción debe ser 'Consulta especializada'.");
    }

    @Test
    void testDeleteAsistenciaMedica() {
        // Llama al método de eliminación (suponiendo que existe una asistencia médica con ID 1)
        ResponseEntity<AsistenciaMedicaDTO> response = asistenciaMedicaController.deleteAsistenciaMedica("1");

        // Verifica que la respuesta sea correcta (204 NO CONTENT)
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode(), "La respuesta debe ser 204 NO CONTENT.");
    }
}

