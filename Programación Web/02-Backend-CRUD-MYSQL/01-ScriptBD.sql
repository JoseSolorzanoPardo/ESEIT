-- ===========================================
-- Crear base de datos
-- ===========================================
CREATE DATABASE IF NOT EXISTS ESEITPlaneacion
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE ESEITPlaneacion;

-- ===========================================
-- Crear tabla Estudiantes
-- ===========================================
CREATE TABLE estudiantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,        -- Identificador único

    nombre VARCHAR(100) NOT NULL,                -- Nombre del estudiante
    apellido VARCHAR(100) NOT NULL,              -- Apellido del estudiante
    email VARCHAR(120) NOT NULL UNIQUE,          -- Correo único

    edad INT,                                    -- Edad (valor redundante, opcional)
    fecha_nacimiento DATE NOT NULL,              -- Fecha de nacimiento

    telefono VARCHAR(15),                        -- Teléfono (puede incluir código país)
    carrera VARCHAR(100),                        -- Programa académico o carrera

    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha de registro
    activo BOOLEAN DEFAULT TRUE                  -- Estado de matrícula (activo/inactivo)
);



-- Estudiante 1
INSERT INTO estudiantes (nombre, apellido, email, edad, fecha_nacimiento, telefono, carrera, activo)
VALUES ('Laura', 'Gómez', 'laura.gomez@ucompensar.edu.co', 21, '2004-05-12', '+57-3201234567', 'Ingeniería de Software', TRUE);

-- Estudiante 2
INSERT INTO estudiantes (nombre, apellido, email, edad, fecha_nacimiento, telefono, carrera, activo)
VALUES ('Carlos', 'Pérez', 'carlos.perez@ucompensar.edu.co', 22, '2003-08-19', '+57-3109876543', 'Administración de Empresas', TRUE);

-- Estudiante 3
INSERT INTO estudiantes (nombre, apellido, email, edad, fecha_nacimiento, telefono, carrera, activo)
VALUES ('Ana', 'Martínez', 'ana.martinez@ucompensar.edu.co', 20, '2005-01-22', '+57-3156789123', 'Contaduría Pública', TRUE);

-- Estudiante 4
INSERT INTO estudiantes (nombre, apellido, email, edad, fecha_nacimiento, telefono, carrera, activo)
VALUES ('David', 'Ramírez', 'david.ramirez@ucompensar.edu.co', 23, '2002-11-10', '+57-3014567890', 'Ingeniería Industrial', FALSE);

-- Estudiante 5
INSERT INTO estudiantes (nombre, apellido, email, edad, fecha_nacimiento, telefono, carrera, activo)
VALUES ('Mariana', 'Torres', 'mariana.torres@ucompensar.edu.co', 19, '2006-03-05', '+57-3221112233', 'Psicología', TRUE);

-- Estudiante 6
INSERT INTO estudiantes (nombre, apellido, email, edad, fecha_nacimiento, telefono, carrera, activo)
VALUES ('Santiago', 'Moreno', 'santiago.moreno@ucompensar.edu.co', 24, '2001-07-18', '+57-3112223344', 'Ingeniería de Sistemas', TRUE);

-- Estudiante 7
INSERT INTO estudiantes (nombre, apellido, email, edad, fecha_nacimiento, telefono, carrera, activo)
VALUES ('Valentina', 'Cárdenas', 'valentina.cardenas@ucompensar.edu.co', 25, '2000-09-30', '+57-3009998877', 'Diseño Gráfico', FALSE);
