package com.reino.srm.conversor.repository;

import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.model.Produto;
import com.reino.srm.conversor.model.TaxaCambio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TaxaCambioRepository extends JpaRepository<TaxaCambio, Long> {

    Optional<TaxaCambio> findByMoedaOrigemAndMoedaDestinoAndProdutoAndData(Moeda origem, Moeda destino, Produto produto, LocalDate data);

}
