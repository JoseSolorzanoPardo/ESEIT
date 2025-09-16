-- Usamos la base de datos ESEITPlaneacion
USE ESEIT;

-- =========================================
-- PRIMER EJERCICIO: Relación 1 a 1 (Usuario - Dirección)
-- =========================================

-- Crear tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario BIGINT PRIMARY KEY,        -- Clave primaria: identificador único del usuario
    nombre VARCHAR(100) NOT NULL,         -- Nombre del usuario (obligatorio)
    email VARCHAR(100) UNIQUE NOT NULL    -- Correo electrónico (debe ser único y obligatorio)
);

-- Crear tabla Direcciones
CREATE TABLE Direcciones (
    id_usuario BIGINT PRIMARY KEY,        -- Usa el mismo id_usuario que en Usuarios
    calle VARCHAR(150) NOT NULL,          -- Dirección: calle del usuario
    ciudad VARCHAR(100) NOT NULL,         -- Ciudad
    codigo_postal VARCHAR(20),            -- Código postal (opcional)
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) -- Relación 1:1 con Usuarios
);

-- Insertar registros en la tabla Usuarios
INSERT INTO Usuarios (id_usuario, nombre, email)
VALUES (1, 'Ana Torres', 'ana.torres@email.com');

INSERT INTO Usuarios (id_usuario, nombre, email)
VALUES (2, 'Carlos López', 'carlos.lopez@email.com');

INSERT INTO Usuarios (id_usuario, nombre, email)
VALUES (3, 'María Gómez', 'maria.gomez@email.com');

-- Insertar registros en la tabla Direcciones (cada usuario tiene una dirección)
INSERT INTO Direcciones (id_usuario, calle, ciudad, codigo_postal)
VALUES (1, 'Calle 10 #45-23', 'Bogotá', '110111');

INSERT INTO Direcciones (id_usuario, calle, ciudad, codigo_postal)
VALUES (2, 'Carrera 15 #20-05', 'Medellín', '050021');

INSERT INTO Direcciones (id_usuario, calle, ciudad, codigo_postal)
VALUES (3, 'Avenida 68 #33-15', 'Cali', '760042');

-- Consulta JOIN: combina información de Usuarios y Direcciones
SELECT u.id_usuario, u.nombre, u.email,
       d.calle, d.ciudad, d.codigo_postal
FROM Usuarios u
JOIN Direcciones d ON u.id_usuario = d.id_usuario;

-- Insert múltiple en una sola sentencia (varios usuarios al tiempo)
INSERT INTO Usuarios (id_usuario, nombre, email)
VALUES 
(6, 'Paula Castro', 'paula.castro@email.com'),
(7, 'Ricardo Patiño', 'ricardo.patino@email.com'),
(8, 'Sofía Herrera', 'sofia.herrera@email.com');

-- Seleccionar solo el primer registro de Usuarios (ejemplo de TOP en SQL Server)
SELECT TOP 1 * FROM Usuarios;

-- =========================================
-- SEGUNDO EJERCICIO: Relación 1 a N (Cliente - Pedido)
-- =========================================

-- Nota: Antes de crear tablas con esquema, asegúrate de haber ejecutado:
-- CREATE SCHEMA Comercio;
-- y en SQL Server, este comando debe ir solo en un batch aparte (separado por GO)

-- Crear tabla Cliente en el esquema Comercio
CREATE TABLE Comercio.Cliente (
    id_cliente BIGINT PRIMARY KEY,          -- Identificador único del cliente
    nombre VARCHAR(100) NOT NULL,           -- Nombre del cliente
    email VARCHAR(100) UNIQUE NOT NULL      -- Correo del cliente, debe ser único
);

-- Crear tabla Pedido en el esquema Comercio
CREATE TABLE Comercio.Pedido (
    id_pedido BIGINT PRIMARY KEY,           -- Identificador único del pedido
    fecha DATE NOT NULL,                    -- Fecha en que se hizo el pedido
    total BIGINT NOT NULL,                  -- Valor total del pedido
    fk_id_cliente BIGINT NOT NULL,          -- Llave foránea: cliente al que pertenece el pedido
    FOREIGN KEY (fk_id_cliente) REFERENCES Comercio.Cliente(id_cliente) -- Relación 1:N
);

-- Insertar clientes
INSERT INTO Comercio.Cliente (id_cliente, nombre, email)
VALUES (1, 'Ana Torres', 'ana.torres@email.com');

INSERT INTO Comercio.Cliente (id_cliente, nombre, email)
VALUES (2, 'Carlos López', 'carlos.lopez@email.com');

INSERT INTO Comercio.Cliente (id_cliente, nombre, email)
VALUES (3, 'María Gómez', 'maria.gomez@email.com');

-- Insertar pedidos asociados a clientes
INSERT INTO Comercio.Pedido (id_pedido, fecha, total, fk_id_cliente)
VALUES (101, '2025-09-16', 250000, 1);   -- Pedido de Ana

INSERT INTO Comercio.Pedido (id_pedido, fecha, total, fk_id_cliente)
VALUES (102, '2025-09-16', 480000, 1);   -- Otro pedido de Ana

INSERT INTO Comercio.Pedido (id_pedido, fecha, total, fk_id_cliente)
VALUES (103, '2025-09-17', 150000, 2);   -- Pedido de Carlos

INSERT INTO Comercio.Pedido (id_pedido, fecha, total, fk_id_cliente)
VALUES (104, '2025-09-17', 75000, 3);    -- Pedido de María

-- Consulta JOIN: muestra clientes con sus pedidos
SELECT c.id_cliente, c.nombre, c.email,
       p.id_pedido, p.fecha, p.total
FROM Comercio.Cliente c
JOIN Comercio.Pedido p ON c.id_cliente = p.fk_id_cliente;
