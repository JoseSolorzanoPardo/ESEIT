package com.DASistemas.DASistemas.model;

// Lombok es una librería que ayuda a reducir código repetitivo.
// La anotación @Data genera automáticamente getters, setters, toString(),
// equals() y hashCode(), sin que tengas que escribirlos a mano.
import lombok.Data;

// Importamos la anotación @Id de Spring Data MongoDB para marcar el campo
// que será usado como identificador único dentro de la colección.
import org.springframework.data.annotation.Id;

// @Document indica que esta clase se mapeará a una colección de MongoDB.
// collection = "usuarios" significa que los objetos de esta clase
// se almacenarán en la colección llamada "usuarios".
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * @Data → genera automáticamente getters, setters y métodos útiles.
 * @Document(collection = "usuarios") → define que esta clase representa
 * documentos de la colección "usuarios" en la base de datos MongoDB.
 */
@Data
@Document(collection = "usuarios")
public class Usuario {

    // @Id marca este campo como el identificador único del documento en MongoDB.
    @Id
    private String id;

    // Campo que almacenará el nombre del usuario.
    private String nombre;

    // Campo que almacenará el email del usuario.
    private String email;


    
      // Constructor sin id para creación de usuarios
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    
    
}
