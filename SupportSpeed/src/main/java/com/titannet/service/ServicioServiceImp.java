package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.dao.IServicioDao;
import com.titannet.entity.Servicio;

@Service
public class ServicioServiceImp implements IServicioService{

	@Autowired
	IServicioDao servicioDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Servicio> findAll() {	
		return (List<Servicio>)servicioDao.findAll();
	}

	@Override
	public Page<Servicio> findAll(Pageable pageable) {		
		return servicioDao.findAll(pageable);
	}

	@Override
	public void save(Servicio servicio) {
		servicioDao.save(servicio);
		
	}

	@Override
	public Servicio findById(Long id) {		
		return servicioDao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Servicio servicio) {
		servicioDao.delete(servicio);		
	}

}
