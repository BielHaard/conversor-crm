package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.model.Moeda;
import com.reino.srm.conversor.model.Produto;
import com.reino.srm.conversor.model.TaxaCambio;
import com.reino.srm.conversor.model.Transacao;
import com.reino.srm.conversor.repository.MoedaRepository;
import com.reino.srm.conversor.repository.ProdutoRepository;
import com.reino.srm.conversor.repository.TaxaCambioRepository;
import com.reino.srm.conversor.repository.TransacaoRepository;
import com.reino.srm.conversor.service.ConversaoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ConversaoServiceImpl implements ConversaoService {

    private final TaxaCambioRepository taxaRepo;
    private final TransacaoRepository transacaoRepo;
    private final ProdutoRepository produtoRepo;
    private final MoedaRepository moedaRepo;

    public ConversaoServiceImpl(TaxaCambioRepository taxaRepo,
                            TransacaoRepository transacaoRepo,
                            ProdutoRepository produtoRepo,
                            MoedaRepository moedaRepo) {
        this.taxaRepo = taxaRepo;
        this.transacaoRepo = transacaoRepo;
        this.produtoRepo = produtoRepo;
        this.moedaRepo = moedaRepo;
    }

    @Override
    @Transactional
    public Transacao converter(Produto produtoTransaction, Moeda moedaOrigem, Moeda moedaDestino, BigDecimal valor, String reino) {
        Produto produto = produtoRepo.findByNomeIgnoreCase(produtoTransaction.getNome())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + produtoTransaction.getNome()));

        Moeda origem = moedaRepo.findBySimboloIgnoreCase(moedaOrigem.getSimbolo())
                .orElseThrow(() -> new IllegalArgumentException("Moeda de origem não encontrada: " + moedaOrigem));

        Moeda destino = moedaRepo.findBySimboloIgnoreCase(moedaDestino.getSimbolo())
                .orElseThrow(() -> new IllegalArgumentException("Moeda de destino não encontrada: " + moedaDestino));

        LocalDate hoje = LocalDate.now();

        TaxaCambio taxa = taxaRepo.findByMoedaOrigemAndMoedaDestinoAndProdutoAndData(origem, destino, produto, hoje)
                .orElseThrow(() -> new IllegalArgumentException("Taxa de câmbio não encontrada para o dia de hoje."));

        BigDecimal valorConvertido = valor.multiply(taxa.getTaxa());

        Transacao transacao = new Transacao();
        transacao.setProduto(produto);
        transacao.setMoedaOrigem(origem);
        transacao.setMoedaDestino(destino);
        transacao.setValorOrigem(valor);
        transacao.setValorDestino(valorConvertido);
        transacao.setReino(reino);
        transacao.setDataHora(java.time.LocalDateTime.now());

        return transacaoRepo.save(transacao);
    }
}
