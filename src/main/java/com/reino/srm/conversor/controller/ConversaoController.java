package com.reino.srm.conversor.controller;

import com.reino.srm.conversor.dto.ConversaoRequestDTO;
import com.reino.srm.conversor.dto.TransacaoResponseDTO;
import com.reino.srm.conversor.model.Transacao;
import com.reino.srm.conversor.service.ConversaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversao")
@Tag(name = "Conversão", description = "Operações de conversão de moedas para produtos")
public class ConversaoController {

    private final ConversaoService conversaoService;

    public ConversaoController(ConversaoService conversaoService) {
        this.conversaoService = conversaoService;
    }

    @Operation(summary = "Realiza conversão de moeda para um produto", description = "Converte um valor de uma moeda de origem para uma moeda de destino com base na taxa de câmbio e produto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conversão realizada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransacaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Produto, moeda ou taxa de câmbio não encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content)
    })
    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> converter(@RequestBody ConversaoRequestDTO request) {
        Transacao transacao = conversaoService.converter(
                request.getProduto(), request.getMoedaOrigem(),
                request.getMoedaDestino(), request.getValor(),
                request.getReino()
        );
        return ResponseEntity.ok(new TransacaoResponseDTO(transacao));
    }
}
