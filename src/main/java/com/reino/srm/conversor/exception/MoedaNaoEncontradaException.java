package com.reino.srm.conversor.exception;


public class MoedaNaoEncontradaException extends RuntimeException {
    public MoedaNaoEncontradaException(String simbolo, String tipo) {
        super("Moeda " + tipo + " não encontrada: " + simbolo);
    }
}
