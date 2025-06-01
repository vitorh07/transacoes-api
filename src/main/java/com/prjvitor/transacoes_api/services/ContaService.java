package com.prjvitor.transacoes_api.services;

import org.springframework.stereotype.Service;

@Service
public class ContaService {
    
    private final ContaService contaService;

    public ContaService(ContaService contaService) {
        this.contaService = contaService;
    }
}
