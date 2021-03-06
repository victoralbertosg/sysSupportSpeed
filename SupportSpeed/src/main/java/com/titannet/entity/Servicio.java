package com.titannet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import java.util.List;


@Entity
@Table (name="servicios")
public class Servicio implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="fk_tiposervicio")
	private TipoServicio tiposervicio;
	
	
	@OneToMany(mappedBy = "servicio",fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<ControlServicio> listacontrol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_estadoservicio")	
	private EstadoServicio estadoservicio;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_cliente")	
	private Cliente cliente;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_trabajador")
	private Trabajador trabajador;
		
	@Temporal(TemporalType.DATE)	
	private Date fecha;
	

	private String descripcion;
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
		
		}
	
	    
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Servicio() {
		super();
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public TipoServicio getTiposervicio() {
		return tiposervicio;
	}


	public void setTiposervicio(TipoServicio tiposervicio) {
		this.tiposervicio = tiposervicio;
	}


	public List<ControlServicio> getListacontrol() {
		return listacontrol;
	}


	public void setListacontrol(List<ControlServicio> listacontrol) {
		this.listacontrol = listacontrol;
	}


	public EstadoServicio getEstadoservicio() {
		return estadoservicio;
	}


	public void setEstadoservicio(EstadoServicio estadoservicio) {
		this.estadoservicio = estadoservicio;
	}



	public Trabajador getTrabajador() {
		return trabajador;
	}


	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
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


	private static final long serialVersionUID = 1L;

	
	
}
