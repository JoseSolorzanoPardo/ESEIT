/*
 * --------------------------------------------------------------
 *  EJERCICIO: CLASES ABSTRACTAS — SISTEMA DE VEHÍCULOS
 * --------------------------------------------------------------
 *
 * Crear una clase abstracta llamada Vehiculo con los siguientes atributos:
 *    - marca (String)
 *    - modelo (String)
 *    - anio (int)
 *    - velocidadActual (double)
 *
 * Incluir en la clase Vehiculo:
 *    - Un constructor que inicialice los atributos.
 *    - Un método concreto llamado acelerar(double incremento) 
 *         * que aumente la velocidad actual.
 *    - Un método concreto llamado frenar(double decremento) 
 *         * que reduzca la velocidad actual.
 *    - Un método abstracto llamado mostrarInformacion() 
 *         * que deberá ser implementado por las clases hijas.
 *    - Un método abstracto llamado calcularConsumo(double distancia) 
 *         * que devuelva el consumo estimado de combustible (litros o energía)
 *           según el tipo de vehículo.
 *
 * Crear las siguientes clases hijas que extiendan de Vehiculo:
 *    - Automovil
 *    - Motocicleta
 *    - Camion
 *
 * En cada clase hija:
 *    - Sobrescribir los métodos abstractos mostrarInformacion() 
 *      y calcularConsumo(double distancia).
 *    - Definir un cálculo de consumo distinto por tipo de vehículo 
 *      (por ejemplo, los camiones gastan más combustible por kilómetro).
 *
 * En la clase Main:
 *    - Crear una lista de vehículos (List<Vehiculo>).
 *    - Agregar diferentes instancias de Automovil, Motocicleta y Camion.
 *    - Usar un bucle polimórfico para mostrar la información de todos 
 *      los vehículos y el consumo estimado para una distancia de 100 km.
 *
 *  Objetivo:
 *    - Aplicar herencia, abstracción y polimorfismo en Java.
 *    - Reforzar el uso de clases abstractas y métodos sobrescritos.
 */



/*
 * --------------------------------------------------------------
 * SOLUCIÓN MEJORADA: CLASES ABSTRACTAS — SISTEMA DE VEHÍCULOS
 * --------------------------------------------------------------
 * Este ejemplo demuestra:
 *   - Uso de clases abstractas
 *   - Encapsulamiento con atributos privados
 *   - Métodos abstractos sobrescritos
 *   - Herencia y polimorfismo
 * --------------------------------------------------------------
 */

abstract class Vehiculo {
    // Atributos privados
    private String marca;
    private String modelo;
    private int anio;
    private double velocidadActual;

    // Constructor
    public Vehiculo(String marca, String modelo, int anio, double velocidadActual) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadActual = velocidadActual;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    // Método concreto: acelerar
    public void acelerar(double incremento) {
        this.velocidadActual += incremento;
        System.out.println(marca + " " + modelo + " ha acelerado a " + velocidadActual + " km/h");
    }

    // Método concreto: frenar
    public void frenar(double decremento) {
        this.velocidadActual -= decremento;
        if (this.velocidadActual < 0) this.velocidadActual = 0;
        System.out.println(marca + " " + modelo + " ha frenado a " + velocidadActual + " km/h");
    }

    // Métodos abstractos
    public abstract void mostrarInformacion();
    public abstract double calcularConsumo(double distancia);
}

// -------------------------------------------------------------
// Clase hija: Automovil
class Automovil extends Vehiculo {

    public Automovil(String marca, String modelo, int anio, double velocidadActual) {
        super(marca, modelo, anio, velocidadActual);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Automóvil - Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Año: " + getAnio());
        System.out.println("Velocidad actual: " + getVelocidadActual() + " km/h");
    }

    @Override
    public double calcularConsumo(double distancia) {
        // Automóvil: 8.5 L / 100 km
        return (8.5 * distancia) / 100;
    }
}

// -------------------------------------------------------------
// Clase hija: Motocicleta
class Motocicleta extends Vehiculo {

    public Motocicleta(String marca, String modelo, int anio, double velocidadActual) {
        super(marca, modelo, anio, velocidadActual);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Motocicleta - Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Año: " + getAnio());
        System.out.println("Velocidad actual: " + getVelocidadActual() + " km/h");
    }

    @Override
    public double calcularConsumo(double distancia) {
        // Motocicleta: 5 L / 100 km
        return (5.0 * distancia) / 100;
    }
}

// -------------------------------------------------------------
// Clase hija: Camion
class Camion extends Vehiculo {

    public Camion(String marca, String modelo, int anio, double velocidadActual) {
        super(marca, modelo, anio, velocidadActual);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Camión - Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Año: " + getAnio());
        System.out.println("Velocidad actual: " + getVelocidadActual() + " km/h");
    }

    @Override
    public double calcularConsumo(double distancia) {
        // Camión: 25 L / 100 km
        return (25.0 * distancia) / 100;
    }
}

// -------------------------------------------------------------
// Clase principal: Main
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Lista polimórfica de vehículos
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Automovil("Toyota", "Corolla", 2022, 80));
        vehiculos.add(new Motocicleta("Yamaha", "MT-07", 2021, 95));
        vehiculos.add(new Camion("Volvo", "FH16", 2020, 70));

        double distancia = 100.0;

        // Uso del polimorfismo
        for (Vehiculo v : vehiculos) {
            System.out.println("\n--- Información del Vehículo ---");
            v.mostrarInformacion();
            double consumo = v.calcularConsumo(distancia);
            System.out.println("Consumo estimado para " + distancia + " km: " + consumo + " litros");
        }
    }
}

