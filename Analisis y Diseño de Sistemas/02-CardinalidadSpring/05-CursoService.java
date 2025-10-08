/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardinalidadPlaneacion.cardinalidadPlaneacion.service;

import com.cardinalidadPlaneacion.cardinalidadPlaneacion.model.Curso;
import com.cardinalidadPlaneacion.cardinalidadPlaneacion.repository.CursoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
     private final CursoRepository cursoRepo;

    public CursoService(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    public List<Curso> listarCursos() {
        return cursoRepo.findAll();
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepo.save(curso);
    }
}
