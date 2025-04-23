package com.reino.srm.conversor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConversaoRequestDTO {
    private String produto;
    private String moedaOrigem;
    private String moedaDestino;
    private BigDecimal valor;
    private String reino;
}