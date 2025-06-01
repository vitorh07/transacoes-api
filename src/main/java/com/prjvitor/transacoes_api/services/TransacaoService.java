package com.prjvitor.transacoes_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prjvitor.transacoes_api.entities.Transacao;
import com.prjvitor.transacoes_api.repositories.TransacaoRepository;

@Service
public class TransacaoService {
    
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    // Métodos
    public Transacao criarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public Optional<Transacao> buscarPorId(Long id) {
        return transacaoRepository.findById(id);
    }

    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }

    public Transacao atualizarTransacao(Long id, Transacao transacaoAtualizada) {
        return transacaoRepository.findById(id)
            .map(transacao -> {
                transacao.setDescricao(transacaoAtualizada.getDescricao());
                transacao.setValor(transacaoAtualizada.getValor());
                transacao.setDataTransacao(transacaoAtualizada.getDataTransacao());
                return transacaoRepository.save(transacao);
            })
            .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public void deletarTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }
}