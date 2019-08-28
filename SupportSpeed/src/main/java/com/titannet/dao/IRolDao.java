package com.titannet.dao;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.titannet.entity.Role;
//import com.titannet.entity.Usuario;

public interface IRolDao extends PagingAndSortingRepository<Role, Long>{

	//public Role findByUsuario(Usuario usuario);
}
