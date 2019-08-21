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


import com.titannet.entity.ControlServicio;
import com.titannet.entity.EstadoServicio;

import com.titannet.entity.Servicio;

import com.titannet.service.IClienteService;
import com.titannet.service.IControlServicioService;
import com.titannet.service.IEstadoServicioService;
import com.titannet.service.IServicioService;
import com.titannet.service.ITipoServicioService;
import com.titannet.service.ITrabajadorService;
import com.titannet.service.IUsuarioService;
import com.titannet.service.ObtVariosService;


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
	ObtVariosService obtVarios;

	@Autowired
	IControlServicioService controlService;
//public Integer tc; //tipo de cambio 1:crear 2:asignar personal 3: conformidad cliene 4;conformidad administrador
	public EstadoServicio esServicio;

	@GetMapping(value = "/formServicio/{parEstadoServicio}")
	public String Crear(Model model,@PathVariable(value = "parEstadoServicio") Long parEstadoServicio) {
		Servicio servicio = new Servicio();			
		obtVarios.setEstadoServicio(parEstadoServicio); //se agrega el valor de 1 al tipo de cambio q corresponde a crear
		obtVarios.setLogCambio(obtVarios.obtEstadoServicio(parEstadoServicio).getDescripcion()); //se agrega la descripcion de cambio 
		model.addAttribute("servicio", servicio);
		model.addAttribute("tipoServicios", tipoServicioService.findAll());
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("titulo", "Guardar");	
		return "/servicio/form";
	}

	@GetMapping(value = "/listarEstado/{parEstadoServicio}")
	public String listarE1(Model model,@PathVariable(value = "parEstadoServicio") Long parEstadoServicio ) {
		EstadoServicio estadoservicio = estadoServicioService.findById(parEstadoServicio);
		List<Servicio> servicio = servicioService.servicioEstado1(estadoservicio);
		
		String submint=null;
		if (parEstadoServicio==1) {
			submint="Asignar personal";
		}else if (parEstadoServicio==2){
			submint="Registrar trabajos";
		}else if (parEstadoServicio==3){
			submint="Registrar conformidad";
		}else if (parEstadoServicio==4){
			submint="Conformidad y cierre";
		}else {
			
		}
		model.addAttribute("listaServicio", servicio);
		model.addAttribute("submint", submint);
				
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
		esServicio=obtVarios.obtEstadoServicio(obtVarios.getEstadoServicio()); //se ubica el estado del servicio por el tipo de cambio			
									
		servicio.setEstadoservicio(esServicio);
		servicioService.save(servicio);
		//actualizar control servicio
		ControlServicio cs = new ControlServicio();
		cs.setUsuario(obtVarios.obtUsuario());
		cs.setEstadoservicio(esServicio);
		cs.setServicio(servicio);
		cs.setLogCambio(obtVarios.getLogCambio());		
		controlService.save(cs);		
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/listarEstado/"+obtVarios.getEstadoServicio();
		
	}
	
}
