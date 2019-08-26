package com.titannet.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.titannet.entity.Persona;
import com.titannet.entity.Usuario;



public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
	
	@Query("select p from Usuario u join u.persona p where u.id=?1 ")
	public Persona UsuarioPersona(Long id);
}
