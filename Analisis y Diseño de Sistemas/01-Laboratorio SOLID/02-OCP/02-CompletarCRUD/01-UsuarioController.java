package com.DASistemas.DASistemas.controller;

import com.DASistemas.DASistemas.Repository.Service.UsuarioService;
import com.DASistemas.DASistemas.model.Usuario;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController -> indica que esta clase es un controlador REST.
 * Maneja peticiones HTTP y devuelve las respuestas en formato JSON.
 * 
 * @RequestMapping("/api/usuarios") -> define la URL base para este controlador.
 * Todos los endpoints dentro de esta clase comenzarán con "/api/usuarios".
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    // Inyectamos el servicio que contiene la lógica de negocio y acceso a la base de datos.
    private final UsuarioService service;

    // Constructor: Spring inyecta automáticamente una instancia de UsuarioService.
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /*
     * @GetMapping -> este método responde a peticiones HTTP GET en "/api/usuarios".
     * 
     * listar() -> obtiene todos los usuarios almacenados en MongoDB
     * a través del servicio UsuarioService.
     * 
     * Retorna una lista de objetos Usuario en formato JSON.
     */
    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    /*
     * @PostMapping -> responde a peticiones HTTP POST en "/api/usuarios".
     * 
     * crear(@RequestBody Usuario usuario) -> recibe un objeto Usuario desde el cuerpo
     * de la petición (JSON), lo guarda en MongoDB mediante el servicio y retorna
     * el objeto guardado.
     */
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    /*
     * @GetMapping("/{id}") -> responde a peticiones HTTP GET en "/api/usuarios/{id}".
     * 
     * obtenerPorId(@PathVariable String id) -> busca un usuario específico por su id.
     * Si existe, retorna 200 OK con el usuario en formato JSON.
     * Si no existe, retorna 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable String id) {
        Usuario usuario = service.buscarPorId(id);

        if (usuario != null) {
            return ResponseEntity.ok(usuario); // 200 OK con el usuario en JSON
        } else {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }
    }

    /*
     * @DeleteMapping("/{id}") -> responde a peticiones HTTP DELETE en "/api/usuarios/{id}".
     * 
     * eliminar(@PathVariable String id) -> elimina un usuario de la colección según su id.
     * Retorna 200 OK con un mensaje confirmando la eliminación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        service.eliminarPorId(id);
        return ResponseEntity.ok("Usuario con id " + id + " eliminado correctamente.");
    }

}
