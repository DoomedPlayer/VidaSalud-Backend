package com.BinarySeint.vsCatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BinarySeint.vsCatalog.classes.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
}