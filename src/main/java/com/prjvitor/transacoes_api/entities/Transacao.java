package com.prjvitor.transacoes_api.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Conta contaOrigem;
    private Conta contaDestino;
    private BigDecimal valor;
    
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;
    private String descricao;
    private LocalDateTime dataTransacao = LocalDateTime.now();

    public enum TipoTransacao {
        DEPOSITO,
        SAQUE,
        TRANSFERENCIA
    }
}
