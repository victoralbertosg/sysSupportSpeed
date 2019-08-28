package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import com.titannet.entity.Role;

public interface IRolService {
	public List<Role> findAll();
	public Page<Role> findAll(Pageable pageable);
	public void save(Role rol);
	public Role findById(Long id);
	public void delete(Role rol);
	public Role findByPersona(Role rol);
}
