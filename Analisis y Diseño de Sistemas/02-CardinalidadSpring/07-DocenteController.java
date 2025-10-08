/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardinalidadPlaneacion.cardinalidadPlaneacion.controller;

import com.cardinalidadPlaneacion.cardinalidadPlaneacion.model.Curso;
import com.cardinalidadPlaneacion.cardinalidadPlaneacion.model.Docente;
import com.cardinalidadPlaneacion.cardinalidadPlaneacion.service.DocenteService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {
   private final DocenteService docenteService;

    // Inyección del servicio
    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    // Crear docente
    @PostMapping
    public Docente crearDocente(@RequestBody Docente docente) {
        return docenteService.crearDocente(docente);
    }

    // Listar docentes
    @GetMapping
    public List<Docente> listarDocentes() {
        return docenteService.listarDocentes();
    }

       // Crear curso asociado a un docente
    @PostMapping("/{id}/cursos")
    public Curso asignarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return docenteService.asignarCurso(id, curso);
    }

    // Listar cursos de un docente
    @GetMapping("/{id}/cursos")
    public List<Curso> listarCursosDeDocente(@PathVariable Long id) {
        return docenteService.listarCursosDeDocente(id);
    }
    
    
}
