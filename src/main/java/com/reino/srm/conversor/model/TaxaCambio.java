package com.reino.srm.conversor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TaxaCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal taxa;
    private LocalDate data;
    @ManyToOne
    private Moeda moedaOrigem;
    @ManyToOne
    private Moeda moedaDestino;
    @ManyToOne
    private Produto produto;

}
