/*
 * --------------------------------------------------------------
 *  RELACIONES ENTRE ENTIDADES EN JPA / HIBERNATE
 * --------------------------------------------------------------
 *
 * En el desarrollo de aplicaciones empresariales con Spring Boot y JPA
 * (Java Persistence API), uno de los temas fundamentales es el mapeo de
 * relaciones entre entidades. Este proceso permite definir cómo las clases
 * Java que representan el modelo de datos se relacionan entre sí, reflejando
 * las mismas asociaciones que existen entre las tablas de una base de datos
 * relacional.
 *
 * Cada relación entre entidades en JPA equivale a una cardinalidad en el modelo
 * de datos, es decir, al número de elementos que pueden vincularse entre sí en
 * dos entidades. Estas relaciones permiten mantener la integridad referencial
 * y facilitan la manipulación de datos de forma orientada a objetos, evitando
 * la necesidad de escribir consultas SQL manuales.
 *
 * Existen principalmente cuatro tipos de relaciones:
 *   1 Uno a Uno (@OneToOne): una entidad se asocia con una sola instancia de otra.
 *   2 Uno a Muchos (@OneToMany): una entidad puede tener varias instancias asociadas.
 *   3 Muchos a Uno (@ManyToOne): múltiples registros hacen referencia a una sola entidad principal.
 *   4 Muchos a Muchos (@ManyToMany): ambas entidades pueden tener múltiples asociaciones
 *       entre sí, generalmente representadas por una tabla intermedia.
 *
 * En la práctica, estas relaciones se implementan mediante anotaciones de JPA
 * como @OneToOne, @OneToMany, @ManyToOne y @ManyToMany, junto con @JoinColumn o
 * @JoinTable para indicar cómo se enlazan las llaves foráneas en la base de datos.
 * Por ejemplo, en una relación de uno a muchos entre Docente y Curso, un docente
 * puede dictar varios cursos, y cada curso contiene una columna docente_id que
 * actúa como clave foránea hacia el docente correspondiente.
 *
 * El manejo correcto de estas relaciones no solo garantiza la consistencia de los
 * datos, sino que también mejora la legibilidad y mantenibilidad del código,
 * permitiendo trabajar con objetos Java en lugar de tablas y registros.
 * En síntesis, el mapeo de relaciones entre entidades es el puente que conecta
 * la programación orientada a objetos con el modelo relacional de las bases de
 * datos, simplificando la persistencia y recuperación de información en las
 * aplicaciones modernas desarrolladas con Spring Boot y Hibernate.
 * --------------------------------------------------------------
 */

package com.cardinalidadPlaneacion.cardinalidadPlaneacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Curso {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int creditos;
    
    private Long docente_id;

    //Relación Muchos a Uno con Docente
   /* @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;*/
}
