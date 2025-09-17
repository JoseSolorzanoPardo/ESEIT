# HashMap

Un HashMap es una estructura de datos que permite guardar información en pares clave: valor.

- Cada clave debe ser única.
- Cada valor está asociado a una clave.
- Si agregamos un valor con una clave ya existente, el valor anterior se sobrescribe.
- No mantiene orden en los elementos.

Un HashMap&lt;K, V&gt; en Java es una estructura de datos que implementa la interfaz Map y permite almacenar pares clave-valor:

- Cada elemento se compone de una clave única (K) y un valor asociado (V).
- Si intentas guardar dos valores con la misma clave, el último sobrescribe al anterior.
- No garantiza orden en los elementos.
- Se usa mucho para buscar rápidamente un dato por su identificador (ejemplo: un vehículo por matrícula, un usuario por su correo, un estudiante por número de documento).
