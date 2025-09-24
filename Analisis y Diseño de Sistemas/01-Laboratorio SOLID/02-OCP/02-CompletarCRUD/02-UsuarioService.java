package com.DASistemas.DASistemas.Repository.Service;

import com.DASistemas.DASistemas.Repository.UsuarioRepository;
import com.DASistemas.DASistemas.model.Usuario;

import java.util.List;
import org.springframework.stereotype.Service;

/*
 * @Service -> indica que esta clase pertenece a la capa de servicio (lógica de negocio).
 * Spring detecta automáticamente esta clase y la administra como un "bean".
 * 
 * La capa de servicio actúa como intermediaria entre el controlador y el repositorio,
 * delegando las operaciones de acceso a datos al repositorio y aplicando lógica si es necesario.
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
     * Retorna todos los usuarios de la colección.
     * Usa el método findAll() de MongoRepository, que ya está implementado.
     */
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    /*
     * Guarda un nuevo usuario en la colección (o actualiza uno existente si el id coincide).
     * repo.save() -> inserta o actualiza según corresponda.
     */
    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    /*
     * Elimina un usuario de la colección según su id.
     * repo.deleteById() -> borra directamente en MongoDB.
     */
    public void eliminarPorId(String id) {
        repo.deleteById(id);
    }

    /*
     * Busca un usuario en la colección por su id.
     * Si lo encuentra, lo retorna.
     * Si no existe, devuelve null.
     */
    public Usuario buscarPorId(String id) {
        return repo.findById(id).orElse(null);
    }
}
