package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.titannet.entity.ControlServicio;
import com.titannet.entity.EstadoServicio;
import com.titannet.entity.Persona;
import com.titannet.entity.Servicio;



public interface IServicioService {
	public List<Servicio> findAll();
	public Page<Servicio> findAll(Pageable pageable);
	public void save(Servicio servicio);
	public Servicio findById(Long id);
	public void delete(Servicio servicio);
	public List<Servicio> servicioEstado1(EstadoServicio es);
	public List<Servicio> servicioTrabajador (Persona persona);
	public List<Servicio> servicioTrabajadorEstado (Persona persona,EstadoServicio es);
	public List<Servicio> servicioClienteEstado (Persona persona,EstadoServicio es);
}
