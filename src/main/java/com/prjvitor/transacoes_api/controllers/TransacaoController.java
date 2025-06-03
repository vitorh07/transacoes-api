package com.prjvitor.transacoes_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjvitor.transacoes_api.services.TransacaoService;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }
}
