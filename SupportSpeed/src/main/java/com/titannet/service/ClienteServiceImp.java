package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.titannet.dao.IClienteDao;
import com.titannet.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {

	@Autowired
	IClienteDao clientedao;
	
	@Override
	public List<Cliente> findAll() {		
		return (List<Cliente>) clientedao.findAll();
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
				return clientedao.findAll(pageable);
	}

	@Override
	public void save(Cliente cliente) {
		clientedao.save(cliente);
		
	}

	@Override
	public Cliente findById(Long id) {		
		return clientedao.findById(id).get();
	}

	@Override
	public void delete(Cliente cliente) {
		clientedao.delete(cliente);		
	}
	
}
