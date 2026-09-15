package com.BinarySeint.vsCatalog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BinarySeint.vsCatalog.classes.Cupo;
import com.BinarySeint.vsCatalog.classes.Prestacion;
import com.BinarySeint.vsCatalog.service.CatalogService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/services")
    public ResponseEntity<List<Prestacion>> getServices() {
        return ResponseEntity.ok(catalogService.obtenerTodasLasPrestaciones());
    }

    @PostMapping("/services")
    public ResponseEntity<Prestacion> createService(@RequestBody Prestacion prestacion) {
        return ResponseEntity.ok(catalogService.crearPrestacion(prestacion));
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Prestacion> updateServicePrice(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        Double nuevoPrecio = body.get("precio");
        return ResponseEntity.ok(catalogService.actualizarPrecioPrestacion(id, nuevoPrecio));
    }

    @PutMapping("/cupos/{cupoId}/consumir")
    public ResponseEntity<Cupo> consumeCupo(@PathVariable Long cupoId) {
        return ResponseEntity.ok(catalogService.consumirCupo(cupoId));
    }
}