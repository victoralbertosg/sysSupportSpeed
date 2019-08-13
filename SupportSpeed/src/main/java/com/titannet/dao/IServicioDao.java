package com.titannet.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.entity.Servicio;

public interface IServicioDao extends PagingAndSortingRepository<Servicio , Long> {

}
