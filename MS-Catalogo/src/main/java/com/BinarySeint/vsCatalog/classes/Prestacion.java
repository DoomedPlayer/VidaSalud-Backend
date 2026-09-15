package com.BinarySeint.vsCatalog.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "prestaciones")
public class Prestacion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    private Double precio;
    @Column(length = 255)
    private String descripcion;


    public Prestacion(){}

    public Prestacion(Long id,String nombre,Double precio,String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion=descripcion;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre =nombre;
    }
    public Double getPrecio(){
        return precio;
    }
    public void setPrecio(Double precio){
        this.precio = precio;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion =descripcion;
    }
}
