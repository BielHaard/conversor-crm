package com.reino.srm.conversor.dto;

import com.reino.srm.conversor.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TransacaoResponseDTO {
    private Long id;
    private String produto;
    private String moedaOrigem;
    private String moedaDestino;
    private BigDecimal valorOrigem;
    private BigDecimal valorDestino;
    private String reino;
    private LocalDateTime dataHora;

    public TransacaoResponseDTO(Transacao t) {
        this(t.getId(), t.getProduto().getNome(), t.getMoedaOrigem().getSimbolo(),
                t.getMoedaDestino().getSimbolo(), t.getValorOrigem(), t.getValorDestino(),
                t.getReino(), t.getDataHora());
    }
}
