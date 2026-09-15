package com.BinarySeint.vsReportes.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BinarySeint.vsReportes.DTO.AtencionEventDto;
import com.BinarySeint.vsReportes.classes.KpiAtenciones;
import com.BinarySeint.vsReportes.repository.KpiAtencionesRepository;

import java.time.LocalDate;

@Service
public class ReportKafkaConsumer {

    private final KpiAtencionesRepository kpiRepository;

    public ReportKafkaConsumer(KpiAtencionesRepository kpiRepository) {
        this.kpiRepository = kpiRepository;
    }

    @KafkaListener(topics = "appointments.events", groupId = "report-group")
    @Transactional
    public void procesarEventoAtencion(AtencionEventDto evento) {
        LocalDate hoy = LocalDate.now();
        KpiAtenciones kpi = kpiRepository.findByFecha(hoy)
                .orElse(new KpiAtenciones());
        kpi.setFecha(hoy);

        switch (evento.getEstado()) {
            case "SOLICITADA":
                kpi.setAtencionesSolicitadas(kpi.getAtencionesSolicitadas() + 1);
                break;
            case "CONFIRMADA":
                kpi.setAtencionesConfirmadas(kpi.getAtencionesConfirmadas() + 1);
                break;
            case "CERRADA":
                kpi.setAtencionesCerradas(kpi.getAtencionesCerradas() + 1);
                // Aquí podrías incluir lógica compleja para calcular el tiempo de espera[cite: 1] 
                // restando la fechaHora de cierre con la fechaHora de admisión.
                break;
            // ... otros estados ...
        }

        kpiRepository.save(kpi);
    }
}