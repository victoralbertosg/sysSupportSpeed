package com.titannet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.titannet.entity.EstadoServicio;
import com.titannet.entity.Servicio;
import com.titannet.entity.ServicioDto;
import com.titannet.service.IEstadoServicioService;
import com.titannet.service.IServicioService;
import com.titannet.service.ITipoServicioService;
import com.titannet.service.ITrabajadorService;

@Controller
public class ServicioController {
	@Autowired
	IServicioService servicioService;
	@Autowired
	ITrabajadorService trabajadorService;
	@Autowired
	ITipoServicioService tipoServicioService;
	@Autowired
	IEstadoServicioService estadoServicioService;
	
	@GetMapping(value="/formServicio")
	public String Crear(Model model) {
		Servicio servicio=new Servicio();		
		servicio.setEstadoservicio(estadoServicioService.findById((long) 1));				
		model.addAttribute("servicio", servicio);
		model.addAttribute("tipoServicios",tipoServicioService.findAll());	
		model.addAttribute("titulo","Guardar");
	//	servicio.setEstadoservicio(1);
		return "/servicio/form";
	
		
	}
	@GetMapping(value="/listarEstado1")
	public String listarE1(Model model) {
		EstadoServicio es=estadoServicioService.findById((long) 1);
		List<Servicio> s=servicioService.servicioEstado1(es);		
		model.addAttribute("listaServicio",s);
		
		return "/servicio/listarE1";
	}
	@RequestMapping(value = "/formServicio", method = RequestMethod.POST)
	public String guardar(@Valid Servicio servicio, BindingResult result, RedirectAttributes flash,
			SessionStatus status,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Servicios");
			return "formServicio";
		}
		
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
		
				String nombre= auth.getName();
				
				/*
				@Autowired
				UsuarioService usuarioService;				
				private Usuario usuario;

				@PostConstruct
				public void init() {
				    Authentication auth = SecurityContextHolder
				            .getContext()
				            .getAuthentication();
				    UserDetails userDetail = (UserDetails) auth.getPrincipal();
				    usuario = this.usuarioService.getUsuarioByCorreo(userDetail.getUsername());
				    System.out.println(usuario);
				    System.out.println(usuario.getNombre());
				}
				*/
				
						
		String mensajeFlash = (servicio.getId() != null) ? "Servicio editado con éxito!"
				: "Servicio creado con éxito!";
		
		//List<EstadoServicio> es=estadoServicioService.findAll();
		servicio.setEstadoservicio(estadoServicioService.findById((long) 1));		
		servicioService.save(servicio);		
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	
	
}
