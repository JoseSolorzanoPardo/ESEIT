/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitual.backendPlaneacion.Repository;

import com.vitual.backendPlaneacion.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jose Hember
 */
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
}
