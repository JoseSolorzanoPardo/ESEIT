# DDL

El Lenguaje de Definición de Datos (DDL) es el conjunto de instrucciones de SQL que nos permite crear, modificar y eliminar estructuras dentro de una base de datos. A diferencia del Lenguaje de Manipulación de Datos (DML), que se enfoca en insertar, actualizar o consultar información, el DDL trabaja con los elementos que definen la organización de los datos: tablas, columnas, restricciones, índices y vistas. En otras palabras, con DDL damos el paso de lo conceptual y lógico (modelo entidad–relación y modelo relacional) a lo físico, es decir, al código que construye la base de datos en el motor correspondiente.

Los comandos principales de DDL son CREATE, ALTER, DROP y TRUNCATE. Con **CREATE** podemos crear nuevos objetos, como bases de datos y tablas, definiendo sus columnas, tipos de datos y restricciones. Con **ALTER** se modifican estructuras ya existentes, por ejemplo, agregando o eliminando una columna. El comando **DROP** se utiliza para eliminar por completo una tabla u otro objeto de la base de datos. Finalmente, **TRUNCATE** vacía una tabla sin eliminar su estructura, dejándola lista para volver a usarse. Estos comandos son fundamentales porque permiten a los desarrolladores y administradores definir cómo se almacenará y relacionará la información.

**¿Qué es un esquema?**

Es un contenedor lógico dentro de una base de datos. Permite organizar y agrupar objetos relacionados. Ayuda a manejar seguridad al dar permisos sobre un esquema completo en lugar de hacerlo tabla por tabla. Evita colisiones de nombres, ya que puede tener tablas con el mismo nombre en esquemas distintos.
