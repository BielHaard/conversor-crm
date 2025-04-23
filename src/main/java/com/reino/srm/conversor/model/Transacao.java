package com.reino.srm.conversor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Produto produto;
    private BigDecimal valorOrigem;
    private BigDecimal valorDestino;
    private LocalDateTime dataHora;
    private String reino;
    @ManyToOne
    private Moeda moedaOrigem;
    @ManyToOne
    private Moeda moedaDestino;

}
