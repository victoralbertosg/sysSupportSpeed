package com.titannet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.titannet.entity.Usuario;

@Service
public class ObtUsuarioService {	
	@Autowired
	IUsuarioService usuarioService;
	private Integer tc;	
	private String dcambio;
	public Usuario obtUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String u = userDetail.getUsername();
		Usuario usu = usuarioService.findByUsername(u);		
		return usu;
	}
	public Integer getTc() {
		return tc;
	}
	public void setTc(Integer tc) {
		this.tc = tc;
	}
	public String getDcambio() {
		return dcambio;
	}
	public void setDcambio(String dcambio) {
		this.dcambio = dcambio;
	}
	
	
}
