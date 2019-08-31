/* Populate tables */

INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (1,'Soto Gutierrez', 'sjl', '40182907', 'Victor Alberto');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (2,'Rivera', 'callao', '12121', 'Carlos');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (3,'Rcira', 'ventanilla', '12121', 'Jhony');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (4,'Lazaro', 'cercado', '21212', 'Jose');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (5,'Rojas Ramos', 'sjl', '40182907', 'Manuel');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (6,'Alcantara Valdez', 'callao', '12121', 'Daniel');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (7,'Romeo Panes', 'ventanilla', '12121', 'Maria');
INSERT INTO `bddsupport`.`persona` (id,`apellido`, `direccion`, `dni`, `nombre`) VALUES (8,'Mujica Alvarado', 'cercado', '21212', 'Monica');

INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Soporte Informático');
INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Analista de Sistemas');
INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Administrador');
INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Progrador');

INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('1', '2');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('1', '3');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('2', '4');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('3', '5');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('1', '6');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('1', '7');


INSERT INTO tiposervicios (descripcion) VALUES ('Soporte');
INSERT INTO tiposervicios (descripcion) VALUES ('Mantenimiento de redes');
INSERT INTO tiposervicios (descripcion) VALUES ('Monitoreo de Sistemas');

INSERT INTO estado_servicio (descripcion, estado) VALUES ('inicio servicio', 'nuevo');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('trabajador  asignado', 'asignado');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('informe trabajos realizados', 'servicio cumplido');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('conformidad del cliente', 'conformidad del cliente');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('Conformidad del Administrador', 'conformidad del administrador');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('Archivo del servicio', 'Archivado');


INSERT INTO `bddsupport`.`clientes` (`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES ('Sjl', 'Clinica San Juan', 'Salud',1);
INSERT INTO `bddsupport`.`clientes` (`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES ('Comas', 'Clinica San Pablo', 'Salud',7);
INSERT INTO `bddsupport`.`clientes` (`direccion`, `razonsocial`, `rubro`,fk_persona) VALUES ('Cercado', 'JujomiSac', 'tecnologia',8);


/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (1,'cliente1','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1,1);
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (2,'admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1,2);
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (3,'soporte1','$2a$10$mc7NrKUnjGDH/rX8S4bKxelZkO7XNrwKp8F66hIxPBp3Py6NNku1K',1,3);
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (4,'soporte2','$2a$10$rmxRgCXl2rOIyGY5vivWCe4r0GuIYdVkhE8IlsNCaoneKjHdJB4O.',1,4);
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (5,'soporte3','$2a$10$xnGs.DiHewUsbrGC15UJi.96HjIKVo/UuP2GMmEHFSDqgAuUbXieu',1,5);
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (6,'soporte4','$2a$10$9kE7cDjzm7ouAyiQv956zu2w4PYquOnMCn4vmaNWBye8g5izNxjom',1,6);
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (7,'cliente2','$2a$10$FYmX5qY6EPHz/ABAkUkgzeaBogpF87Of7nPpEpaRUR8afWg.L9zge',1,7);
INSERT INTO `usuarios` (id,username, password, enabled,fk_persona) VALUES (8,'cliente3','$2a$10$mEy5YwGg6/iWWALHJN4HOudPRN3lI/zhEHMYP.F1VKB54jd3pXMP.',1,8);

INSERT INTO `roles` (id,fk_usuario, authority) VALUES (1,1,'ROLE_CLIENTE');
INSERT INTO `roles` (id,fk_usuario, authority) VALUES (2,2,'ROLE_ADMIN');
INSERT INTO `roles` (id,fk_usuario, authority) VALUES (3,3,'ROLE_SOPORTE');
INSERT INTO `roles` (id,fk_usuario, authority) VALUES (4,4,'ROLE_SOPORTE');
INSERT INTO `roles` (id,fk_usuario, authority) VALUES (5,5,'ROLE_SOPORTE');
INSERT INTO `roles` (id,fk_usuario, authority) VALUES (6,6,'ROLE_SOPORTE');
INSERT INTO `roles` (id,fk_usuario, authority) VALUES (7,7,'ROLE_CLIENTE');
INSERT INTO `roles` (id,fk_usuario, authority) VALUES (8,8,'ROLE_CLIENTE');



INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '2', '1','2','1','se solicita mantenimiento de pcs');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '2', '2','1','2','se solicita monitoreo de sistemas');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '3', '2','3','3','se solicita mantenimiento de cableado');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '3', '1','1','1','se levantamiento de incidencias');