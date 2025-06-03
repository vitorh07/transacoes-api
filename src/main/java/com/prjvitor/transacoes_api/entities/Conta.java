package com.prjvitor.transacoes_api.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private BigDecimal saldo = BigDecimal.ZERO;

    private TipoConta tipoConta;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public enum TipoConta {
        CORRENTE,
        POUPANCA
    }
}
