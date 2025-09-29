/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitual.backendPlaneacion.Service;

import com.vitual.backendPlaneacion.Model.Estudiante;
import com.vitual.backendPlaneacion.Repository.EstudianteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
     private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public List<Estudiante> listarTodos() {
        return repo.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    public Estudiante buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
