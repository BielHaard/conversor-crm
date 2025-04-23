package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.model.Produto;
import com.reino.srm.conversor.repository.ProdutoRepository;
import com.reino.srm.conversor.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public List<Produto> listar() {
        return repository.findAll();
    }
}
