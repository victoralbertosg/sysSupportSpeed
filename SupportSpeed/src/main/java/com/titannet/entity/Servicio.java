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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



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
	private ClienteNatural clientenatural;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_trabajador")
	private Trabajador trabajador;
		
	@Temporal(TemporalType.DATE)	
	private Date fecha;
	
	
	
	
	public Servicio(TipoServicio tiposervicio, 
			EstadoServicio estadoservicio, ClienteNatural clientenatural, Trabajador trabajador, Date fecha) {		
		this.tiposervicio = tiposervicio;		
		this.estadoservicio = estadoservicio;
		this.clientenatural = clientenatural;
		this.trabajador = trabajador;
		this.fecha = fecha;
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


	public ClienteNatural getClientenatural() {
		return clientenatural;
	}


	public void setClientenatural(ClienteNatural clientenatural) {
		this.clientenatural = clientenatural;
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


	private static final long serialVersionUID = 1L;

	
	
}
