package com.reino.srm.conversor.controller;

import com.reino.srm.conversor.model.Produto;
import com.reino.srm.conversor.service.ProdutoService;
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
@RequestMapping("/api/produtos")
@Tag(name = "Produtos", description = "Operações relacionadas aos produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Operation(summary = "Cria um novo produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto criado com sucesso",
                    content = @Content(schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @Operation(summary = "Lista todos os produtos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de produtos",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Produto.class)))
    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }
}