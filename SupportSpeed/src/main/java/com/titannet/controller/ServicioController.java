package com.titannet.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.titannet.entity.Cargo;
import com.titannet.entity.ControlServicio;
import com.titannet.entity.EstadoServicio;
import com.titannet.entity.Persona;
import com.titannet.entity.Servicio;
import com.titannet.entity.Trabajador;
import com.titannet.entity.Usuario;
import com.titannet.service.IClienteService;
import com.titannet.service.IControlServicioService;
import com.titannet.service.IEstadoServicioService;
import com.titannet.service.IServicioService;
import com.titannet.service.ITipoServicioService;
import com.titannet.service.ITrabajadorService;
import com.titannet.service.IUsuarioService;

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

	@Autowired
	IClienteService clienteService;

	@Autowired
	IUsuarioService usuarioService;

	@Autowired
	IControlServicioService controlService;
	public String n;
	public EstadoServicio esServicio;

	@GetMapping(value = "/formServicio")
	public String Crear(Model model) {
		Servicio servicio = new Servicio();
		servicio.setEstadoservicio(estadoServicioService.findById((long) 1));
		//n="nuevo";
		//esServicio=estadoServicioService.findById((long) 1);
		model.addAttribute("servicio", servicio);
		model.addAttribute("tipoServicios", tipoServicioService.findAll());
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("titulo", "Guardar");
		// servicio.setEstadoservicio(1);
		return "/servicio/form";
	}

	@GetMapping(value = "/listarEstado1")
	public String listarE1(Model model) {
		EstadoServicio es = estadoServicioService.findById((long) 1);
		List<Servicio> s = servicioService.servicioEstado1(es);
		model.addAttribute("listaServicio", s);
		return "/servicio/listarE1";
	}

	@RequestMapping(value = "/formServicio", method = RequestMethod.POST)
	public String guardar(@Valid Servicio servicio, BindingResult result, RedirectAttributes flash,
			SessionStatus status, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Servicios");
			return "formServicio";
		}
		String mensajeFlash = (servicio.getId() != null) ? "Servicio editado con éxito!" : "Servicio creado con éxito!";	
		// obtener el usuario de autenticado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String u = userDetail.getUsername();
		Usuario usu = usuarioService.findByUsername(u);
		
		//EstadoServicio esNuevo=estadoServicioService.findById((long) 1);
		//if (n=="nuevo"){
			//servicio.setEstadoservicio(esServicio);	
		//}		
					
		servicioService.save(servicio);
		//actualizar control servicio
		ControlServicio cs = new ControlServicio();
		cs.setUsuario(usu);
		cs.setEstadoservicio(esServicio);
		cs.setServicio(servicio);
		controlService.save(cs);
		
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	@RequestMapping(value = "formControlServicio/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Trabajador trabajador = null;

		if (id > 0) {
			trabajador = trabajadorService.findById(id);			
			if (trabajador == null) {
				flash.addFlashAttribute("error", "el ID no existe");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "el ID del cliente no puede ser cero");
			return "redirect:/listar";
		}
		//List<Persona> personas=personaService.findAll();
		//List<Cargo> cargos= cargoService.findAll();
		//model.put("trabajador", trabajador);
		//model.put("personas",personas);
	//	model.put("cargos", cargos);
		//model.put("titulo", "editar trabajador");
		return "/trabajador/form";
	}

}
