package com.BinarySeint.vsCatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BinarySeint.vsCatalog.classes.Prestacion;

@Repository
public interface PrestacionRepository extends JpaRepository<Prestacion, Long> {
}