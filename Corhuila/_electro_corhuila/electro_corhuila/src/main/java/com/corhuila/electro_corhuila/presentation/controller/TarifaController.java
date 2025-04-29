package com.corhuila.electro_corhuila.presentation.controller;

import com.corhuila.electro_corhuila.application.service.ITarifaService;
import com.corhuila.electro_corhuila.domain.models.Tarifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarifas") 
@CrossOrigin(origins = "http://localhost:4200") 
public class TarifaController {

    @Autowired
    private ITarifaService tarifaService;

    // Obtener todas las tarifas
    @GetMapping("/all")
    public List<Tarifa> getAllTarifas() {
        return tarifaService.listarTarifas();
    }

    // Obtener una tarifa por estrato
    @GetMapping("/estrato/{estrato}")
    public ResponseEntity<Tarifa> getTarifaByEstrato(@PathVariable("estrato") int estrato) {
        Tarifa tarifa = tarifaService.getTarifaByEstrato(estrato);
        return tarifa != null ? new ResponseEntity<>(tarifa, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear una nueva tarifa
    @PostMapping
    public ResponseEntity<Tarifa> createTarifa(@RequestBody Tarifa tarifa) {
        Tarifa createdTarifa = tarifaService.saveTarifa(tarifa);
        return new ResponseEntity<>(createdTarifa, HttpStatus.CREATED);
    }

    // Actualizar una tarifa existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarifa> updateTarifa(@PathVariable("id") int id, @RequestBody Tarifa tarifa) {
        Tarifa updatedTarifa = tarifaService.updateTarifa(id, tarifa);
        return updatedTarifa != null ? new ResponseEntity<>(updatedTarifa, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar una tarifa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarifa(@PathVariable("id") int id) {
        tarifaService.deleteTarifa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
