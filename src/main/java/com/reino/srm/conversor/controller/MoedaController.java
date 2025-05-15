package com.reino.srm.conversor.controller;

import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.service.MoedaService;
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
@RequestMapping("/api/moedas")
@Tag(name = "Moedas", description = "Operações relacionadas às moedas")
public class MoedaController {

    private final MoedaService moedaService;

    public MoedaController(MoedaService moedaService) {
        this.moedaService = moedaService;
    }

    @Operation(summary = "Cria uma nova moeda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Moeda criada com sucesso",
                    content = @Content(schema = @Schema(implementation = Moeda.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Moeda> criar(@RequestBody Moeda moeda) {
        return ResponseEntity.ok(moedaService.salvar(moeda));
    }

    @Operation(summary = "Lista todas as moedas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de moedas",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Moeda.class)))
    @GetMapping
    public List<Moeda> listar() {
        return moedaService.listar();
    }
}