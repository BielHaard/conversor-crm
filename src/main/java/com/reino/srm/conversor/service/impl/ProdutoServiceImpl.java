package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.exception.ProdutoInvalidoException;
import com.reino.srm.conversor.exception.ErroPersistenciaProdutoException;
import com.reino.srm.conversor.model.Produto;
import com.reino.srm.conversor.repository.ProdutoRepository;
import com.reino.srm.conversor.service.ProdutoService;
import org.springframework.dao.DataAccessException;
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
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new ProdutoInvalidoException("O nome do produto é obrigatório.");
        }

        try {
            return repository.save(produto);
        } catch (DataAccessException ex) {
            throw new ErroPersistenciaProdutoException("Erro ao salvar produto: " + ex.getMessage());
        }
    }

    @Override
    public List<Produto> listar() {
        return repository.findAll();
    }
}
