package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.titannet.entity.Cargo;


public interface ICargoService {
	public List<Cargo> findAll();
	public Page<Cargo> findAll(Pageable pageable);
	public void save(Cargo cargo);
	public Cargo findById(Long id);
	public void delete(Cargo cargo);
}
