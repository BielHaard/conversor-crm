package com.reino.srm.conversor.exception;


public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(String nome) {
        super("Produto não encontrado: " + nome);
    }
}
