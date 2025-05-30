package com.prjvitor.transacoes_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjvitor.transacoes_api.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}
