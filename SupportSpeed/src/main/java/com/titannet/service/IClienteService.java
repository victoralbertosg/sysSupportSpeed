package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.titannet.entity.Cliente;
import com.titannet.entity.Persona;



public interface IClienteService {
	public List<Cliente> findAll();
	public Page<Cliente> findAll(Pageable pageable);
	public void save(Cliente cliente);
	public Cliente findById(Long id);
	public void delete(Cliente cliente);
	public Cliente findByPersona(Persona persona);
}
