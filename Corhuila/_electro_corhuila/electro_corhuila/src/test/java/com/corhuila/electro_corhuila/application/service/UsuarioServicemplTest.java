package com.corhuila.electro_corhuila.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.corhuila.electro_corhuila.domain.models.Usuario;
import com.corhuila.electro_corhuila.repository.UsuarioRepository;

public class UsuarioServicemplTest {
    @InjectMocks
    private UsuarioServicempl usuarioServicempl;
    @Mock
    private UsuarioRepository UsuarioRepository;
    private Usuario usuario;

@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }


    @Test
    void testRegister() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Alejandro");
        usuario.setCorreo("alejandro@corhuila.com");
        usuario.setContrasena("12345678");
        usuario.setRol("ADMIN");
       


        when( UsuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        Usuario resultado = usuarioServicempl.register(usuario);
        
            assertNotNull(resultado);
        assertEquals("Alejandro Ortiz", resultado.getNombre());
        assertEquals("alejandro@correo.com", resultado.getCorreo());
        verify(UsuarioRepository, times(1)).save(usuario);
    }

}
