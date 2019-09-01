/* Populate tables */

INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (1,'Soto Gutierrez', 'sjl', '40182907', 'Victor Alberto');
INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (2,'Rivera', 'callao', '12121', 'Carlos');
INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (3,'Rcira', 'ventanilla', '12121', 'Jhony');
INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (4,'Lazaro', 'cercado', '21212', 'Jose');
INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (5,'Rojas Ramos', 'sjl', '40182907', 'Manuel');
INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (6,'Alcantara Valdez', 'callao', '12121', 'Daniel');
INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (7,'Romeo Panes', 'ventanilla', '12121', 'Maria');
INSERT INTO `heroku_5f6fa6440c4b697`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (8,'Mujica Alvarado', 'cercado', '21212', 'Monica');

INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (1,'Soto Gutierrez', 'sjl', '40182907', 'Victor Alberto');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (2,'Rivera', 'callao', '12121', 'Carlos');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (3,'Rcira', 'ventanilla', '12121', 'Jhony');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (4,'Lazaro', 'cercado', '21212', 'Jose');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (5,'Rojas Ramos', 'sjl', '40182907', 'Manuel');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (6,'Alcantara Valdez', 'callao', '12121', 'Daniel');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (7,'Romeo Panes', 'ventanilla', '12121', 'Maria');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (8,'Mujica Alvarado', 'cercado', '21212', 'Monica');



INSERT INTO `heroku_5f6fa6440c4b697`.`cargo` (id,`cargo`) VALUES (1,'Soporte Informático');
INSERT INTO `heroku_5f6fa6440c4b697`.`cargo` (id,`cargo`) VALUES (2,'Analista de Sistemas');
INSERT INTO `heroku_5f6fa6440c4b697`.`cargo` (id,`cargo`) VALUES (3,'Administrador');
INSERT INTO `heroku_5f6fa6440c4b697`.`cargo` (id,`cargo`) VALUES (4,'Progrador');

INSERT INTO `bddsupport`.`cargo` (id,`cargo`) VALUES (1,'Soporte Informático');
INSERT INTO `bddsupport`.`cargo` (id,`cargo`) VALUES (2,'Analista de Sistemas');
INSERT INTO `bddsupport`.`cargo` (id,`cargo`) VALUES (3,'Administrador');
INSERT INTO `bddsupport`.`cargo` (id,`cargo`) VALUES (4,'Progrador');


