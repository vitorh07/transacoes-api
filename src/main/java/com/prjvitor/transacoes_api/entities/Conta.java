package com.prjvitor.transacoes_api.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Usuario usuario;

    private BigDecimal saldo = BigDecimal.ZERO;

    private TipoConta tipoConta;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public enum TipoConta {
        CORRENTE,
        POUPANCA
    }
}
