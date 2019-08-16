package com.titannet.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.dao.ITrabajadorDao;
import com.titannet.entity.Trabajador;

@Service
public class TrabajadorServiceImp implements ITrabajadorService {

	@Autowired
	ITrabajadorDao trabajadorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Trabajador> findAll() {		
		return (List<Trabajador>) trabajadorDao.findAll();
	}

	@Override
	public Page<Trabajador> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return trabajadorDao.findAll(pageable);
	}
	@Override
	public void save(Trabajador trabajador) {
		
		trabajadorDao.save(trabajador);		
	}

	@Override
	public Trabajador findById(Long id) {		
		return trabajadorDao.findById(id).get();	
	}


	@Override
	@Transactional
	public void delete(Trabajador trabajador) {
		trabajadorDao.delete(trabajador);		
	}
}
