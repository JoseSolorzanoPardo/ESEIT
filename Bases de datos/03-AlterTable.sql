-- ==============================================
-- Usar la base de datos ESEITPlaneacion
-- ==============================================
USE ESEITPlaneacion;
GO

-- ==============================================
-- Crear un esquema llamado AlterEjemplo
-- Un esquema es como una "carpeta" lógica
-- donde podemos organizar tablas y otros objetos
-- ==============================================
CREATE SCHEMA AlterEjemplo;
GO

-- ==============================================
-- Crear la tabla Productos dentro del esquema AlterEjemplo
-- Contiene: id (clave primaria), nombre y precio
-- ==============================================
CREATE TABLE AlterEjemplo.Productos (
    id_producto INT PRIMARY KEY,         -- Identificador único
    nombre VARCHAR(50) NOT NULL,         -- Nombre del producto (máx. 50 caracteres)
    precio DECIMAL(10,2) NOT NULL        -- Precio con 2 decimales
);
GO

-- ==============================================
-- Insertar registros iniciales en la tabla
-- ==============================================
INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (1, 'Laptop Lenovo ThinkPad', 3500.00);

INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (2, 'Mouse Logitech M170', 55.90);

INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (3, 'Teclado Mecánico Redragon', 210.50);

INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (4, 'Monitor Samsung 24 Pulgadas', 780.00);

INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (5, 'Disco SSD Kingston 512GB', 420.75);
GO

-- ==============================================
-- 4. Alteraciones paso a paso con ALTER TABLE
-- ==============================================

-- 4.1. Agregar una nueva columna 'stock' (cantidad disponible)
-- Se inicializa con 0 como valor por defecto
ALTER TABLE AlterEjemplo.Productos
ADD stock INT DEFAULT 0;
GO

-- Consultar los registros actuales (ya incluye la nueva columna)
SELECT * FROM AlterEjemplo.Productos;

-- Insertar más productos (nota: stock se llena con el valor por defecto)
INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (6, 'Impresora HP DeskJet 2700', 399.99);

INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (7, 'Auriculares Sony WH-CH510', 320.00);
GO

-- 4.2. Modificar el tipo de dato de 'nombre'
-- Ahora se permite hasta 200 caracteres en vez de 50
ALTER TABLE AlterEjemplo.Productos
ALTER COLUMN nombre VARCHAR(200) NOT NULL;
GO

-- 4.3. Agregar una nueva columna 'fecha_registro'
-- Se inicializa automáticamente con la fecha actual (GETDATE)
ALTER TABLE AlterEjemplo.Productos
ADD fecha_registro DATE DEFAULT GETDATE();
GO

-- Insertar un producto nuevo (SQL Server colocará automáticamente la fecha actual en fecha_registro)
INSERT INTO AlterEjemplo.Productos (id_producto, nombre, precio)
VALUES (8, 'Tablet Samsung Galaxy Tab A8', 950.00);
GO

-- 4.4. Renombrar columnas con sp_rename
-- Cambiar el nombre de la columna 'precio' a 'precio_unitario'
EXEC sp_rename 'AlterEjemplo.Productos.precio', 'precio_unitario', 'COLUMN';
GO

-- (Ejemplo adicional) Volver a renombrar 'precio_unitario' a 'precio'
EXEC sp_rename 'AlterEjemplo.Productos.precio_unitario', 'precio', 'COLUMN';
GO

-- 4.5. Agregar una restricción UNIQUE en el campo 'nombre'
-- Esto evita que dos productos tengan el mismo nombre
ALTER TABLE AlterEjemplo.Productos
ADD CONSTRAINT UQ_Productos_Nombre UNIQUE (nombre);
GO

-- 4.6. Eliminar la columna 'stock'
-- Ya no será necesaria en la tabla
ALTER TABLE AlterEjemplo.Productos
DROP COLUMN stock;
GO
