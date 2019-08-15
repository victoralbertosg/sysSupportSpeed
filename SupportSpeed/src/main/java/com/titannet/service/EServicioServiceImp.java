package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.titannet.dao.IEstadoServicio;
import com.titannet.entity.EstadoServicio;

@Service
public class EServicioServiceImp implements IEstadoServicioService {

	@Autowired
	IEstadoServicio estadoServicio;
	
	@Override
	public List<EstadoServicio> findAll() {		
		return (List<EstadoServicio>)estadoServicio.findAll();
	}

	@Override
	public Page<EstadoServicio> findAll(Pageable pageable) {		
		return estadoServicio.findAll(pageable);
	}

	@Override
	public void save(EstadoServicio eservicio) {
		estadoServicio.save(eservicio);	
	}

	@Override
	public EstadoServicio findById(Long id) {		
		return estadoServicio.findById(id).orElse(null);				
	}

	@Override
	public void delete(EstadoServicio eservicio) {
		// TODO Auto-generated method stub
		estadoServicio.delete(eservicio);		
	}	
}
