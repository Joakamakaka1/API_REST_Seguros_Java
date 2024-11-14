package com.es.segurosinseguros.repository;

import com.es.segurosinseguros.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Seguros repository.
 */
@Repository
public interface SegurosRepository extends JpaRepository<Seguro, Long> {
}
