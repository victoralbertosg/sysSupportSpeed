package com.titannet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.titannet.dao.IUsuarioDao;
import com.titannet.entity.Usuario;
import com.titannet.service.IUsuarioService;


@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	IUsuarioDao usuarioDao;

	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		
		return (List<Usuario>)usuarioDao.findAll();
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		
		return usuarioDao.findAll(pageable);
	}

	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	public Usuario findById(Long id) {		
		return usuarioDao.findById(id).get();
		
	}

	@Override
	@Transactional
	public void delete(Usuario usuario) {
		usuarioDao.delete(usuario);		
	}

	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsername(username);
	}



}
