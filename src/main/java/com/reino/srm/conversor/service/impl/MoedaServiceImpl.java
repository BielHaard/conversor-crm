package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.repository.MoedaRepository;
import com.reino.srm.conversor.service.MoedaService;
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
        return repository.save(moeda);
    }

    @Override
    public List<Moeda> listar() {
        return repository.findAll();
    }
}