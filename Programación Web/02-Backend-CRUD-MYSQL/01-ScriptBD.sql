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
