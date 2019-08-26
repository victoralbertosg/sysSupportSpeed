package com.titannet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.titannet.entity.EstadoServicio;
import com.titannet.entity.Persona;
import com.titannet.entity.Usuario;

@Service
public class ObtVariosService {	
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	IEstadoServicioService estadoServicioService;
	private Long estadoServicio;	
	private String logCambio;
	public Usuario obtUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String u = userDetail.getUsername();
		Usuario usu = usuarioService.findByUsername(u);		
		return usu;
	}
	public Persona obtPersonaUsuario(Usuario u) {	
		return usuarioService.UsuarioPersona(u.getId());
	}
	
	public EstadoServicio obtEstadoServicio(Long Id) {		
		return estadoServicioService.findById(Id);
	}
	
	


	public Long getEstadoServicio() {
		return estadoServicio;
	}
	public void setEstadoServicio(Long estadoServicio) {
		this.estadoServicio = estadoServicio;
	}
	public String getLogCambio() {
		return logCambio;
	}
	public void setLogCambio(String logCambio) {
		this.logCambio = logCambio;
	}

	
}
