package com.prjvitor.transacoes_api.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prjvitor.transacoes_api.entities.Conta;
import com.prjvitor.transacoes_api.entities.Transacao;
import com.prjvitor.transacoes_api.entities.Transacao.TipoTransacao;
import com.prjvitor.transacoes_api.repositories.ContaRepository;
import com.prjvitor.transacoes_api.repositories.TransacaoRepository;

@Service
public class TransacaoService {
    
    private final TransacaoRepository transacaoRepository;
    private final ContaRepository contaRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, ContaRepository contaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
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

    public Transacao transferir(Long contaOrigemId, Long contaDestinoId, BigDecimal valor, String descricao) {
        Conta contaOrigem = contaRepository.findById(contaOrigemId)
            .orElseThrow(() -> new RuntimeException("Conta de origem não encontrada"));
        Conta contaDestino = contaRepository.findById(contaDestinoId)
            .orElseThrow(() -> new RuntimeException("Conta de destino não encontrada"));

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente na conta de origem");
        }
        
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O valor da transferência deve ser maior que zero");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);

        Transacao transacao = new Transacao();
        transacao.setContaOrigem(contaOrigem);
        transacao.setContaDestino(contaDestino);
        transacao.setValor(valor);
        transacao.setTipoTransacao(TipoTransacao.TRANSFERENCIA);
        transacao.setDescricao(descricao);
        transacao.setDataTransacao(java.time.LocalDateTime.now());

        return transacaoRepository.save(transacao);
    }
}