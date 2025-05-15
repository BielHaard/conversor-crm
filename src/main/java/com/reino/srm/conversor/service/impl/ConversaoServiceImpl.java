package com.reino.srm.conversor.service.impl;

import com.reino.srm.conversor.exception.MoedaNaoEncontradaException;
import com.reino.srm.conversor.exception.ProdutoNaoEncontradoException;
import com.reino.srm.conversor.exception.TaxaCambioNaoEncontradaException;
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
    public Transacao converter(String produtoNome, String moedaOrigem, String moedaDestino, BigDecimal valor, String reino) {
        Produto produto = produtoRepo.findByNomeIgnoreCase(produtoNome)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoNome));

        Moeda origem = moedaRepo.findBySimboloIgnoreCase(moedaOrigem)
                .orElseThrow(() -> new MoedaNaoEncontradaException(moedaOrigem, "de origem"));

        Moeda destino = moedaRepo.findBySimboloIgnoreCase(moedaDestino)
                .orElseThrow(() -> new MoedaNaoEncontradaException(moedaDestino, "de destino"));

        LocalDate hoje = LocalDate.now();

        TaxaCambio taxa = taxaRepo.findByMoedaOrigemAndMoedaDestinoAndProdutoAndData(origem, destino, produto, hoje)
                .orElseThrow(TaxaCambioNaoEncontradaException::new);

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
