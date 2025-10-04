/*
 * Clase de pruebas unitarias para la lógica del servicio UsuarioService.
 * Estas pruebas NO usan base de datos ni Spring, solo verifican la lógica de métodos internos.
 * 
 * Tecnologías usadas:
 * - JUnit 5 (@Test, assertTrue, assertFalse, assertEquals, assertThrows).
 * 
 * Objetivo:
 * - Probar la validez de correos electrónicos con distintas condiciones.
 * - Probar el cálculo de la longitud del nombre con y sin espacios.
 * - Verificar el lanzamiento de excepciones en casos inválidos.
 */
package com.ADSistemas2025.ADSistemas2025;

import com.ADSistemas2025.ADSistemas2025.Service.UsuarioService;
import static org.junit.jupiter.api.Assertions.*; // Importa las aserciones de JUnit
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para UsuarioService.
 * Autor: Jose Hember
 */
public class UsuarioServiceLogicaTest {
    
    // Instanciamos el servicio. Pasamos "null" porque no usamos el repositorio en estas pruebas.
    private final UsuarioService service = new UsuarioService(null); 
    
    // -------------------------------
    // PRUEBAS DEL MÉTODO emailEsValido
    // -------------------------------

    @Test
    public void testEmailEsValido_Correcto() {
        // Caso positivo: email válido
        assertTrue(service.emailEsValido("juan@example.com"));
    }
    
    @Test
    public void testEmailEsValido_SinArroba() {
        // Caso negativo: falta el carácter "@"
        assertFalse(service.emailEsValido("juanexample.com"));
    }
    
    @Test
    public void testEmailEsValido_Null() {
        // Caso negativo: email nulo
        assertFalse(service.emailEsValido(null));
    }
    
    @Test
    public void testEmailEsValido_NoTerminaEnCom() {
        // Caso negativo: email válido en estructura, pero dominio incorrecto
        assertFalse(service.emailEsValido("juan@example.org"));
    }
   
    // -------------------------------
    // PRUEBAS DEL MÉTODO calcularLongitudNombre
    // -------------------------------

    @Test
    public void testCalcularLongitudNombre_Correcto() {
        // Caso positivo: nombre normal
        int longitud = service.calcularLongitudNombre("Ana");
        assertEquals(3, longitud); // "Ana" tiene 3 caracteres
    }

    @Test
    void testCalcularLongitudNombre_ConEspacios() {
        // Caso positivo: nombre con espacios extra
        int longitud = service.calcularLongitudNombre("  Pedro   ");
        assertEquals(5, longitud); // trim() elimina espacios → "Pedro"
    }

    @Test
    void testCalcularLongitudNombre_NullDebeLanzarExcepcion() {
        // Caso negativo: nombre nulo → se espera excepción
        assertThrows(IllegalArgumentException.class,
            () -> service.calcularLongitudNombre(null));
    }
    
}
