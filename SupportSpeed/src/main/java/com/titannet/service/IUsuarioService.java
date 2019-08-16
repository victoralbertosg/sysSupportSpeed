package com.titannet.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.titannet.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public Page<Usuario> findAll(Pageable pageable);
	public void save(Usuario usuario);
	public Usuario findById(Long id);
	public void delete(Usuario usuario);
	public Usuario findByUsername(String username);
}
