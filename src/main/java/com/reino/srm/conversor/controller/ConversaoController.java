package com.reino.srm.conversor.controller;

import com.reino.srm.conversor.dto.ConversaoRequestDTO;
import com.reino.srm.conversor.dto.TransacaoResponseDTO;
import com.reino.srm.conversor.model.Transacao;
import com.reino.srm.conversor.service.ConversaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversao")
public class ConversaoController {
    private final ConversaoService conversaoService;

    public ConversaoController(ConversaoService conversaoService) {
        this.conversaoService = conversaoService;
    }

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