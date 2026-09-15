package com.BinarySeint.vsAuditorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BinarySeint.vsAuditorias.classes.EventoAuditoria;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditoriaRepository extends JpaRepository<EventoAuditoria, Long> {
    List<EventoAuditoria> findByUsuarioId(String usuarioId);
    List<EventoAuditoria> findByAccion(String accion);
    List<EventoAuditoria> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
}