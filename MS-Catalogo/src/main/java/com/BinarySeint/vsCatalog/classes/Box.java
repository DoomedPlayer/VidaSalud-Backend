package com.BinarySeint.vsCatalog.classes;

import jakarta.persistence.*;

@Entity 
@Table(name = "boxes")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo; 

    @Column(nullable = false)
    private String centroAtencion; 

    public Box() {}

    public Box(Long id, String codigo,String centroAtencion){
        this.id = id;
        this.codigo = codigo;
        this.centroAtencion=centroAtencion;
    }

    public String getCodigo(){
        return  codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public String getCentroAtencion(){
        return centroAtencion;
    }
    public void setCentroAtencion(String centro){
        this.centroAtencion=centro;
    }

}