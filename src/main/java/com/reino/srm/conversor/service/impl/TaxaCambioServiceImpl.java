package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.model.TaxaCambio;
import com.reino.srm.conversor.repository.TaxaCambioRepository;
import com.reino.srm.conversor.service.TaxaCambioService;
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
        return repository.save(taxa);
    }

    @Override
    public List<TaxaCambio> listar() {
        return repository.findAll();
    }
}