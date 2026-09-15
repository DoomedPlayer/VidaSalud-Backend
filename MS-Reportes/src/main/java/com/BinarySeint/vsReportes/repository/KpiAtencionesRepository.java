package com.BinarySeint.vsReportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BinarySeint.vsReportes.classes.KpiAtenciones;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface KpiAtencionesRepository extends JpaRepository<KpiAtenciones, Long> {
    Optional<KpiAtenciones> findByFecha(LocalDate fecha);
}
