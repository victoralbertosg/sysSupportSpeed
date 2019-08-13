package com.titannet.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.dao.ITipoServicio;
import com.titannet.entity.TipoServicio;

@Service
public class TipoServicioServiceImp implements ITipoServicioService {

	@Autowired
	ITipoServicio tiposervicioDao;
	
	
	@Override	
	@Transactional(readOnly=true)
	public List<TipoServicio> findAll() {		
		return (List<TipoServicio>) tiposervicioDao.findAll();
	}

	@Override
	public Page<TipoServicio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return tiposervicioDao.findAll(pageable);
	}

	@Override
	public void save(TipoServicio tiposervicio) {
		tiposervicioDao.save(tiposervicio);
	}

	@Override
	public TipoServicio findById(Long id) {
		
		return tiposervicioDao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(TipoServicio tiposervicio) {
		tiposervicioDao.delete(tiposervicio);		
	}
}
