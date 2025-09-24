/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DASistemas.DASistemas.Repository;

// Importamos la interfaz MongoRepository de Spring Data MongoDB.
// Esta interfaz nos da métodos CRUD (crear, leer, actualizar, eliminar) listos para usar.
import org.springframework.data.mongodb.repository.MongoRepository;

import com.DASistemas.DASistemas.model.Usuario;

/**
 * Interfaz UsuarioRepository
 * 
 * Extiende de MongoRepository, lo que significa que automáticamente
 * tendrá operaciones básicas sobre la colección "usuarios" en MongoDB.
 * 
 * Parámetros genéricos:
 *  - Usuario → la clase que representa el documento de Mongo (nuestra entidad).
 *  - String → el tipo de dato de la clave primaria (@Id), en este caso un String.
 * 
 * Spring Data genera la implementación de esta interfaz en tiempo de ejecución,
 * así que no es necesario escribir código adicional para operaciones básicas.
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    
 
}