INSERT INTO `heroku_5f6fa6440c4b697`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (1,1, 2);
INSERT INTO `heroku_5f6fa6440c4b697`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (2,2', 3);
INSERT INTO `heroku_5f6fa6440c4b697`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (3,2, 4);
INSERT INTO `heroku_5f6fa6440c4b697`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (4,3, 5);
INSERT INTO `heroku_5f6fa6440c4b697`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (5,1, 6);
INSERT INTO `heroku_5f6fa6440c4b697`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (6,1, 7);

INSERT INTO `bddsupport`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (1,1, 2);
INSERT INTO `bddsupport`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (2,2', 3);
INSERT INTO `bddsupport`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (3,2, 4);
INSERT INTO `bddsupport`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (4,3, 5);
INSERT INTO `bddsupport`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (5,1, 6);
INSERT INTO `bddsupport`.`trabajadores` (id,`fk_cargo`, `fk_persona`) VALUES (6,1, 7);


INSERT INTO `bddsupport`.tiposervicios (id,descripcion) VALUES (1,'Soporte');
INSERT INTO `bddsupport`.tiposervicios (id,descripcion) VALUES (2,'Mantenimiento de redes');
INSERT INTO `bddsupport`.tiposervicios (id,descripcion) VALUES (3,'Monitoreo de Sistemas');

INSERT INTO `heroku_5f6fa6440c4b697`.tiposervicios (id,descripcion) VALUES (1,'Soporte');
INSERT INTO `heroku_5f6fa6440c4b697`.tiposervicios (id,descripcion) VALUES (2,'Mantenimiento de redes');
INSERT INTO `heroku_5f6fa6440c4b697`.tiposervicios (id,descripcion) VALUES (3,'Monitoreo de Sistemas');

INSERT INTO `bddsupport`.estado_servicio (id,descripcion, estado) VALUES (1,'inicio servicio', 'nuevo');
INSERT INTO `bddsupport`.estado_servicio (id,descripcion, estado) VALUES (2,'trabajador  asignado', 'asignado');
INSERT INTO `bddsupport`.estado_servicio (id,descripcion, estado) VALUES (3,'informe trabajos realizados', 'servicio cumplido');
INSERT INTO `bddsupport`.estado_servicio (id,descripcion, estado) VALUES (4,'conformidad del cliente', 'conformidad del cliente');
INSERT INTO `bddsupport`.estado_servicio (id,descripcion, estado) VALUES (5,'Conformidad del Administrador', 'conformidad del administrador');
INSERT INTO `bddsupport`.estado_servicio (id,descripcion, estado) VALUES (6,'Archivo del servicio', 'Archivado');

INSERT INTO `heroku_5f6fa6440c4b697`.estado_servicio (id,descripcion, estado) VALUES (1,'inicio servicio', 'nuevo');
INSERT INTO `heroku_5f6fa6440c4b697`.estado_servicio (id,descripcion, estado) VALUES (2,'trabajador  asignado', 'asignado');
INSERT INTO `heroku_5f6fa6440c4b697`.estado_servicio (id,descripcion, estado) VALUES (3,'informe trabajos realizados', 'servicio cumplido');
INSERT INTO `heroku_5f6fa6440c4b697`.estado_servicio (id,descripcion, estado) VALUES (4,'conformidad del cliente', 'conformidad del cliente');
INSERT INTO `heroku_5f6fa6440c4b697`.estado_servicio (id,descripcion, estado) VALUES (5,'Conformidad del Administrador', 'conformidad del administrador');
INSERT INTO `heroku_5f6fa6440c4b697`.estado_servicio (id,descripcion, estado) VALUES (6,'Archivo del servicio', 'Archivado');



INSERT INTO `bddsupport`.`clientes` (id,`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES (1,'Sjl', 'Clinica San Juan', 'Salud',1);
INSERT INTO `bddsupport`.`clientes` (id,`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES (2,'Comas', 'Clinica San Pablo', 'Salud',7);
INSERT INTO `bddsupport`.`clientes` (id,`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES (3,'Cercado', 'JujomiSac', 'tecnologia',8);

INSERT INTO `heroku_5f6fa6440c4b697`.`clientes` (id,`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES (1,'Sjl', 'Clinica San Juan', 'Salud',1);
INSERT INTO `heroku_5f6fa6440c4b697`.`clientes` (id,`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES (2,'Comas', 'Clinica San Pablo', 'Salud',7);
INSERT INTO `heroku_5f6fa6440c4b697`.`clientes` (id,`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES (3,'Cercado', 'JujomiSac', 'tecnologia',8);

/* Creamos algunos usuarios con sus roles */
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (1,'cliente1','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1,1);
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (2,'admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1,2);
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (3,'soporte1','$2a$10$mc7NrKUnjGDH/rX8S4bKxelZkO7XNrwKp8F66hIxPBp3Py6NNku1K',1,3);
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (4,'soporte2','$2a$10$rmxRgCXl2rOIyGY5vivWCe4r0GuIYdVkhE8IlsNCaoneKjHdJB4O.',1,4);
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (5,'soporte3','$2a$10$xnGs.DiHewUsbrGC15UJi.96HjIKVo/UuP2GMmEHFSDqgAuUbXieu',1,5);
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (6,'soporte4','$2a$10$9kE7cDjzm7ouAyiQv956zu2w4PYquOnMCn4vmaNWBye8g5izNxjom',1,6);
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (7,'cliente2','$2a$10$FYmX5qY6EPHz/ABAkUkgzeaBogpF87Of7nPpEpaRUR8afWg.L9zge',1,7);
INSERT INTO `bddsupport`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (8,'cliente3','$2a$10$mEy5YwGg6/iWWALHJN4HOudPRN3lI/zhEHMYP.F1VKB54jd3pXMP.',1,8);

INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (1,'cliente1','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1,1);
INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (2,'admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1,2);
INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (3,'soporte1','$2a$10$mc7NrKUnjGDH/rX8S4bKxelZkO7XNrwKp8F66hIxPBp3Py6NNku1K',1,3);
INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (4,'soporte2','$2a$10$rmxRgCXl2rOIyGY5vivWCe4r0GuIYdVkhE8IlsNCaoneKjHdJB4O.',1,4);
INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (5,'soporte3','$2a$10$xnGs.DiHewUsbrGC15UJi.96HjIKVo/UuP2GMmEHFSDqgAuUbXieu',1,5);
INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (6,'soporte4','$2a$10$9kE7cDjzm7ouAyiQv956zu2w4PYquOnMCn4vmaNWBye8g5izNxjom',1,6);
INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (7,'cliente2','$2a$10$FYmX5qY6EPHz/ABAkUkgzeaBogpF87Of7nPpEpaRUR8afWg.L9zge',1,7);
INSERT INTO `heroku_5f6fa6440c4b697`.`usuarios` (id,username, password, enabled,fk_persona) VALUES (8,'cliente3','$2a$10$mEy5YwGg6/iWWALHJN4HOudPRN3lI/zhEHMYP.F1VKB54jd3pXMP.',1,8);


INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (1,1,'ROLE_CLIENTE');
INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (2,2,'ROLE_ADMIN');
INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (3,3,'ROLE_SOPORTE');
INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (4,4,'ROLE_SOPORTE');
INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (5,5,'ROLE_SOPORTE');
INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (6,6,'ROLE_SOPORTE');
INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (7,7,'ROLE_CLIENTE');
INSERT INTO `bddsupport`.`roles` (id,fk_usuario, authority) VALUES (8,8,'ROLE_CLIENTE');

INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (1,1,'ROLE_CLIENTE');
INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (2,2,'ROLE_ADMIN');
INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (3,3,'ROLE_SOPORTE');
INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (4,4,'ROLE_SOPORTE');
INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (5,5,'ROLE_SOPORTE');
INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (6,6,'ROLE_SOPORTE');
INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (7,7,'ROLE_CLIENTE');
INSERT INTO `heroku_5f6fa6440c4b697`.`roles` (id,fk_usuario, authority) VALUES (8,8,'ROLE_CLIENTE');


INSERT INTO `bddsupport`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (1,'2019-08-16', '2', '1','2','1','se solicita mantenimiento de pcs');
INSERT INTO `bddsupport`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (2,'2019-08-16', '2', '2','1','2','se solicita monitoreo de sistemas');
INSERT INTO `bddsupport`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (3,'2019-08-16', '3', '2','3','3','se solicita mantenimiento de cableado');
INSERT INTO `bddsupport`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (4,'2019-08-16', '3', '1','1','1','se levantamiento de incidencias');

INSERT INTO `heroku_5f6fa6440c4b697`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (1,'2019-08-16', '2', '1','2','1','se solicita mantenimiento de pcs');
INSERT INTO `heroku_5f6fa6440c4b697`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (2,'2019-08-16', '2', '2','1','2','se solicita monitoreo de sistemas');
INSERT INTO `heroku_5f6fa6440c4b697`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (3,'2019-08-16', '3', '2','3','3','se solicita mantenimiento de cableado');
INSERT INTO `heroku_5f6fa6440c4b697`.servicios (id,`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES (4,'2019-08-16', '3', '1','1','1','se levantamiento de incidencias');
