package com.prjvitor.transacoes_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prjvitor.transacoes_api.entities.Conta;
import com.prjvitor.transacoes_api.repositories.ContaRepository;

@Service
public class ContaService {
    
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    // Métodos
    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }

    public List<Conta> listarTodas() {
        return contaRepository.findAll();
    }

    public Conta atualizarConta(Long id, Conta contaAtualizada) {
        return contaRepository.findById(id)
            .map(conta -> {
                conta.setSaldo(contaAtualizada.getSaldo());
                return contaRepository.save(conta);
            })
            .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public void deletarConta(Long id) {
        contaRepository.deleteById(id);
    }
}