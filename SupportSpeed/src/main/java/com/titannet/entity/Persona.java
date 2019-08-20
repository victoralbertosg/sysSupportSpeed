package com.titannet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;	
	private String apellido;	
	private String dni;
	private String direccion;
	
	@OneToMany(mappedBy = "persona",fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy = "persona",fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Cliente> clientes;
	
	@OneToMany(mappedBy = "persona",fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Trabajador> trabajador;
		
	
	public Long getId() {
		return id;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Trabajador> getTrabajador() {
		return trabajador;
	}


	public void setTrabajador(List<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido() {
		return apellido;
	}





	public void setApellido(String apellido) {
		this.apellido = apellido;
	}





	public String getDni() {
		return dni;
	}





	public void setDni(String dni) {
		this.dni = dni;
	}





	public String getDireccion() {
		return direccion;
	}





	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}





	public List<Usuario> getUsuarios() {
		return usuarios;
	}





	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}





	private static final long serialVersionUID = 1L;

	
}
