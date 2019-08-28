package com.titannet.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.entity.Cliente;
import com.titannet.entity.Persona;




public interface IClienteDao  extends PagingAndSortingRepository<Cliente, Long>  {
	
	//@Query ("select c from Cliente c where c.persona=?1 ")
	public Cliente findByPersona(Persona persona);
}
