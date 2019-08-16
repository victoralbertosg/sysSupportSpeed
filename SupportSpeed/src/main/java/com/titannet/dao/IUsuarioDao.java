package com.titannet.dao;


import org.springframework.data.repository.PagingAndSortingRepository;


import com.titannet.entity.Usuario;



public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	public Usuario findByUsername(String username);

}
