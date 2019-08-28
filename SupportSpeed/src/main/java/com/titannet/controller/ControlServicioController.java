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
public class ControlServicioController {
	
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
	@Autowired
	ObtVariosService obtVarios;
	
	Servicio servicio = null;
	
	@GetMapping(value = "formCServicio/{id}/{parEstadoServicio}")
	public String Crear(@PathVariable(value = "id") Long id,@PathVariable(value = "parEstadoServicio") Long parEstadoServicio,Model model,RedirectAttributes flash) {
		ControlServicio cservicio = new ControlServicio();
		obtVarios.setEstadoServicio(parEstadoServicio);
		
		if (id > 0) {
			servicio = servicioService.findById(id);			
			if (servicio == null) {
				flash.addFlashAttribute("error", "el ID no existe");
				return "redirect:/listarE1";
			}
		} else {
			flash.addFlashAttribute("error", "el ID del servicio no puede ser cero");
			return "redirect:/listarE1";
		}		
		cservicio.setServicio(servicio);			
		model.addAttribute("parES",servicio.getEstadoservicio().getEstado());
		model.addAttribute("miservicio", servicio);
		model.addAttribute("cservicio", cservicio);		
		model.addAttribute("trabajadores", trabajadorService.findAll());
		model.addAttribute("titulo", "Mantenimiento Control de Servicio");
		// servicio.setEstadoservicio(1);
		return "/controlServicio/form";
	}
	@RequestMapping(value = "/formCServicio", method = RequestMethod.POST)
	public String guardar(@Valid ControlServicio cservicio, BindingResult result, RedirectAttributes flash,
			SessionStatus status, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Servicios");
			//String d =cservicio.getDescripcion();
			return "formCServicio";
		}
		//completar los datos de control de usuario
		cservicio.setUsuario(obtVarios.obtUsuario());
		
		EstadoServicio eServicioActual=obtVarios.obtEstadoServicio(obtVarios.getEstadoServicio()+1);//estado de servicio
		cservicio.setLogCambio(eServicioActual.getDescripcion() );
		cservicio.setServicio(servicio);
		cservicio.setEstadoservicio(eServicioActual); //se asigna el nuevo estado  (estado inicial+1)
		//actualizar estado y trabajador actual del servicio
		servicio.setEstadoservicio(eServicioActual); //la propiedad estadoservicio se recibe por parametro en crear
		if (obtVarios.getEstadoServicio()==1) {  //se valida si la etapa es crear u otros
			servicio.setTrabajador(cservicio.getTrabajador());			
			}else {
				cservicio.setTrabajador(servicio.getTrabajador());			
			}		
		controlService.save(cservicio);//grabar el registro
		servicioService.save(servicio);
					
		String mensajeFlash = (cservicio.getId() != null) ? "Servicio editado con éxito!" : "Servicio creado con éxito!";								
	//	esServicio=estadoServicioService.findById((long) obtusuario.getTc()); //se ubica el estado del servicio por el tipo de cambio			
									
		//servicio.setEstadoservicio(esServicio);
		//servicioService.save(servicio);
		//actualizar control servicio
		//ControlServicio cs = new ControlServicio();
		//cs.setUsuario(obtusuario.obtUsuario());
		//cs.setEstadoservicio(esServicio);
		//cs.setServicio(servicio);
		//cs.setDescripcion(obtusuario.getDcambio());
		//cs.setTipoCambio((long)obtusuario.getTc());
		//controlService.save(cs);		
		//status.setComplete();
		//flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/listarEstado/"+(obtVarios.getEstadoServicio());
	}
	
	@RequestMapping(value = "formControlServicio/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Servicio servicio = null;

		if (id > 0) {
			servicio = servicioService.findById(id);			
			if (servicio == null) {
				flash.addFlashAttribute("error", "el ID no existe");
				return "redirect:/listarE1";
			}
		} else {
			flash.addFlashAttribute("error", "el ID del servicio no puede ser cero");
			return "redirect:/listarEstado/"+(obtVarios.getEstadoServicio());
		}
		//List<Persona> personas=personaService.findAll();
		//List<Cargo> cargos= cargoService.findAll();
		//model.put("trabajador", trabajador);
		//model.put("personas",personas);
	//	model.put("cargos", cargos);
		//model.put("titulo", "editar trabajador");
		return "/controlServicio/form";
	}
	
	@GetMapping (value="verCS/{id}") 
	public String ver(@PathVariable(value="id")Long id, Model model, RedirectAttributes flash) {
		if (id>0) {
			Servicio s=servicioService.findById(id);			
			List<ControlServicio> cs= controlService.listaCServicio(s);		
			model.addAttribute("listacontrolservicio", cs);
			model.addAttribute("servicio",s);
			model.addAttribute("titulo","Ver");
		}else{
			flash.addFlashAttribute("error", "el ID del cliente no puede ser cero");
			return "redirect:/listarEstado/"+(obtVarios.getEstadoServicio());
		}
		return "/controlServicio/ver";
	}
}
