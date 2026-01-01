-- CREATE DATABASE control_acceso DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;
-- SHOW DATABASES;
USE control_acceso;
-- SELECT DATABASE();
-- SHOW TABLES;
-- DROP TABLE datos;

/*CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  key_pass VARCHAR(100) NOT NULL
);*/

/*INSERT INTO usuarios (user,password,key_pass)
VALUES ('anonymous','null','null');*/

/*CREATE TABLE logs (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT NOT NULL,
  fecha_hora DATETIME DEFAULT CURRENT_TIMESTAMP,
  accion VARCHAR(30) NOT NULL,
  descripcion VARCHAR(150) NULL,

  CONSTRAINT fk_logs_usuario
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);*/

/*INSERT INTO logs (usuario_id,accion,descripcion)
VALUES (6,'Login_FAIL','Login Erroneo');*/

/*CREATE TABLE datos (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    waiting_time INT NOT NULL,
    unit_time VARCHAR(30) NOT NULL,
    attempts INT NOT NULL,
    open_door_time INT NOT NULL,
    unit_door_time VARCHAR (30) NOT NULL
    );*/

/*INSERT INTO datos (waiting_time,unit_time,attempts,open_door_time,unit_door_time)
VALUES (5,'seg',3,5,'seg');*/

-- DESCRIBE usuarios;
-- DESCRIBE logs;
-- DESCRIBE datos;
-- SELECT * FROM usuarios;
-- SELECT * FROM logs;
-- SELECT * FROM datos;

SELECT
  id,
  usuario_id,
  DATE_FORMAT(fecha_hora, '%d-%m-%Y %H:%i:%s') AS fecha_formato,
  accion,
  descripcion
FROM logs;