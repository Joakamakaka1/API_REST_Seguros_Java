package com.es.segurosinseguros.repository;

import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegurosRepository extends JpaRepository<Seguro, Long> {
}
