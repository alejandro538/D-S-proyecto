package com.corhuila.electro_corhuila.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corhuila.electro_corhuila.models.Tarifa;

public interface TarifaRepository  extends JpaRepository<Tarifa, Integer> {
    Tarifa findByEstrato(int estrato);
    
}
