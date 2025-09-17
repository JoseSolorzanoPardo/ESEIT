import java.util.ArrayList;
import java.util.List;

/*
Se desea modelar un sistema de gestión de personas en una universidad.

Crear una clase base Persona con atributos: nombre, edad.

Crear dos clases hijas:

Estudiante con el atributo adicional carrera.

Profesor con el atributo adicional asignatura.

Usar una lista (ArrayList) que almacene objetos de tipo Persona, donde se puedan guardar tanto Estudiante como Profesor.

Recorrer la lista e imprimir un saludo de cada persona, aplicando polimorfismo.

*/


// Clase base
class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método que será sobrescrito (polimorfismo)
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}

// Clase hija Estudiante
class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy " + nombre + ", estudio " + carrera + ".");
    }
}

// Clase hija Profesor
class Profesor extends Persona {
    private String asignatura;

    public Profesor(String nombre, int edad, String asignatura) {
        super(nombre, edad);
        this.asignatura = asignatura;
    }

    @Override
    public void saludar() {
        System.out.println("Buenos días, soy el profesor " + nombre + " y dicto " + asignatura + ".");
    }
}

// Clase principal
public class Universidad {
    public static void main(String[] args) {
        // Lista de personas (puede almacenar Estudiantes y Profesores)
        List<Persona> personas = new ArrayList<>();

        // Agregar objetos a la lista
        personas.add(new Estudiante("Ana", 20, "Ingeniería de Software"));
        personas.add(new Estudiante("Carlos", 22, "Matemáticas"));
        personas.add(new Profesor("María", 45, "Programación"));
        personas.add(new Profesor("Luis", 50, "Bases de Datos"));

        // Recorrer la lista e invocar el método saludar()
        for (Persona p : personas) {
            p.saludar(); // Polimorfismo: ejecuta la versión correspondiente
        }
    }
}
