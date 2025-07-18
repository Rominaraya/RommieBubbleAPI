package com.rommiebubble.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "casa_id")
    private Casa casa;

    // Constructor vacío requerido por JPA
    public Usuario() {}

    // Constructor personalizado
    public Usuario(String nombre, String email, Casa casa) {
        this.nombre = nombre;
        this.email = email;
        this.casa = casa;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }
}