package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.titannet.entity.Persona;

public interface IPersonaService {
	public List<Persona> findAll();
	public Page<Persona> findAll(Pageable pageable);
	public void save(Persona persona);
	public Persona findById(Long id);
	public void delete(Persona persona);
}
