package com.prjvitor.transacoes_api.controllers;

import com.prjvitor.transacoes_api.entities.Transacao;
import com.prjvitor.transacoes_api.services.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Transacao> criar(@RequestBody Transacao transacao) {
        return ResponseEntity.ok(transacaoService.criarTransacao(transacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id) {
        return transacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Transacao> listarTodas() {
        return transacaoService.listarTodas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable Long id, @RequestBody Transacao transacao) {
        try {
            return ResponseEntity.ok(transacaoService.atualizarTransacao(id, transacao));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        transacaoService.deletarTransacao(id);
        return ResponseEntity.noContent().build();
    }
}