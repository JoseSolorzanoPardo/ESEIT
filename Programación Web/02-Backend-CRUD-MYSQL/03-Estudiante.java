/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitual.backendPlaneacion.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    private int edad;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String carrera;

    private LocalDateTime fechaRegistro;

    private boolean activo;
    
        // --- Constructores ---
    public Estudiante() {
        this.fechaRegistro = LocalDateTime.now();
        this.activo = true;
    }

    public Estudiante(String nombre, String apellido, String email, int edad, LocalDate fechaNacimiento, String telefono, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.carrera = carrera;
        this.fechaRegistro = LocalDateTime.now();
        this.activo = true;
    }
    
}
