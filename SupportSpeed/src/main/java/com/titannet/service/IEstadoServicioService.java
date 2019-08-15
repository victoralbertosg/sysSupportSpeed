package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.titannet.entity.EstadoServicio;

public interface IEstadoServicioService {
	public List<EstadoServicio> findAll();
	public Page<EstadoServicio> findAll(Pageable pageable);
	public void save(EstadoServicio eservicio);
	public EstadoServicio findById(Long id);
	public void delete(EstadoServicio eservicio);	
}
