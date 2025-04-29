package com.corhuila.electro_corhuila.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corhuila.electro_corhuila.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findBySocioeconomicStratum (int socioeconomicStratum);
    
}
