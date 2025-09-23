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
