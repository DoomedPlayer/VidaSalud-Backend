package com.BinarySeint.vsReportes.classes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kpi_atenciones")
public class KpiAtenciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private LocalDate fecha;

    private Integer atencionesSolicitadas = 0;
    private Integer atencionesConfirmadas = 0;
    private Integer atencionesEnEspera = 0;
    private Integer atencionesCerradas = 0;
    private Integer atencionesCanceladas = 0;
    
    private Double tiempoPromedioEsperaMinutos = 0.0;


    public KpiAtenciones(){}
    public KpiAtenciones(Long id, LocalDate fecha, Integer atencionSol,Integer atencionCon,Integer atencionesEsp,Integer atencionCerr,Integer antencionCan, Double tiempoEsp){
        this.id=id;
        this.fecha=fecha;
        this.atencionesSolicitadas=atencionSol;
        this.atencionesConfirmadas=atencionCon;
        this.atencionesCerradas=atencionCerr;
        this.atencionesCanceladas=antencionCan;
        this.tiempoPromedioEsperaMinutos=tiempoEsp;
    }

    public Long getId(){
        return id;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }
    public Integer getAtencionesSolicitadas(){
        return atencionesSolicitadas;
    }
    public void setAtencionesSolicitadas(Integer atencionSol){
        this.atencionesSolicitadas=atencionSol;
    }
    public Integer getAtencionesEnEspera(){
        return atencionesEnEspera;
    }
    public void setAtencionesEnEspera(Integer atencionEsp){
        this.atencionesEnEspera=atencionEsp;
    }
    public Integer getAtencionesConfirmadas(){
        return atencionesConfirmadas;
    }
    public void setAtencionesConfirmadas(Integer atencionCon){
        this.atencionesConfirmadas=atencionCon;
    }
    public Integer getAtencionesCerradas(){
        return atencionesCerradas;
    }
    public void setAtencionesCerradas(Integer atencionCerr){
        this.atencionesCerradas=atencionCerr;
    }
    public Integer getAtencionesCanceladas(){
        return atencionesCanceladas;
    }
    public void setAtencionesCanceladas(Integer atencionCan){
        this.atencionesCanceladas=atencionCan;
    }
    public Double getTiempoPromedioEsperaMinutos(){
        return tiempoPromedioEsperaMinutos;
    }
    public void setTiempoPromedioEsperaMinutos(Double tiempoEsp){
        this.tiempoPromedioEsperaMinutos=tiempoEsp;
    }
}