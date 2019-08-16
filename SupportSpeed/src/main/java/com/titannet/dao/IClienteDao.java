package com.titannet.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.entity.Cliente;



public interface IClienteDao  extends PagingAndSortingRepository<Cliente, Long>  {

}
