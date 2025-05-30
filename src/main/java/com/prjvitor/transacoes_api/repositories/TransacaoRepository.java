package com.prjvitor.transacoes_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjvitor.transacoes_api.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    
}
