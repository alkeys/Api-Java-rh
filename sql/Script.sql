-- Tabla: cargos
CREATE TABLE cargos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    salario_base DECIMAL(10,2) NOT NULL
);

-- Tabla: departamento
CREATE TABLE departamento (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla: empleados
CREATE TABLE empleados (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    fecha_contratacion DATE NOT NULL,
    cargo_id INTEGER NOT NULL REFERENCES cargos(id),
    departamento_id INTEGER NOT NULL REFERENCES departamento(id)
);

-- Tabla: asistencias
CREATE TABLE asistencias (
    id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora_entrada TIME NOT NULL,
    hora_salida TIME,
    empleado_id INTEGER NOT NULL REFERENCES empleados(id)
);

-- Tabla: users
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    rol VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL
);

-- Tabla: logs
CREATE TABLE logs (
    id SERIAL PRIMARY KEY,
    action VARCHAR(255) NOT NULL,
    timestamp TIMESTAMP NOT NULL DEFAULT NOW(),
    user_id INTEGER NOT NULL REFERENCES users(id)
);

-- Tabla: evaluaciones
CREATE TABLE evaluaciones (
    id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    descripcion TEXT NOT NULL,
    empleado_id INTEGER NOT NULL REFERENCES empleados(id),
    departamento_id INTEGER NOT NULL REFERENCES departamento(id)
);

-- Tabla: preguntas_evaluacion
CREATE TABLE preguntas_evaluacion (
    id SERIAL PRIMARY KEY,
    evaluacion_id INTEGER NOT NULL REFERENCES evaluaciones(id) ON DELETE CASCADE,
    pregunta TEXT NOT NULL
);