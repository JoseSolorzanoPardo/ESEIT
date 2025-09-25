/*
 * Clase de servicio que contiene la lógica de negocio relacionada con la entidad Usuario.
 * Forma parte de la arquitectura de capas en Spring Boot:
 * - Controller: recibe las peticiones HTTP.
 * - Service: maneja la lógica de negocio.
 * - Repository: interactúa con la base de datos (MongoDB en este caso).
 */
package com.ADSistemas2025.ADSistemas2025.Service;

import com.ADSistemas2025.ADSistemas2025.Model.Usuario;
import com.ADSistemas2025.ADSistemas2025.Repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service  // Indica a Spring que esta clase es un "Service" (Bean gestionado)
public class UsuarioService {

    // Dependencia al repositorio que maneja el acceso a MongoDB
    private final UsuarioRepository repo;

    // Constructor con inyección de dependencias.
    // Spring se encarga de proveer automáticamente una implementación de UsuarioRepository.
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    /*
     * Método que retorna todos los usuarios almacenados en la colección "usuarios".
     * Internamente invoca el método findAll() que provee Spring Data MongoDB.
     */
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    /*
     * Guarda un nuevo usuario o actualiza uno existente en la base de datos.
     * Si el objeto "usuario" no tiene ID, lo inserta.
     * Si ya existe un ID, hace update.
     */
    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    /*
     * Elimina un usuario de la base de datos usando su ID.
     * Si el ID no existe, no lanza error, simplemente no hace nada.
     */
    public void eliminar(String id) {
        repo.deleteById(id);
    }

    /*
     * Busca un usuario por su ID en la base de datos.
     * - Si lo encuentra, retorna el objeto Usuario.
     * - Si no lo encuentra, retorna null (usamos orElse(null)).
     */
    public Usuario buscarPorId(String id) {
        return repo.findById(id).orElse(null);
    }

    /*
     * Método de lógica interna que valida si un email es correcto bajo una regla sencilla:
     * - No debe ser nulo.
     * - Debe contener el símbolo "@".
     * - Debe terminar en ".com".
     * (Nota: en proyectos reales usaríamos validaciones más completas con regex).
     */
    public boolean emailEsValido(String email) {
        return email != null && email.contains("@") && email.endsWith(".com");
    }

    /*
     * Método de lógica interna que calcula la longitud del nombre:
     * - Si el nombre es nu*
