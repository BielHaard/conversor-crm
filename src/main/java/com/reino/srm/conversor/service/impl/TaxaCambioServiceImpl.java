package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.exception.TaxaCambioInvalidaException;
import com.reino.srm.conversor.exception.ErroPersistenciaTaxaCambioException;
import com.reino.srm.conversor.model.TaxaCambio;
import com.reino.srm.conversor.repository.TaxaCambioRepository;
import com.reino.srm.conversor.service.TaxaCambioService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxaCambioServiceImpl implements TaxaCambioService {

    private final TaxaCambioRepository repository;

    public TaxaCambioServiceImpl(TaxaCambioRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaxaCambio salvar(TaxaCambio taxa) {
        if (taxa.getProduto() == null) {
            throw new TaxaCambioInvalidaException("O produto é obrigatório para a taxa de câmbio.");
        }

        if (taxa.getMoedaOrigem() == null || taxa.getMoedaDestino() == null) {
            throw new TaxaCambioInvalidaException("Moedas de origem e destino são obrigatórias.");
        }

        if (taxa.getTaxa() == null) {
            throw new TaxaCambioInvalidaException("A taxa de câmbio é obrigatória.");
        }

        try {
            return repository.save(taxa);
        } catch (DataAccessException ex) {
            throw new ErroPersistenciaTaxaCambioException("Erro ao salvar a taxa de câmbio: " + ex.getMessage());
        }
    }

    @Override
    public List<TaxaCambio> listar() {
        return repository.findAll();
    }
}
