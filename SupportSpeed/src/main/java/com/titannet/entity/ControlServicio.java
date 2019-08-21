package com.titannet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
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
	@JoinColumn(name = "fk_servicio", nullable = false)
	private Servicio servicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_estadoservicio")
	private EstadoServicio estadoservicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_trabajador")
	private Trabajador trabajador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;
	
	
	@Temporal(TemporalType.DATE)	
	private Date fecha;
	
	private String logCambio;	
	private String descripcion;
	
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();		
		}
	
	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



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


	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getLogCambio() {
		return logCambio;
	}

	public void setLogCambio(String logCambio) {
		this.logCambio = logCambio;
	}

	public ControlServicio() {
		super();
	}



	private static final long serialVersionUID = 1L;

	
}
