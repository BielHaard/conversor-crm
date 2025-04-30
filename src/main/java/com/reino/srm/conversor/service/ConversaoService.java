package com.reino.srm.conversor.service;

import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.model.Produto;
import com.reino.srm.conversor.model.Transacao;

import java.math.BigDecimal;

public interface ConversaoService {
    Transacao converter(Produto produtoTransaction, Moeda moedaOrigem, Moeda moedaDestino, BigDecimal valor, String reino);
}