package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.titannet.entity.ControlServicio;
import com.titannet.entity.Servicio;



public interface IControlServicioService {
	public List<ControlServicio> findAll();
	public Page<ControlServicio> findAll(Pageable pageable);
	public void save(ControlServicio controlservicio);
	public ControlServicio findById(Long id);
	public void delete(ControlServicio controlservicio);
	public List<ControlServicio> listaCServicio (Servicio servicio);	
}
