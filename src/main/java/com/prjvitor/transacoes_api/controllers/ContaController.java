package com.prjvitor.transacoes_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjvitor.transacoes_api.services.ContaService;

@RestController
@RequestMapping("/api/contas")
public class ContaController {
    
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }
}
