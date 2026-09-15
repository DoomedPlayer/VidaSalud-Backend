package com.BinarySeint.vsReportes.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtencionEventDto {

    private String type;            
    private String eventId;         
    private LocalDateTime timestamp; 
    private String traceId;         
    private String correlationId;  

    private Long atencionId;
    private String pacienteId;
    private Long prestacionId;
    private Long cupoId;
    private String estado;

    public AtencionEventDto() {}

    public AtencionEventDto(String type, String correlationId, Long atencionId, String pacienteId, Long prestacionId, Long cupoId, String estado) {
        this.type = type;
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.traceId = UUID.randomUUID().toString(); 
        this.correlationId = correlationId;

        // Datos del payload
        this.atencionId = atencionId;
        this.pacienteId = pacienteId;
        this.prestacionId = prestacionId;
        this.cupoId = cupoId;
        this.estado = estado;
    }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getTraceId() { return traceId; }
    public void setTraceId(String traceId) { this.traceId = traceId; }

    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }

    public Long getAtencionId() { return atencionId; }
    public void setAtencionId(Long atencionId) { this.atencionId = atencionId; }

    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }

    public Long getPrestacionId() { return prestacionId; }
    public void setPrestacionId(Long prestacionId) { this.prestacionId = prestacionId; }

    public Long getCupoId() { return cupoId; }
    public void setCupoId(Long cupoId) { this.cupoId = cupoId; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}