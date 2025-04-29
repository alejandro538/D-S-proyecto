package com.corhuila.electro_corhuila.service;

import java.util.List;
import java.util.Optional;

import com.corhuila.electro_corhuila.models.User;

public interface IUserService {
// Crear un nuevo usuario
 User createUser(User user);
 
// Obtener todos los usuarios por estrato socioeconómico
List<User> getUsersBySocioeconomicStratum(int stratum);

// Obtener un usuario por su ID
User getUserById(int id);

// Listar todos los usuarios
List<User> listarUsuarios();

// Obtener un usuario por ID (optimizamos el uso de Optional para evitar null)
Optional<User> obtenerUsuario(Integer id);

// Guardar un nuevo usuario
User saveUser(User user);

// Eliminar un usuario por ID
void deleteUser(Integer id);

// Actualizar un usuario
User updateUser(Integer id, User user);

}
