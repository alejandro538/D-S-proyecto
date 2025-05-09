package com.corhuila.electro_corhuila.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corhuila.electro_corhuila.domain.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);
}
