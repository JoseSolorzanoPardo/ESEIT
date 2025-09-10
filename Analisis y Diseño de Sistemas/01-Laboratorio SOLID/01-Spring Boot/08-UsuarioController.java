
import com.DASistemas.DASistemas.Repository.Service.UsuarioService;
import com.DASistemas.DASistemas.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @RestController -> indica que esta clase es un controlador REST.
 * Esto significa que manejará peticiones HTTP y devolverá respuestas en formato JSON.
 * 
 * @RequestMapping("/api/usuarios") -> define la URL base para este controlador.
 * Todos los endpoints dentro de esta clase comenzarán con "/api/usuarios".
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    // Inyectamos el servicio que contiene la lógica para consultar la BD.
    private final UsuarioService service;

    // Constructor: Spring inyecta automáticamente una instancia de UsuarioService.
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /*
     * @GetMapping -> este método responde a peticiones HTTP GET en la ruta "/api/usuarios".
     * 
     * listar() -> llama al servicio (UsuarioService) para obtener todos los usuarios de MongoDB.
     * El resultado se devuelve como una lista de objetos Usuario.
     * 
     * Spring Boot convierte automáticamente la lista de objetos en JSON.
     */
    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }
}
