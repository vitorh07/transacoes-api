package com.prjvitor.transacoes_api.controllers;

import com.prjvitor.transacoes_api.entities.Conta;
import com.prjvitor.transacoes_api.services.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<Conta> criar(@RequestBody Conta conta) {
        return ResponseEntity.ok(contaService.criarConta(conta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        return contaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Conta> listarTodas() {
        return contaService.listarTodas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizar(@PathVariable Long id, @RequestBody Conta conta) {
        try {
            return ResponseEntity.ok(contaService.atualizarConta(id, conta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contaService.deletarConta(id);
        return ResponseEntity.noContent().build();
    }
}