package com.BinarySeint.vsCatalog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BinarySeint.vsCatalog.classes.Cupo;
import com.BinarySeint.vsCatalog.classes.Prestacion;
import com.BinarySeint.vsCatalog.repository.CupoRepository;
import com.BinarySeint.vsCatalog.repository.PrestacionRepository;

import java.util.List;

@Service
public class CatalogService {

    private final PrestacionRepository prestacionRepository;
    private final CupoRepository cupoRepository;

    public CatalogService(PrestacionRepository prestacionRepository, CupoRepository cupoRepository) {
        this.prestacionRepository = prestacionRepository;
        this.cupoRepository = cupoRepository;
    }

    public List<Prestacion> obtenerTodasLasPrestaciones() {
        return prestacionRepository.findAll();
    }

    @Transactional
    public Prestacion crearPrestacion(Prestacion prestacion) {
        return prestacionRepository.save(prestacion);
    }

    @Transactional
    public Prestacion actualizarPrecioPrestacion(Long id, Double nuevoPrecio) {
        Prestacion prestacion = prestacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestación no encontrada"));
        prestacion.setPrecio(nuevoPrecio);
        return prestacionRepository.save(prestacion);
    }

    @Transactional
    public Cupo consumirCupo(Long cupoId) {
        Cupo cupo = cupoRepository.findById(cupoId)
                .orElseThrow(() -> new RuntimeException("Cupo no encontrado"));
        
        if (!cupo.getDisponible()) {
            throw new RuntimeException("El cupo ya no está disponible");
        }
        
        cupo.setDisponible(false); 
        return cupoRepository.save(cupo);
    }
}