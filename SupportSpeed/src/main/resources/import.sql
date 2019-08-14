/* Populate tables */
INSERT INTO trabajadores (nombre, apellido) VALUES('Victor', 'Soto');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');
INSERT INTO trabajadores (nombre, apellido) VALUES('Andres', 'Guzman');


INSERT INTO tiposervicios (descripcion) VALUES ('Soporte');
INSERT INTO tiposervicios (descripcion) VALUES ('Mantenimiento de redes');
INSERT INTO tiposervicios (descripcion) VALUES ('Monitoreo de Sistemas');

INSERT INTO estado_servicio (descripcion, estado) VALUES ('inicio servicio', 'nuevo');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('trabajo programado', 'asignado');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('conformidad cliente', 'completado');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('conformidad admin', 'cerrado');


/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');