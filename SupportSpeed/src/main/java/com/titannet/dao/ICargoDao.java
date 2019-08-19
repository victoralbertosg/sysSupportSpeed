package com.titannet.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.entity.Cargo;


public interface ICargoDao extends PagingAndSortingRepository<Cargo, Long>{

}
