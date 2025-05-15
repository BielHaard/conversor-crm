package com.reino.srm.conversor.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Representa uma transação com valores de origem e destino em diferentes moedas")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da transação", example = "1")
    private Long id;

    @ManyToOne
    @Schema(description = "Produto associado à transação")
    private Produto produto;

    @Schema(description = "Valor na moeda de origem", example = "100.00")
    private BigDecimal valorOrigem;

    @Schema(description = "Valor convertido na moeda de destino", example = "500.00")
    private BigDecimal valorDestino;

    @Schema(description = "Data e hora da transação", example = "2025-04-24T15:30:00")
    private LocalDateTime dataHora;

    @Schema(description = "Reino associado à transação", example = "Reino A")
    private String reino;

    @ManyToOne
    @Schema(description = "Moeda de origem da transação")
    private Moeda moedaOrigem;

    @ManyToOne
    @Schema(description = "Moeda de destino da transação")
    private Moeda moedaDestino;

}
