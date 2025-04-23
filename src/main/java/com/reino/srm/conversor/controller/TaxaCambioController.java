package com.reino.srm.conversor.controller;

import com.reino.srm.conversor.model.TaxaCambio;
import com.reino.srm.conversor.service.TaxaCambioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxas-cambio")
public class TaxaCambioController {
    private final TaxaCambioService taxaCambioService;

    public TaxaCambioController(TaxaCambioService taxaCambioService) {
        this.taxaCambioService = taxaCambioService;
    }

    @PostMapping
    public ResponseEntity<TaxaCambio> criar(@RequestBody TaxaCambio taxa) {
        return ResponseEntity.ok(taxaCambioService.salvar(taxa));
    }

    @GetMapping
    public List<TaxaCambio> listar() {
        return taxaCambioService.listar();
    }
}
