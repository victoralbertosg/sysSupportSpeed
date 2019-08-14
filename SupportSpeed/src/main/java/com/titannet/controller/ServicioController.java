package com.titannet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.titannet.entity.Servicio;
import com.titannet.entity.Trabajador;
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
	
	
	@GetMapping(value="/formServicio")
	public String Crear(Model model) {
		Servicio servicio=new Servicio();
		
		model.addAttribute("servicio", servicio);
		model.addAttribute("tipoServicios",tipoServicioService.findAll());	
		model.addAttribute("titulo","Guardar");
		
		return "/servicio/form";
	
		
	}
	@RequestMapping(value = "/formServicio", method = RequestMethod.POST)
	public String guardar(@Valid Servicio servicio, BindingResult result, RedirectAttributes flash,
			SessionStatus status,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Servicios");
			return "formServicio";
		}
		String mensajeFlash = (servicio.getId() != null) ? "Servicio editado con éxito!"
				: "Servicio creado con éxito!";
		
		
		servicioService.save(servicio);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
}
