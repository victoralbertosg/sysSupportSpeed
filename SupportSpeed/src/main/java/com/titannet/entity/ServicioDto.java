package com.titannet.entity;

import java.util.Date;

public class ServicioDto {
private Long id;
private String descripcion;
private Date fecha;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public ServicioDto(Long id, String descripcion, Date fecha) {	
	this.id = id;
	this.descripcion = descripcion;
	this.fecha = fecha;
}

public ServicioDto() {

}


}
