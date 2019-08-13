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
@Table (name="estadoServicio")
public class EstadoServicio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String estado;
	private String descripcion;
	
	@OneToMany(mappedBy="estadoservicio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<Servicio> listaservicioestado;
	
	
	
	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public List<Servicio> getListaservicioestado() {
		return listaservicioestado;
	}



	public void setListaservicioestado(List<Servicio> listaservicioestado) {
		this.listaservicioestado = listaservicioestado;
	}



	private static final long serialVersionUID = 1L;

	
}
