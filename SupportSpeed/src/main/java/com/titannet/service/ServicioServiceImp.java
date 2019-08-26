package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.dao.IServicioDao;
import com.titannet.entity.EstadoServicio;
import com.titannet.entity.Persona;
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

	@Override
	public List<Servicio> servicioEstado1(EstadoServicio es) {
		// TODO Auto-generated method stub
		return servicioDao.servicioEstado1(es);
	}

	@Override
	public List<Servicio> servicioTrabajador(Persona persona) {		
		return servicioDao.servicioTrabajador(persona);
	}

	@Override
	public List<Servicio> servicioTrabajadorEstado(Persona persona, EstadoServicio estadoServicio) {		
		return servicioDao.servicioTrabajadorEstado(persona, estadoServicio);
	}

	@Override
	public List<Servicio> servicioClienteEstado(Persona persona, EstadoServicio es) {
		return servicioDao.servicioClienteEstado(persona, es);
	}

}
