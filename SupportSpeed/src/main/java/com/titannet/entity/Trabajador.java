package com.titannet.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "trabajadores")
public class Trabajador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_persona")	
	private Persona persona;	
	
	private Date Fecha_inicio;	
	@OneToMany( mappedBy="trabajador",fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Servicio> listaserviciotrabajador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_cargo")
	private Cargo cargo;
	

	

	public Long getId() {
		return Id;
	}




	public void setId(Long id) {
		Id = id;
	}




	public Persona getPersona() {
		return persona;
	}




	public void setPersona(Persona persona) {
		this.persona = persona;
	}




	public Date getFecha_inicio() {
		return Fecha_inicio;
	}




	public void setFecha_inicio(Date fecha_inicio) {
		Fecha_inicio = fecha_inicio;
	}




	public List<Servicio> getListaserviciotrabajador() {
		return listaserviciotrabajador;
	}




	public void setListaserviciotrabajador(List<Servicio> listaserviciotrabajador) {
		this.listaserviciotrabajador = listaserviciotrabajador;
	}




	public Cargo getCargo() {
		return cargo;
	}




	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}




	private static final long serialVersionUID = 1L;

}
