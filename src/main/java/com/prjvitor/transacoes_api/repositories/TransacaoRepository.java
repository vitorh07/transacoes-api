package com.prjvitor.transacoes_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjvitor.transacoes_api.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    List<Transacao> findByContaOrigemId(Long contaOrigemId);
    List<Transacao> findByContaDestinoId(Long contaDestinoId);
}
