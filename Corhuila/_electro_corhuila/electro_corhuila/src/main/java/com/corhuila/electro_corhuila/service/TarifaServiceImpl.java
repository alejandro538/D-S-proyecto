package com.corhuila.electro_corhuila.service;

import com.corhuila.electro_corhuila.models.Tarifa;
import com.corhuila.electro_corhuila.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifaServiceImpl implements ITarifaService {

    private final TarifaRepository tarifaRepository;

    @Autowired
    public TarifaServiceImpl(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }

    // Crear una nueva tarifa
    @Override
    public Tarifa createTarifa(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    // Obtener una tarifa por el estrato
    @Override
    public Tarifa getTarifaByEstrato(int estrato) {
        return tarifaRepository.findByEstrato(estrato);
    }

    // Listar todas las tarifas
    @Override
    public List<Tarifa> listarTarifas() {
        return tarifaRepository.findAll();
    }

    // Obtener una tarifa por ID
    @Override
    public Optional<Tarifa> obtenerTarifa(Integer id) {
        return tarifaRepository.findById(id);
    }

    // Guardar una nueva tarifa
    @Override
    public Tarifa saveTarifa(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    // Eliminar una tarifa por ID
    @Override
    public void deleteTarifa(Integer id) {
        tarifaRepository.deleteById(id);
    }

    // Actualizar una tarifa
    @Override
    public Tarifa updateTarifa(Integer id, Tarifa tarifa) {
        if (tarifaRepository.existsById(id)) {
            tarifa.setId(id);  // Asegura que la tarifa tenga el mismo ID
            return tarifaRepository.save(tarifa);
        }
        return null; // Si no existe la tarifa, retornamos null
    }
}
