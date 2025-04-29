package com.corhuila.electro_corhuila.service;

import com.corhuila.electro_corhuila.models.Tarifa;

import java.util.List;
import java.util.Optional;

public interface ITarifaService {

    // Crear una nueva tarifa
    Tarifa createTarifa(Tarifa tarifa);

    // Obtener una tarifa por el estrato
    Tarifa getTarifaByEstrato(int estrato);

    // Listar todas las tarifas
    List<Tarifa> listarTarifas();

    // Obtener una tarifa por ID
    Optional<Tarifa> obtenerTarifa(Integer id);

    // Guardar una nueva tarifa
    Tarifa saveTarifa(Tarifa tarifa);

    // Eliminar una tarifa por ID
    void deleteTarifa(Integer id);

    // Actualizar una tarifa
    Tarifa updateTarifa(Integer id, Tarifa tarifa);
}
