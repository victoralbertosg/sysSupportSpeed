/* Populate tables */

INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Soto Gutierrez', 'sjl', '40182907', 'Victor Alberto');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Rivera', 'callao', '12121', 'Carlos');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Rcira', 'ventanilla', '12121', 'Jhony');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Lazaro', 'cercado', '21212', 'Jose');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Rojas Ramos', 'sjl', '40182907', 'Manuel');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Alcantara Valdez', 'callao', '12121', 'Daniel');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Romeo Panes', 'ventanilla', '12121', 'Maria');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Mujica Alvarado', 'cercado', '21212', 'Monica');

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
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('cliente1','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1,1);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1,2);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('soporte1','$2a$10$mc7NrKUnjGDH/rX8S4bKxelZkO7XNrwKp8F66hIxPBp3Py6NNku1K',1,3);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('soporte2','$2a$10$rmxRgCXl2rOIyGY5vivWCe4r0GuIYdVkhE8IlsNCaoneKjHdJB4O.',1,4);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('soporte3','$$2a$10$fE8kRCgRg/bMvT8oiiUCM.4s20Of/lZZ7OBwFGT3ZWoveNx9T0RzW',1,5);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('soporte4','$2a$10$fE8kRCgRg/bMvT8oiiUCM.4s20Of/lZZ7OBwFGT3ZWoveNx9T0RzW',1,6);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('cliente2','$$2a$10$fE8kRCgRg/bMvT8oiiUCM.4s20Of/lZZ7OBwFGT3ZWoveNx9T0RzW',1,7);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('cliente3','$2a$10$fE8kRCgRg/bMvT8oiiUCM.4s20Of/lZZ7OBwFGT3ZWoveNx9T0RzW',1,8);

INSERT INTO `roles` (fk_usuario, authority) VALUES (1,'ROLE_CLIENTE');
INSERT INTO `roles` (fk_usuario, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `roles` (fk_usuario, authority) VALUES (3,'ROLE_SOPORTE');
INSERT INTO `roles` (fk_usuario, authority) VALUES (4,'ROLE_SOPORTE');
INSERT INTO `roles` (fk_usuario, authority) VALUES (5,'ROLE_SOPORTE');
INSERT INTO `roles` (fk_usuario, authority) VALUES (6,'ROLE_SOPORTE');
INSERT INTO `roles` (fk_usuario, authority) VALUES (7,'ROLE_CLIENTE');
INSERT INTO `roles` (fk_usuario, authority) VALUES (8,'ROLE_CLIENTE');


INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '2', '1','2','1','se solicita mantenimiento de pcs');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '2', '2','1','2','se solicita monitoreo de sistemas');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '3', '2','3','3','se solicita mantenimiento de cableado');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`,descripcion) VALUES ('2019-08-16', '3', '1','1','1','se levantamiento de incidencias');