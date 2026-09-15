package com.BinarySeint.vsAuditorias.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BinarySeint.vsAuditorias.classes.EventoAuditoria;
import com.BinarySeint.vsAuditorias.repository.AuditoriaRepository;

@Service
public class AuditoriaKafkaConsumer {

    private final AuditoriaRepository auditoriaRepository;

    public AuditoriaKafkaConsumer(AuditoriaRepository auditoriaRepository) {
        this.auditoriaRepository = auditoriaRepository;
    }

    // Escucha el tópico configurado para el historial de auditoría[cite: 1]
    @KafkaListener(topics = "audit.timeline", groupId = "audit-group")
    @Transactional
    public void consumirEventoAuditoria(EventoAuditoria evento) {
        System.out.println("Registrando evento de auditoría: " + evento.getAccion());
        auditoriaRepository.save(evento);
    }
}