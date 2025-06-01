package com.prjvitor.transacoes_api.services;

import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    
    private final TransacaoService transacaoService;

    public TransacaoService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }
}
