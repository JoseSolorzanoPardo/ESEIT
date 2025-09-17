import java.util.ArrayList;
import java.util.List;

  /*
===========================================================
 EJERCICIO DE REPASO: SISTEMA DE VEHÍCULOS CON LISTAS
===========================================================

En este ejercicio deberás aplicar los conceptos de:
- Herencia
- Sobrescritura de métodos
- Sobrecarga de métodos
- Uso de listas en Java

Instrucciones:
1. Crea una clase base llamada Vehiculo que tenga:
   - Atributos: marca, modelo, anio
   - Un método mostrarInfo() que muestre los datos del vehículo
   - Un método acelerar() que imprima un mensaje genérico

2. Crea dos clases hijas que hereden de Vehiculo:
   - Automovil
   - Motocicleta

   Cada una debe:
   - Sobrescribir el método acelerar() para mostrar un mensaje personalizado
   - Sobrecargar el método acelerar() con un parámetro distinto
     (ejemplo: un número para la velocidad, o un texto para el modo)

3. En la clase principal Main:
   - Crea una lista (ArrayList<Vehiculo>) y agrega varios automóviles y motocicletas
   - Recorre la lista para mostrar la información de cada vehículo y llamar a acelerar()
   - Utiliza también las versiones sobrecargadas de acelerar() en al menos un automóvil y una motocicleta


===========================================================
*/




/*
 * Clase base Vehiculo
 * Contiene atributos comunes a todos los vehículos (marca, modelo, año)
 * y métodos que serán heredados y/o sobrescritos por las clases hijas.
 */
class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anio;

    // Constructor: inicializa los atributos del vehículo
    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Método para mostrar la información básica del vehículo
    public void mostrarInfo() {
        System.out.println(marca + " " + modelo + " (" + anio + ")");
    }

    // Método genérico de aceleración, que será sobrescrito en las clases hijas
    public void acelerar() {
        System.out.println("El vehículo acelera...");
    }
}

/*
 * Clase Automovil
 * Hereda de Vehiculo y redefine algunos métodos.
 * Aplica herencia, sobrescritura (@Override) y sobrecarga (método con parámetros).
 */
class Automovil extends Vehiculo {
    public Automovil(String marca, String modelo, int anio) {
        super(marca, modelo, anio); // Llama al constructor de la clase padre
    }

    // Sobrescritura: redefine el comportamiento de acelerar()
    @Override
    public void acelerar() {
        System.out.println("El automóvil acelera a gran velocidad.");
    }

    // Sobrecarga: método acelerar con un parámetro adicional
    public void acelerar(int velocidad) {
        System.out.println("El automóvil acelera hasta " + velocidad + " km/h.");
    }
}

/*
 * Clase Motocicleta
 * También hereda de Vehiculo, sobrescribe el método acelerar()
 * y crea una sobrecarga con un parámetro distinto.
 */
class Motocicleta extends Vehiculo {
    public Motocicleta(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    // Sobrescritura: redefine el comportamiento de acelerar()
    @Override
    public void acelerar() {
        System.out.println("La motocicleta acelera con rapidez.");
    }

    // Sobrecarga: método acelerar con un parámetro tipo String
    public void acelerar(String modo) {
        System.out.println("La motocicleta acelera en modo: " + modo);
    }
}

/*
 * Clase principal Main
 * Demuestra el uso de herencia, polimorfismo, sobrescritura,
 * sobrecarga y el manejo de listas en Java.
 */
public class Main {
    public static void main(String[] args) {
        // Declaramos una lista de tipo Vehiculo
        // Puede almacenar tanto Automoviles como Motocicletas
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Agregamos objetos de diferentes tipos a la lista
        vehiculos.add(new Automovil("Toyota", "Corolla", 2022));
        vehiculos.add(new Motocicleta("Yamaha", "MT-07", 2021));
        vehiculos.add(new Automovil("Honda", "Civic", 2023));

        // Recorremos la lista usando polimorfismo
        // Aunque el tipo declarado es Vehiculo, en ejecución
        // se llama al método sobrescrito de cada clase hija
        for (Vehiculo v : vehiculos) {
            v.mostrarInfo();  // Muestra los datos del vehículo
            v.acelerar();     // Ejecuta el método sobrescrito
        }

        // Ejemplo de uso de métodos sobrecargados
        Automovil auto = new Automovil("Mazda", "3", 2020);
        auto.acelerar(120); // Usa la versión sobrecargada con int

        Motocicleta moto = new Motocicleta("Suzuki", "GSX-R1000", 2019);
        moto.acelerar("Sport"); // Usa la versión sobrecargada con String
    }
}
