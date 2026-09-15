package com.BinarySeint.vsAuditorias.classes;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria_eventos")
public class EventoAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private String usuarioId; 

    @Column(nullable = false)
    private String accion; 

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora; 

    @Column(name = "origen_ip")
    private String origenIp; 

    @Column(name = "entidad_id")
    private String entidadId; 
    
    @Column(columnDefinition = "TEXT")
    private String detalles; 

    public EventoAuditoria() {}

    public EventoAuditoria(Long id,String usuarioId,String accion,LocalDateTime fecha,String ip,String entidadId,String detalles){
        this.id=id;
        this.usuarioId=usuarioId;
        this.accion=accion;
        this.fechaHora=fecha;
        this.origenIp=ip;
        this.entidadId=entidadId;
        this.detalles=detalles;
    }

    public Long getId(){
        return id;
    }
    public String getUsuarioId(){
        return usuarioId;
    }
    public void setUsuarioId(String usuario){
        this.usuarioId=usuario;
    }
    public String getAccion(){
        return accion;
    }
    public void setAccion(String accion){
        this.accion=accion;
    }
    public LocalDateTime getFechaHora(){
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fecha){
        this.fechaHora=fecha;
    }
    public String getOrigenIp(){
        return origenIp;
    }
    public void setOrigenIp(String ip){
        this.origenIp=ip;
    }
    public String getEntidadId(){
        return entidadId;
    }
    public void setEntidadId(String entidad){
        this.entidadId=entidad;
    }
    public String getDetalles(){
        return detalles;
    }
    public void setDetalles(String detalles){
        this.detalles=detalles;
    }

}