/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardinalidadPlaneacion.cardinalidadPlaneacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    //  Relación Uno a Muchos con Curso
   /* @OneToMany(mappedBy = "docente")
    private List<Curso> cursos;*/
    
    @OneToMany
    @JoinColumn(name = "docente_id") // crea la FK en la tabla curso sin depender del atributo
    private List<Curso> cursos;

}
