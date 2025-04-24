package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.exception.MoedaInvalidaException;
import com.reino.srm.conversor.exception.ErroPersistenciaMoedaException;
import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.repository.MoedaRepository;
import com.reino.srm.conversor.service.MoedaService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoedaServiceImpl implements MoedaService {

    private final MoedaRepository repository;

    public MoedaServiceImpl(MoedaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Moeda salvar(Moeda moeda) {
        if (moeda.getSimbolo() == null || moeda.getSimbolo().isBlank()) {
            throw new MoedaInvalidaException("O símbolo da moeda é obrigatório.");
        }

        if (moeda.getNome() == null || moeda.getNome().isBlank()) {
            throw new MoedaInvalidaException("O nome da moeda é obrigatório.");
        }

        try {
            return repository.save(moeda);
        } catch (DataAccessException ex) {
            throw new ErroPersistenciaMoedaException("Erro ao salvar moeda: " + ex.getMessage());
        }
    }

    @Override
    public List<Moeda> listar() {
        return repository.findAll();
    }
}
