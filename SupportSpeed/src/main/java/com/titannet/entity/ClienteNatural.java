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
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteNatural implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	private String apellido;	
	private Long dni;
	private String direccion;
	
	@OneToMany( mappedBy = "clientenatural",fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Servicio> listaserviciocliente;
	
	
	
	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
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



	public Long getDni() {
		return dni;
	}



	public void setDni(Long dni) {
		this.dni = dni;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public List<Servicio> getListaserviciocliente() {
		return listaserviciocliente;
	}



	public void setListaserviciocliente(List<Servicio> listaserviciocliente) {
		this.listaserviciocliente = listaserviciocliente;
	}



	private static final long serialVersionUID = 1L;

}
