package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.titannet.entity.Servicio;
import com.titannet.entity.Trabajador;

public interface IServicioService {
	public List<Servicio> findAll();
	public Page<Servicio> findAll(Pageable pageable);
	public void save(Servicio servicio);
	public Servicio findById(Long id);
	public void delete(Servicio servicio);
}
