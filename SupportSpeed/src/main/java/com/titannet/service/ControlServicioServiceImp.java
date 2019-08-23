package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.titannet.dao.IControlServicio;
import com.titannet.entity.ControlServicio;
import com.titannet.entity.Servicio;


@Service
public class ControlServicioServiceImp implements IControlServicioService {

	
	@Autowired
	IControlServicio controlserviciodao;
	
	@Override
	public List<ControlServicio> findAll() {		
		return (List<ControlServicio>)controlserviciodao.findAll();
	}

	@Override
	public Page<ControlServicio> findAll(Pageable pageable) {
		
		return controlserviciodao.findAll(pageable);
	}

	@Override
	public void save(ControlServicio controlservicio) {
		controlserviciodao.save(controlservicio);
		
	}

	@Override
	public ControlServicio findById(Long id) {		
		return controlserviciodao.findById(id).get();
	}

	@Override
	public void delete(ControlServicio controlservicio) {
		controlserviciodao.delete(controlservicio);
		
	}

	@Override
	public List<ControlServicio> listaCServicio(Servicio servicio) {		
		return controlserviciodao.listaCServicio(servicio);
	}

}
