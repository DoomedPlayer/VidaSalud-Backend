package com.BinarySeint.vsCatalog.classes;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cupos")
public class Cupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id", nullable = false)
    private Box box; 

    @Column(name = "fecha_hora_inicio", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin", nullable = false)
    private LocalDateTime fechaHoraFin;

    @Column(nullable = false)
    private Boolean disponible = true; 

    public Cupo() {}
    public Cupo(Long id,Box box, LocalDateTime fechaIncio,LocalDateTime fechaFin,Boolean disponible){
        this.id=id;
        this.box =box;
        this.fechaHoraInicio=fechaIncio;
        this.fechaHoraFin=fechaFin;
        this.disponible=disponible;
    }

    public Box getBox(){
        return box;
    }
    public void setBox(Box box){
        this.box=box;
    }
    public LocalDateTime getFechaHoraInicio(){
        return  fechaHoraInicio;
    }
    public void setFechaHoraInicio(LocalDateTime fechaIncio){
        this.fechaHoraInicio=fechaIncio;
    }
    public LocalDateTime getFechaHoraFin(){
        return fechaHoraFin;
    }
    public void setFechaHoraFin(LocalDateTime fechaFin){
        this.fechaHoraFin=fechaFin;
    }
    public Boolean getDisponible(){
        return disponible;
    }
    public void setDisponible(Boolean disponible){
        this.disponible=disponible;
    }
}