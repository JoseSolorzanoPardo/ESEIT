/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardinalidadPlaneacion.cardinalidadPlaneacion.service;

import com.cardinalidadPlaneacion.cardinalidadPlaneacion.model.Curso;
import com.cardinalidadPlaneacion.cardinalidadPlaneacion.model.Docente;
import com.cardinalidadPlaneacion.cardinalidadPlaneacion.repository.CursoRepository;
import com.cardinalidadPlaneacion.cardinalidadPlaneacion.repository.DocenteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepo;
    private final CursoRepository cursoRepo;

    //  Constructor con inyección de dependencias
    public DocenteService(DocenteRepository docenteRepo, CursoRepository cursoRepo) {
        this.docenteRepo = docenteRepo;
        this.cursoRepo = cursoRepo;
    }

    //  Crear docente
    public Docente crearDocente(Docente docente) {
        return docenteRepo.save(docente);
    }

    //  Listar todos los docentes
    public List<Docente> listarDocentes() {
        return docenteRepo.findAll();
    }

    public Docente buscarPorId(Long id) {
        return docenteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
    }

    // Asignar curso a un docente
    public Curso asignarCurso(Long docenteId, Curso curso) {
        Docente docente = buscarPorId(docenteId);
        curso.setDocente_id(docente.getId());
        return cursoRepo.save(curso);
    }

    // Listar cursos de un docente
    public List<Curso> listarCursosDeDocente(Long docenteId) {

        if (docenteId == null) {
            throw new IllegalArgumentException("El ID del docente no puede ser nulo.");
        }

        List<Curso> todosLosCursos = cursoRepo.findAll();

        List<Curso> cursosDelDocente = new ArrayList<>();
        for (Curso curso : todosLosCursos) {
            if (curso.getDocente_id() != null && curso.getDocente_id().equals(docenteId)) {
                cursosDelDocente.add(curso);
            }
        }

        return cursosDelDocente;
    }
}
