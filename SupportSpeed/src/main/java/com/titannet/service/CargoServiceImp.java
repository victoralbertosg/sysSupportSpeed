package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.titannet.dao.ICargoDao;
import com.titannet.entity.Cargo;

@Service
public class CargoServiceImp implements ICargoService {
	@Autowired
	ICargoDao cargoDao;
	
	@Override
	public List<Cargo> findAll() {		
		return (List<Cargo>)cargoDao.findAll();
	}

	@Override
	public Page<Cargo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return cargoDao.findAll(pageable);
	}

	@Override
	public void save(Cargo cargo) {
		cargoDao.save(cargo);
		
	}

	@Override
	public Cargo findById(Long id) {		
		return cargoDao.findById(id).get();
	}

	@Override
	public void delete(Cargo cargo) {
		cargoDao.delete(cargo);		
	}

	

}
