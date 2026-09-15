package com.BinarySeint.vsCatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BinarySeint.vsCatalog.classes.Cupo;

@Repository
public interface CupoRepository extends JpaRepository<Cupo, Long> {
    List<Cupo> findByBoxIdAndDisponibleTrue(Long boxId);
}