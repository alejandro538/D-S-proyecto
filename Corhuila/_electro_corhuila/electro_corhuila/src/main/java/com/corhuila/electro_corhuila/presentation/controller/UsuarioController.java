package com.corhuila.electro_corhuila.presentation.controller;
import com.corhuila.electro_corhuila.application.service.IUsuarioService;
import com.corhuila.electro_corhuila.domain.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = usuarioService.register(usuario);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }
}
