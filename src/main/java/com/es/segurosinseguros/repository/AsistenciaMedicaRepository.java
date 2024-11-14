package com.es.segurosinseguros.repository;

import com.es.segurosinseguros.model.AsistenciaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Asistencia medica repository.
 */
@Repository
public interface AsistenciaMedicaRepository extends JpaRepository<AsistenciaMedica, Long> {
}
