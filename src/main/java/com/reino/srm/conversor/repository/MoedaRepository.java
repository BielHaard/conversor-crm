package com.reino.srm.conversor.repository;

import com.reino.srm.conversor.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoedaRepository extends JpaRepository<Moeda, Long> {
    Optional<Moeda> findBySimboloIgnoreCase(String simbolo);
}
