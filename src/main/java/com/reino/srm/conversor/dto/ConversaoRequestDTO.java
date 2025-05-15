package com.reino.srm.conversor.dto;

import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.model.Produto;
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
    private Produto produto;
    private Moeda moedaOrigem;
    private Moeda moedaDestino;
    private BigDecimal valor;
    private String reino;
}