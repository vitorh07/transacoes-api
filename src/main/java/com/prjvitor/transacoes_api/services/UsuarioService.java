package com.prjvitor.transacoes_api.services;

import org.springframework.stereotype.Service;

import com.prjvitor.transacoes_api.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
