/*
 * ----------------------------------------------------------------------------
 * ¿QUÉ ES MOCKITO?
 * ----------------------------------------------------------------------------
 * 
 * Mockito es un framework de Java que permite crear "mocks", es decir,
 * OBJETOS SIMULADOS que imitan el comportamiento de dependencias reales.
 * 
 * Su objetivo principal es AISLAR la clase que se está probando (por ejemplo,
 * un servicio) de otras partes del sistema que no queremos ejecutar en la prueba,
 * como:
 *     - Repositorios (bases de datos reales)
 *     - APIs externas
 *     - Servicios de terceros
 * 
 * En lugar de conectarse a una base de datos o ejecutar código real,
 * Mockito crea un OBJETO FALSO que responde exactamente lo que nosotros le indiquemos.
 * 
 * ----------------------------------------------------------------------------
 * BENEFICIOS PRINCIPALES:
 * ----------------------------------------------------------------------------
 * 1. Las pruebas unitarias son más rápidas (no hay conexión a BD).
 * 2. No dependemos de servicios externos ni datos reales.
 * 3. Podemos controlar completamente las respuestas (simular errores, listas vacías, etc.).
 * 4. Podemos verificar si un método fue llamado, cuántas veces y con qué parámetros.
 * 
 * ----------------------------------------------------------------------------
 * SINTAXIS BÁSICA:
 * ----------------------------------------------------------------------------
 * // 1. Crear el mock:
 * UsuarioRepository repo = Mockito.mock(UsuarioRepository.class);
 * 
 * // 2. Definir comportamiento del mock (qué debe devolver):
 * when(repo.findAll()).thenReturn(listaUsuarios);
 * 
 * // 3. Ejecutar el método que usa el mock:
 * UsuarioService service = new UsuarioService(repo);
 * service.listarTodos();
 * 
 * // 4. Verificar interacciones:
 * verify(repo, times(1)).findAll();
 * 
 * ----------------------------------------------------------------------------
 * Mockito actúa como un "doble de prueba" o "actor suplente" que reemplaza 
 * al objeto real en un escenario controlado, permitiendo probar la lógica 
 * de una clase sin depender de factores externos.
 * ----------------------------------------------------------------------------
 */

/*
 * Clase de pruebas unitarias con Mockito para UsuarioService.
 * 
 * Objetivo:
 * - Probar el método buscarPorEmail() del servicio.
 * - Usar un mock (simulación) de UsuarioRepository para no depender de MongoDB real.
 * 
 * Herramientas:
 * - JUnit 5 (@Test, @BeforeEach, assertNotNull, assertEquals).
 * - Mockito (mock, when, verify).
 */
package com.ADSistemas2025.ADSistemas2025;

import com.ADSistemas2025.ADSistemas2025.Model.Usuario;
import com.ADSistemas2025.ADSistemas2025.Repository.UsuarioRepository;
import com.ADSistemas2025.ADSistemas2025.Service.UsuarioService;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas con Mockito.
 * Autor: Jose Hember
 */
public class UsuarioServiceMockitoTest {

    private UsuarioRepository repo;  // Dependencia simulada (mock)
    private UsuarioService service;  // Clase bajo prueba
    
    @BeforeEach
    void setUp() {
        // Se crea un mock del repositorio
        repo = Mockito.mock(UsuarioRepository.class);
        // Se inyecta el mock en el servicio
        service = new UsuarioService(repo);
    }
    
    @Test
    void testBuscarPorEmail_Encontrado() {
        // ---------------------
        // Arrange (preparación)
        // ---------------------
        Usuario u1 = new Usuario();
        u1.setId("1");
        u1.setNombre("Ana");
        u1.setEmail("ana@example.com");

        Usuario u2 = new Usuario();
        u2.setId("2");
        u2.setNombre("Pedro");
        u2.setEmail("pedro@example.com");

        // Creamos una lista de usuarios que "simula" la base de datos
        List<Usuario> usuarios = Arrays.asList(u1, u2);

        // Definimos el comportamiento del mock:
        // cuando alguien llame a repo.findAll(), debe devolver la lista anterior
        when(repo.findAll()).thenReturn(usuarios);

        // ---------------------
        // Act (ejecución)
        // ---------------------
        Usuario resultado = service.buscarPorEmail("pedro@example.com");

        // ---------------------
        // Assert (verificación)
        // ---------------------
        assertNotNull(resultado);                      // verificamos que sí encontró algo
        assertEquals("Pedro", resultado.getNombre());  // el nombre debe coincidir

        // Además verificamos que el repositorio fue invocado exactamente 1 vez
        verify(repo, times(1)).findAll();
    }

}
