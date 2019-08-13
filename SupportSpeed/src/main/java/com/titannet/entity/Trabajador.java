package com.titannet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
@Table(name = "trabajadores")
public class Trabajador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nombre;
	private String Apellido;
	private Long dni;
	
	
	@OneToMany( mappedBy="trabajador",fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Servicio> listaserviciotrabajador;

			
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	private static final long serialVersionUID = 1L;

}
