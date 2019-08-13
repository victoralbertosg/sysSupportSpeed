package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.titannet.entity.TipoServicio;
public interface ITipoServicioService {
	public List<TipoServicio> findAll();
	public Page<TipoServicio> findAll(Pageable pageable);
	public void save(TipoServicio tiposervicio);
	public TipoServicio findById(Long id);
	public void delete(TipoServicio tiposervicio);
}
