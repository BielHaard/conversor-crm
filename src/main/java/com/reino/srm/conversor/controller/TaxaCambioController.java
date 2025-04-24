package com.reino.srm.conversor.controller;

import com.reino.srm.conversor.model.TaxaCambio;
import com.reino.srm.conversor.service.TaxaCambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxas-cambio")
@Tag(name = "Taxas de Câmbio", description = "Operações relacionadas às taxas de câmbio")
public class TaxaCambioController {

    private final TaxaCambioService taxaCambioService;

    public TaxaCambioController(TaxaCambioService taxaCambioService) {
        this.taxaCambioService = taxaCambioService;
    }

    @Operation(summary = "Cria uma nova taxa de câmbio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Taxa de câmbio criada com sucesso",
                    content = @Content(schema = @Schema(implementation = TaxaCambio.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<TaxaCambio> criar(@RequestBody TaxaCambio taxa) {
        return ResponseEntity.ok(taxaCambioService.salvar(taxa));
    }

    @Operation(summary = "Lista todas as taxas de câmbio cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de taxas de câmbio",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TaxaCambio.class)))
    @GetMapping
    public List<TaxaCambio> listar() {
        return taxaCambioService.listar();
    }
}