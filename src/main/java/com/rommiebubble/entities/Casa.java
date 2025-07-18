package com.rommiebubble.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "casas")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(unique = true, nullable = false)
    private String codigoAcceso;

    private LocalDate fechaCreacion;

    public Casa() {
    }

    public Casa(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDate.now();
        this.codigoAcceso = generarCodigoCorto();
    }

    private String generarCodigoCorto() {
        return "RB-" + java.util.UUID.randomUUID().toString()
                .replaceAll("-", "").substring(0, 6);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}