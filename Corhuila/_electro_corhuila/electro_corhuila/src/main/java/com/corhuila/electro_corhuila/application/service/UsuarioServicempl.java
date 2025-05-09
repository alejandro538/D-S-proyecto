package com.corhuila.electro_corhuila.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.electro_corhuila.domain.models.Usuario;
import com.corhuila.electro_corhuila.repository.UsuarioRepository;

@Service
public class UsuarioServicempl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Constructor para la inyección de dependencias
    @Autowired
    public UsuarioServicempl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario register(Usuario usuario) {
        // Aquí se puede agregar la lógica adicional que desees (validación, etc.)
        return usuarioRepository.save(usuario);  // Guardar el usuario en la base de datos
    }
}
