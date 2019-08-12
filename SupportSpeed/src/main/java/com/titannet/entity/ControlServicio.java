package com.titannet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="controlservicio")
public class ControlServicio implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Servicio servicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EstadoServicio estadoservicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Trabajador trabajadorCambio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Trabajador trabajadorAsignado;
	
	@Temporal(TemporalType.DATE)	
	private Date fecha;
	
	
	
	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public Servicio getServicio() {
		return servicio;
	}



	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}



	public EstadoServicio getEstadoservicio() {
		return estadoservicio;
	}



	public void setEstadoservicio(EstadoServicio estadoservicio) {
		this.estadoservicio = estadoservicio;
	}



	public Trabajador getTrabajadorCambio() {
		return trabajadorCambio;
	}



	public void setTrabajadorCambio(Trabajador trabajadorCambio) {
		this.trabajadorCambio = trabajadorCambio;
	}



	public Trabajador getTrabajadorAsignado() {
		return trabajadorAsignado;
	}



	public void setTrabajadorAsignado(Trabajador trabajadorAsignado) {
		this.trabajadorAsignado = trabajadorAsignado;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	private static final long serialVersionUID = 1L;

	
}
