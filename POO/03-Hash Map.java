import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear un HashMap con clave = String (nombre), valor = Integer (edad)
        HashMap<String, Integer> personas = new HashMap<>();

        // Agregar elementos
        personas.put("Ana", 25);
        personas.put("Carlos", 30);
        personas.put("María", 28);

        // Mostrar todo el contenido
        System.out.println("Listado de personas:");
        for (String nombre : personas.keySet()) {
            System.out.println("Nombre: " + nombre + ", Edad: " + personas.get(nombre));
        }

        // Acceder a un valor por su clave
        System.out.println("\nEdad de Carlos: " + personas.get("Carlos"));

        // Actualizar un valor
        personas.put("Ana", 26); // cambia de 25 a 26
        System.out.println("Nueva edad de Ana: " + personas.get("Ana"));

        // Eliminar un elemento
        personas.remove("María");
        System.out.println("\nDespués de eliminar a María: " + personas);
    }

}
