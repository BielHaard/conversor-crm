package com.reino.srm.conversor.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Representa a taxa de câmbio entre duas moedas para um determinado produto")
public class TaxaCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da taxa de câmbio", example = "1")
    private Long id;

    @Schema(description = "Valor da taxa de câmbio", example = "5.12")
    private BigDecimal taxa;

    @Schema(description = "Data da taxa de câmbio", example = "2025-04-24")
    private LocalDate data;

    @ManyToOne
    @Schema(description = "Moeda de origem da taxa de câmbio")
    private Moeda moedaOrigem;

    @ManyToOne
    @Schema(description = "Moeda de destino da taxa de câmbio")
    private Moeda moedaDestino;

    @ManyToOne
    @Schema(description = "Produto relacionado à taxa de câmbio")
    private Produto produto;

}
