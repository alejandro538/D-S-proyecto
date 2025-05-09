package com.corhuila.electro_corhuila.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corhuila.electro_corhuila.repository.*;
import com.corhuila.electro_corhuila.domain.models.User;
@Service
public class UserServicempl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    // Crear un nuevo usuario
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Obtener todos los usuarios por estrato socioeconómico
    @Override
    public List<User> getUsersBySocioeconomicStratum(int socioeconomicStratum) {
        return userRepository.findBySocioeconomicStratum(socioeconomicStratum);
    }

    // Obtener un usuario por su ID
    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);  // Retorna null si no se encuentra el usuario
    }

    // Listar todos los usuarios
    @Override
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    // Obtener un usuario por ID (usando Optional para evitar null)
    @Override
    public Optional<User> obtenerUsuario(Integer id) {
        return userRepository.findById(id);
    }

    // Guardar un nuevo usuario
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Eliminar un usuario por ID
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Actualizar un usuario
    @Override
    public User updateUser(Integer id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);  // Asegura que el usuario tenga el mismo ID
            return userRepository.save(user);
        }
        return null; // Si no existe el usuario, retornamos null
    }
}
