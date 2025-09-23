/*
=========================================================
   Enunciado del Ejercicio
   Título: Sistema de Empleados en una Empresa
=========================================================

En este ejercicio se propone diseñar un sistema orientado a objetos que modele 
la gestión de empleados dentro de una empresa, con el fin de repasar los 
conceptos de herencia, sobrescritura, sobrecarga de métodos y polimorfismo en Java.

El sistema debe partir de una clase base llamada Empleado, que represente a un 
trabajador genérico. Esta clase contendrá los atributos nombre y salarioBase, 
así como dos métodos:
   - calcularSalario(), que de forma genérica devuelva el salario base.
   - mostrarInfo(), que imprima un mensaje indicando que se trata de un empleado genérico.

A partir de esta clase, se deberán crear dos subclases:

1. Desarrollador, con atributo adicional lenguajePrincipal.
   - Sobrescribir calcularSalario() para incrementar el salario base en un 10%.
   - Sobrescribir mostrarInfo() para incluir el lenguaje de programación principal.
   - Sobrecargar calcularSalario(int proyectos), sumando un bono fijo de 
     200 000 COP por cada proyecto adicional desarrollado.

2. Gerente, con atributo adicional equipoACargo (número de personas).
   - Sobrescribir calcularSalario() para incrementar el salario base en un 20%.
   - Sobrescribir mostrarInfo() para incluir la cantidad de personas a su cargo.
   - Sobrecargar calcularSalario(double bonoExtra), que permita sumar un bono 
     especial definido por la empresa.

---------------------------------------------------------
Clase Main
---------------------------------------------------------
En la clase Main, se debe:
   - Crear una lista de tipo Empleado con varios objetos Desarrollador y Gerente.
   - Recorrer esta lista aplicando polimorfismo para mostrar la información 
     y calcular el salario de cada empleado.
   - Demostrar el uso de los métodos sobrecargados para evidenciar cómo los 
     parámetros influyen en los resultados.*/



/*
=========================================================
 Ejercicio: Sistema de Empleados en una Empresa
=========================================================
Este código ejemplifica cómo modelar empleados usando:
- Herencia
- Encapsulamiento (atributos privados + getters/setters)
- Sobrescritura de métodos
- Sobrecarga de métodos
- Polimorfismo
=========================================================
*/

import java.util.ArrayList;
import java.util.List;

// Clase base
class Empleado {
    private String nombre;
    private double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    // Métodos de acceso
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Método genérico: se sobrescribirá en subclases
    public double calcularSalario() {
        return salarioBase;
    }

    // Método genérico: se sobrescribirá en subclases
    public void mostrarInfo() {
        System.out.println("Empleado genérico: " + nombre);
    }
}

// Subclase: Desarrollador
class Desarrollador extends Empleado {
    private String lenguajePrincipal;

    public Desarrollador(String nombre, double salarioBase, String lenguajePrincipal) {
        super(nombre, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    // Métodos de acceso
    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    // Sobrescritura
    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.10; // 10% adicional
    }

    // Sobrescritura
    @Override
    public void mostrarInfo() {
        System.out.println("Desarrollador: " + getNombre() +
                " | Lenguaje: " + lenguajePrincipal);
    }

    // Sobrecarga
    public double calcularSalario(int proyectos) {
        return calcularSalario() + (200000 * proyectos);
    }
}

// Subclase: Gerente
class Gerente extends Empleado {
    private int equipoACargo;

    public Gerente(String nombre, double salarioBase, int equipoACargo) {
        super(nombre, salarioBase);
        this.equipoACargo = equipoACargo;
    }

    // Métodos de acceso
    public int getEquipoACargo() {
        return equipoACargo;
    }

    public void setEquipoACargo(int equipoACargo) {
        this.equipoACargo = equipoACargo;
    }

    // Sobrescritura
    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.20; // 20% adicional
    }

    // Sobrescritura
    @Override
    public void mostrarInfo() {
        System.out.println("Gerente: " + getNombre() +
                " | Equipo a cargo: " + equipoACargo + " personas");
    }

    // Sobrecarga
    public double calcularSalario(double bonoExtra) {
        return calcularSalario() + bonoExtra;
    }
}

// Clase principal (Main)
public class Main {
    public static void main(String[] args) {
        // Lista polimórfica
        List<Empleado> empleados = new ArrayList<>();

        // Agregar empleados
        empleados.add(new Desarrollador("Ana", 3000000, "Java"));
        empleados.add(new Desarrollador("Pedro", 2800000, "Python"));
        empleados.add(new Gerente("Laura", 5000000, 5));
        empleados.add(new Gerente("Carlos", 5500000, 8));

        // Recorrido polimórfico
        System.out.println("=== Información de empleados ===");
        for (Empleado e : empleados) {
            e.mostrarInfo();
            System.out.println("Salario calculado: " + e.calcularSalario());
            System.out.println("---------------------------");
        }

        // Demostración de métodos sobrecargados
        System.out.println("=== Uso de sobrecarga de métodos ===");
        Desarrollador dev = new Desarrollador("María", 3200000, "C#");
        System.out.println("Salario de María con 2 proyectos: " + dev.calcularSalario(2));

        Gerente ger = new Gerente("Andrés", 6000000, 10);
        System.out.println("Salario de Andrés con bono extra de 1.000.000: " + ger.calcularSalario(1000000));
    }
}

