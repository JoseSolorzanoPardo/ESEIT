// Definimos el paquete donde se encuentra la clase.
// Esto organiza el código dentro de la aplicación.
package com.DASistemas.DASistemas.controller;

// Importamos las anotaciones necesarias de Spring Framework
import com.DASistemas.DASistemas.model.UsuarioHardCoded;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * La anotación @RestController indica que esta clase es un controlador
 * de tipo REST en Spring Boot. Esto significa que va a manejar peticiones HTTP
 * y devolverá datos directamente en formato JSON, texto u otro tipo de respuesta.
 */
@RestController
public class HolaController {
    
    /*
     * La anotación @GetMapping("/hola") le dice a Spring que este método
     * responderá a las solicitudes HTTP GET que lleguen a la URL "/hola".
     * Ejemplo: si el servidor está en http://localhost:8080,
     * la ruta sería http://localhost:8080/hola
     */
    @GetMapping("/hola")
    public String holamundo() {
        /*
         * Este método devuelve un String como respuesta al cliente.
         * En este caso, simplemente retorna el mensaje:
         * "Hola mundo desde Spring Boot".
         */
        return "Hola mundo desde Spring Boot";
    }
    
    /*
     * Endpoint GET que devuelve una lista de objetos Usuario en formato JSON.
     * Ruta: http://localhost:8080/usuarios
     */
    @GetMapping("/usuarios")
    public List<UsuarioHardCoded> obtenerUsuarios() {
        List<UsuarioHardCoded> usuarios = Arrays.asList(
            new UsuarioHardCoded(1, "Ana", "ana@example.com"),
            new UsuarioHardCoded(2, "Pedro", "pedro@example.com"),
            new UsuarioHardCoded(3, "María", "maria@example.com"),
            new UsuarioHardCoded(4, "Luis", "luis@example.com")
        );

        return usuarios;
    }
    
}
