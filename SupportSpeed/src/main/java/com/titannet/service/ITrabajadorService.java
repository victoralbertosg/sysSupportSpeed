package com.titannet.service;

import java.util.List;

import com.titannet.entity.Trabajador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITrabajadorService {

	public List<Trabajador> findAll();
	public Page<Trabajador> findAll(Pageable pageable);
	public void save(Trabajador trabajador);
	public Trabajador findById(Long id);
	public void delete(Trabajador trabajador);
}
