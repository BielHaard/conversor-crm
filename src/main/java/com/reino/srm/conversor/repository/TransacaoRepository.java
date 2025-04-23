package com.reino.srm.conversor.repository;

import com.reino.srm.conversor.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
