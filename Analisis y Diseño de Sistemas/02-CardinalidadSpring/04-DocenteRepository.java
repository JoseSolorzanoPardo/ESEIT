/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardinalidadPlaneacion.cardinalidadPlaneacion.repository;

import com.cardinalidadPlaneacion.cardinalidadPlaneacion.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jose Hember
 */
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    
}
