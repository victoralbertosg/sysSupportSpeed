package com.titannet.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.titannet.entity.Cliente;
import com.titannet.entity.ControlServicio;
import com.titannet.entity.EstadoServicio;
import com.titannet.entity.Persona;
import com.titannet.entity.Servicio;
import com.titannet.entity.Usuario;
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
	
	//@PreAuthorize(value = "hasRole('ROLE_ADMIN';'ROLE_CLIENTE')")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENTE')")
	@GetMapping(value = "/formServicio/{parEstadoServicio}")
	public String Crear(Model model,@PathVariable(value = "parEstadoServicio") Long parEstadoServicio) {
		Servicio servicio = new Servicio();			
		obtVarios.setEstadoServicio(parEstadoServicio); //se agrega el valor de 1 al tipo de cambio q corresponde a crear
		obtVarios.setLogCambio(obtVarios.obtEstadoServicio(parEstadoServicio).getDescripcion()); //se agrega la descripcion de cambio 
		
		//identificar si el que va a crear es un cliente
		Usuario u=obtVarios.obtUsuario();
		Persona p=obtVarios.obtPersonaUsuario(u);
		Cliente c=clienteService.findByPersona(p);
		String t=null;
		if (c!=null) {
			t="true";
		}
		
		model.addAttribute("micliente", c);
		model.addAttribute("isCliente", t);
		model.addAttribute("servicio", servicio);
		model.addAttribute("tipoServicios", tipoServicioService.findAll());
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("titulo", "Formulario Servicio");	
		return "/servicio/form";
		
	}

	@GetMapping(value = "/listarEstado/{parEstadoServicio}")				
	public String listarS(Model model,@PathVariable(value = "parEstadoServicio") Long parEstadoServicio ) {
		
		if (parEstadoServicio==null) {
			parEstadoServicio=(long) 1;
			};	
		EstadoServicio estadoservicio = estadoServicioService.findById(parEstadoServicio);
		Usuario u=obtVarios.obtUsuario();
		Persona p=obtVarios.obtPersonaUsuario(u);
		List<Servicio> servicio=null;
			
		String submint=null;
		if (parEstadoServicio==1) {
			submint="Asignar personal";
			servicio = servicioService.servicioEstado1(estadoservicio);
		}else if (parEstadoServicio==2){
			servicio=servicioService.servicioTrabajadorEstado(p, estadoservicio);			
			submint="Registrar trabajos";
		}else if (parEstadoServicio==3){
			servicio = servicioService.servicioClienteEstado(p, estadoservicio);
			submint="Registrar conformidad";
		}else if (parEstadoServicio==4){
			servicio = servicioService.servicioEstado1(estadoservicio);
			submint="Conformidad y cierre";
		}else {
			
		}
		model.addAttribute("listaServicio", servicio);
		model.addAttribute("submint", submint);
		model.addAttribute("parEstadoServicio", parEstadoServicio);
				
		return "/servicio/listarS";
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
		cs.setDescripcion(servicio.getDescripcion());
		cs.setLogCambio(obtVarios.getLogCambio());		
		controlService.save(cs);		
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/listarEstado/"+obtVarios.getEstadoServicio();		
	}
	
	@GetMapping(value = {"/listarServicioTrabajador"})	
	public String listarServicioTrabajador(Model model ) {
		
		Usuario u=obtVarios.obtUsuario();
		Persona p=obtVarios.obtPersonaUsuario(u);
		List<Servicio> servicioTrabajador=servicioService.servicioTrabajador(p);
		model.addAttribute("listaServicio", servicioTrabajador);								
		return "/servicio/listarS";
}
}