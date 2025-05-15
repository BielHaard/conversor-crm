package com.reino.srm.conversor.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Schema(description = "Representa uma moeda, incluindo seu nome e símbolo")
public class Moeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da moeda", example = "1")
    private Long id;

    @Schema(description = "Nome da moeda", example = "Real")
    private String nome;

    @Schema(description = "Símbolo da moeda", example = "BRL")
    private String simbolo;

}
