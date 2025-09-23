/*
  Ejercicio: Sistema de Gestión de Cursos en la Universidad ESEIT

  La Universidad ESEIT desea implementar un sistema de información que permita 
  gestionar de manera organizada los cursos, profesores y estudiantes que 
  participan en su oferta académica. Actualmente, los registros se llevan de manera 
  manual, lo que dificulta la consulta y administración de la información.

  El sistema debe contemplar las siguientes condiciones:

  - Cada profesor puede dictar varios cursos, pero cada curso es dictado únicamente por un profesor.
  - Cada curso pertenece a un programa académico (por ejemplo: Ingeniería de Software, Administración, Contaduría, etc.).
  - Cada estudiante puede inscribirse en varios cursos, y un curso puede tener varios estudiantes inscritos (relación muchos a muchos).
  - Cada inscripción debe registrar el semestre en el cual el estudiante cursa la materia.

  Actividades a desarrollar:

  1. Modelo Entidad–Relación (E-R):
     Diseñar un diagrama que represente entidades como Profesor, Curso, Programa, Estudiante e Inscripción, junto con sus relaciones.

  2. Modelo Relacional:
     Transformar el modelo E-R en un modelo relacional, definiendo:
     - Las tablas
     - Sus atributos
     - Las llaves primarias y foráneas
     - Las relaciones entre ellas

  3. Script SQL:
     Elaborar un script que:
     - Cree la base de datos y sus tablas
     - Inserte registros de ejemplo (al menos 3 profesores, 3 programas, 5 cursos y 5 estudiantes con inscripciones)

  4. Consultas básicas:
     Ejecutar consultas que permitan:
     - Listar los cursos que dicta un profesor específico
     - Consultar los estudiantes inscritos en un curso determinado
     - Mostrar los cursos en los que está inscrito un estudiante en un semestre dado

*/


USE ESEITPlaneacion;
GO

-- ===========================================
-- Creación del esquema de la Universidad ESEIT
-- ===========================================
CREATE SCHEMA UniversidadESEIT;
GO


-- ===========================================
-- Tabla Programa
-- Un programa académico puede tener varios cursos
-- ===========================================
CREATE TABLE UniversidadESEIT.Programa (
    id_programa INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- ===========================================
-- Tabla Profesor
-- Un profesor puede dictar varios cursos
-- ===========================================
CREATE TABLE UniversidadESEIT.Profesor (
    id_profesor INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- ===========================================
-- Tabla Estudiante
-- Un estudiante puede inscribirse en varios cursos
-- ===========================================
CREATE TABLE UniversidadESEIT.Estudiante (
    id_estudiante INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- ===========================================
-- Tabla Curso
-- Cada curso pertenece a un programa y a un profesor
-- ===========================================
CREATE TABLE UniversidadESEIT.Curso (
    id_curso INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_programa INT NOT NULL,
    id_profesor INT NOT NULL,
    FOREIGN KEY (id_programa) REFERENCES UniversidadESEIT.Programa(id_programa),
    FOREIGN KEY (id_profesor) REFERENCES UniversidadESEIT.Profesor(id_profesor)
);

-- ===========================================
-- Tabla Inscripcion
-- Relación N:M entre Estudiante y Curso
-- Incluye el semestre como atributo adicional
-- ===========================================
CREATE TABLE UniversidadESEIT.Inscripcion (
    id_inscripcion INT PRIMARY KEY,
    id_estudiante INT NOT NULL,
    id_curso INT NOT NULL,
    semestre VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_estudiante) REFERENCES UniversidadESEIT.Estudiante(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES UniversidadESEIT.Curso(id_curso)
);





-- ===========================================
-- Poblar la tabla Programa
-- ===========================================
INSERT INTO UniversidadESEIT.Programa (id_programa, nombre)
VALUES 
(1, 'Ingeniería de Software'),
(2, 'Administración de Empresas'),
(3, 'Contaduría Pública');

-- ===========================================
-- Poblar la tabla Profesor
-- ===========================================
INSERT INTO UniversidadESEIT.Profesor (id_profesor, nombre, email)
VALUES
(1, 'Carlos Ramírez', 'carlos.ramirez@eseit.edu'),
(2, 'María González', 'maria.gonzalez@eseit.edu'),
(3, 'Pedro López', 'pedro.lopez@eseit.edu');

-- ===========================================
-- Poblar la tabla Estudiante
-- ===========================================
INSERT INTO UniversidadESEIT.Estudiante (id_estudiante, nombre, email)
VALUES
(1, 'Ana Torres', 'ana.torres@eseit.edu'),
(2, 'Luis Herrera', 'luis.herrera@eseit.edu'),
(3, 'Sofía Martínez', 'sofia.martinez@eseit.edu'),
(4, 'Juan Pérez', 'juan.perez@eseit.edu'),
(5, 'Carolina Díaz', 'carolina.diaz@eseit.edu');

-- ===========================================
-- Poblar la tabla Curso
-- Cada curso está relacionado con un programa y un profesor
-- ===========================================
INSERT INTO UniversidadESEIT.Curso (id_curso, nombre, id_programa, id_profesor)
VALUES
(1, 'Programación Orientada a Objetos', 1, 1),
(2, 'Bases de Datos I', 1, 2),
(3, 'Fundamentos de Administración', 2, 3),
(4, 'Contabilidad Básica', 3, 2),
(5, 'Ingeniería de Requisitos', 1, 1);

-- ===========================================
-- Poblar la tabla Inscripción
-- Relación entre estudiantes y cursos, con semestre
-- ===========================================
INSERT INTO UniversidadESEIT.Inscripcion (id_inscripcion, id_estudiante, id_curso, semestre)
VALUES
(1, 1, 1, '2025-I'),  -- Ana se inscribe en POO
(2, 1, 2, '2025-I'),  -- Ana también en Bases de Datos
(3, 2, 1, '2025-I'),  -- Luis en POO
(4, 3, 3, '2025-I'),  -- Sofía en Fundamentos de Administración
(5, 4, 4, '2025-I'),  -- Juan en Contabilidad
(6, 5, 2, '2025-I'),  -- Carolina en Bases de Datos
(7, 5, 5, '2025-I');  -- Carolina en Ingeniería de Requisitos




-- Cursos que dicta un profesor específico
SELECT p.nombre AS Profesor, c.nombre AS Curso
FROM UniversidadESEIT.Profesor p
JOIN UniversidadESEIT.Curso c ON p.id_profesor = c.id_profesor
WHERE p.nombre = 'Carlos Ramírez';

-- Estudiantes inscritos en un curso
SELECT c.nombre AS Curso, e.nombre AS Estudiante, i.semestre
FROM UniversidadESEIT.Inscripcion i
JOIN UniversidadESEIT.Curso c ON i.id_curso = c.id_curso
JOIN UniversidadESEIT.Estudiante e ON i.id_estudiante = e.id_estudiante
WHERE c.nombre = 'Bases de Datos I';
