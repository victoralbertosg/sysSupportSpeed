package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.titannet.dao.IPersonaDao;
import com.titannet.entity.Persona;

@Service
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	IPersonaDao personaDao;
	
	@Override
	public List<Persona> findAll() {		
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	public Page<Persona> findAll(Pageable pageable) {		
		return personaDao.findAll(pageable);
	}

	@Override
	public void save(Persona persona) {
		personaDao.save(persona);		
	}

	@Override
	public Persona findById(Long id) {		
		return personaDao.findById(id).get();
		
	}

	@Override
	public void delete(Persona persona) {
		personaDao.delete(persona);
		
	}

	
}
