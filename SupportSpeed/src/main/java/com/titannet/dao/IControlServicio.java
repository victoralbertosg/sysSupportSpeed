package com.titannet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.entity.ControlServicio;
import com.titannet.entity.Servicio;

public interface IControlServicio extends PagingAndSortingRepository<ControlServicio , Long>{
	
	@Query("select cs from ControlServicio cs where cs.servicio=?1")
	public List<ControlServicio> listaCServicio (Servicio servicio);
}
