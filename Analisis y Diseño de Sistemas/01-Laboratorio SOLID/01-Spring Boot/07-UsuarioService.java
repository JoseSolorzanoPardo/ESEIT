/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DASistemas.DASistemas.Repository.Service;

import com.DASistemas.DASistemas.Repository.UsuarioRepository;
import com.DASistemas.DASistemas.model.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/*
 * La anotación @Service indica que esta clase es un componente de "servicio"
 * dentro de Spring. Es parte de la capa de negocio/lógica.
 * Spring la detecta automáticamente y la gestiona como un "bean".
 */
@Service
public class UsuarioService {
    
    // Inyección de dependencias:
    // repo es una instancia de UsuarioRepository (DAO) que maneja las operaciones con MongoDB.
    private final UsuarioRepository repo;

    // Constructor: Spring inyecta automáticamente una implementación de UsuarioRepository
    // cuando crea este servicio (gracias a la anotación @Service y @Repository).
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }
    
    /*
     * Método de servicio que retorna todos los usuarios de la colección.
     * Internamente usa repo.findAll(), que es un método ya definido por MongoRepository.
     * 
     * Cuando un controlador llame a este servicio, recibirá la lista completa
     * de documentos Usuario que estén almacenados en MongoDB.
     */
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }
}
