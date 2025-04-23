package com.reino.srm.conversor.service;


import com.reino.srm.conversor.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto salvar(Produto produto);

    List<Produto> listar();
}
