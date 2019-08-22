/* Populate tables */

INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Soto Gutierrez', 'sjl', '40182907', 'Victor Alberto');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Rivera', 'callao', '12121', 'Carlos');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Rcira', 'ventanilla', '12121', 'Jhony');
INSERT INTO `bddsupport`.`persona` (`apellido`, `direccion`, `dni`, `nombre`) VALUES ('Lazaro', 'cercado', '21212', 'Jose');

INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Soporte Informático');
INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Analista de Sistemas');
INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Administrador');
INSERT INTO `bddsupport`.`cargo` (`cargo`) VALUES ('Progrador');

INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('1', '1');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('1', '2');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('2', '3');
INSERT INTO `bddsupport`.`trabajadores` (`fk_cargo`, `fk_persona`) VALUES ('3', '4');


INSERT INTO tiposervicios (descripcion) VALUES ('Soporte');
INSERT INTO tiposervicios (descripcion) VALUES ('Mantenimiento de redes');
INSERT INTO tiposervicios (descripcion) VALUES ('Monitoreo de Sistemas');

INSERT INTO estado_servicio (descripcion, estado) VALUES ('inicio servicio', 'nuevo');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('trabajador  asignado', 'asignado');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('conformidad cliente', 'completado');
INSERT INTO estado_servicio (descripcion, estado) VALUES ('conformidad admin', 'cerrado');

INSERT INTO `bddsupport`.`clientes` (`direccion`, `razonsocial`, `rubro`) VALUES ('Sjl', 'Clinica San Juan', 'Salud');
INSERT INTO `bddsupport`.`clientes` (`direccion`, `razonsocial`, `rubro`) VALUES ('Comas', 'Clinica San Pablo', 'Salud');
INSERT INTO `bddsupport`.`clientes` (`direccion`, `razonsocial`, `rubro`) VALUES ('Cercado', 'JujomiSac', 'tecnologia');
INSERT INTO `bddsupport`.`clientes` (`direccion`, `razonsocial`, `rubro`) VALUES ('Cercado', 'Clinica internacional', 'Salu');

/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('victor','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1,1);
INSERT INTO `usuarios` (username, password, enabled,fk_persona) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1,2);

INSERT INTO `roles` (fk_usuario, authority) VALUES (1,'ROLE_USER');
INSERT INTO `roles` (fk_usuario, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `roles` (fk_usuario, authority) VALUES (2,'ROLE_USER');


INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`) VALUES ('2019-08-16', '2', '1','2','1');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`) VALUES ('2019-08-16', '2', '2','1','2');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`) VALUES ('2019-08-16', '3', '2','3','3');
INSERT INTO servicios (`fecha`, `fk_estadoservicio`, `fk_tiposervicio`, `fk_cliente`,`fk_trabajador`) VALUES ('2019-08-16', '3', '1','1','1');