package com.BinarySeint.vsReportes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BinarySeint.vsReportes.classes.KpiAtenciones;
import com.BinarySeint.vsReportes.repository.KpiAtencionesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final KpiAtencionesRepository kpiRepository;

    public ReportController(KpiAtencionesRepository kpiRepository) {
        this.kpiRepository = kpiRepository;
    }

    @GetMapping("/kpis/today")
    public ResponseEntity<KpiAtenciones> getKpisToday() {
        Optional<KpiAtenciones> kpi = kpiRepository.findByFecha(LocalDate.now());
        return kpi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/kpis")
    public ResponseEntity<List<KpiAtenciones>> getAllKpis() {
        return ResponseEntity.ok(kpiRepository.findAll());
    }

    @GetMapping("/top-services")
    public ResponseEntity<String> getTopServices(@RequestParam(required = false, defaultValue = "last7d") String range) {
        return ResponseEntity.ok("Endpoint para prestaciones más demandadas. Rango: " + range);
    }
}