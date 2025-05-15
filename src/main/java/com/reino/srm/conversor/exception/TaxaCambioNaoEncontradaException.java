package com.reino.srm.conversor.exception;


public class TaxaCambioNaoEncontradaException extends RuntimeException {
    public TaxaCambioNaoEncontradaException() {
        super("Taxa de câmbio não encontrada para o dia de hoje.");
    }
}
