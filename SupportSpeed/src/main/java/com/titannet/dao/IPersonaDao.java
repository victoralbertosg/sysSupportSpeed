package com.titannet.dao;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.titannet.entity.Persona;

public interface IPersonaDao extends PagingAndSortingRepository<Persona, Long>  {

}
