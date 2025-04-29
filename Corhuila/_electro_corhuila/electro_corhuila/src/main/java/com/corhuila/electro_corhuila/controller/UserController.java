package com.corhuila.electro_corhuila.controller;

import com.corhuila.electro_corhuila.models.User;
import com.corhuila.electro_corhuila.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users") 
@CrossOrigin(origins = "http://localhost:4200") 
public class UserController {

    @Autowired
    private IUserService userService;

    // Obtener todos los usuarios
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.listarUsuarios();
    }
    

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        Optional<User> user = userService.obtenerUsuario(id);
        return user.isPresent() ? new ResponseEntity<>(user.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return updatedUser != null ? new ResponseEntity<>(updatedUser, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener todos los usuarios por estrato socioeconómico
    @GetMapping("/stratum/{stratum}")
    public ResponseEntity<List<User>> getUsersBySocioeconomicStratum(@PathVariable("stratum") int stratum) {
        List<User> users = userService.getUsersBySocioeconomicStratum(stratum);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
