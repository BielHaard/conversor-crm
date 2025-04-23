package com.reino.srm.conversor.controller;

import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.service.MoedaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moedas")
public class MoedaController {
    private final MoedaService moedaService;

    public MoedaController(MoedaService moedaService) {
        this.moedaService = moedaService;
    }

    @PostMapping
    public ResponseEntity<Moeda> criar(@RequestBody Moeda moeda) {
        return ResponseEntity.ok(moedaService.salvar(moeda));
    }

    @GetMapping
    public List<Moeda> listar() {
        return moedaService.listar();
    }
}
