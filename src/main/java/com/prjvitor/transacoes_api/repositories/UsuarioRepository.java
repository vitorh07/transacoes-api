package com.prjvitor.transacoes_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjvitor.transacoes_api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
