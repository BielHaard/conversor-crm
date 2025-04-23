package com.reino.srm.conversor.service;

import com.reino.srm.conversor.model.Transacao;

import java.math.BigDecimal;

public interface ConversaoService {
    Transacao converter(String produtoNome, String moedaOrigem, String moedaDestino, BigDecimal valor, String reino);
}