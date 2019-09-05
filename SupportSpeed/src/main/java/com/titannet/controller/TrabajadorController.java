package com.titannet.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.titannet.entity.Cargo;
import com.titannet.entity.Persona;
import com.titannet.entity.Trabajador;
import com.titannet.service.ICargoService;
import com.titannet.service.IPersonaService;
import com.titannet.service.ITrabajadorService;
import com.titannet.util.paginator.PageRender;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("trabajadorSession")
@RequestMapping("/unfv-supportspeed.herokuapp.com")
public class TrabajadorController {

	@Autowired(required = true)
	ITrabajadorService trabajadorService;
	@Autowired
	IPersonaService personaService;
	@Autowired
	ICargoService cargoService;

	@RequestMapping(value =  "/listar" , method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		PageRequest pageRequest = new PageRequest(page, 5);
		Page<Trabajador> trabajadores = trabajadorService.findAll(pageRequest);
		PageRender<Trabajador> pageRender = new PageRender<Trabajador>("/listar", trabajadores);
		model.addAttribute("titulo", "Listado de Trabajadores");
		model.addAttribute("trabajadores", trabajadores);
		model.addAttribute("page", pageRender);
		return "listar";
	}

	@GetMapping(value = "/form")
	public String crear(Model model) {
		Trabajador trabajador = new Trabajador();
		List<Persona> personas=personaService.findAll();
		List<Cargo> cargos= cargoService.findAll();
		model.addAttribute("trabajador", trabajador);
		model.addAttribute("personas", personas);
		model.addAttribute("cargos", cargos);
		model.addAttribute("titulo", "Crear Trabajador");
		return "/trabajador/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Trabajador trabajador, BindingResult result, RedirectAttributes flash,
			SessionStatus status,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Trabajador");
			return "form";
		}
		String mensajeFlash = (trabajador.getId() != null) ? "Trabajador editado con éxito!"
				: "Trabajador creado con éxito!";
		trabajadorService.save(trabajador);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";	
	}

	@RequestMapping(value = "form/{id}")
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
		List<Persona> personas=personaService.findAll();
		List<Cargo> cargos= cargoService.findAll();
		model.put("trabajador", trabajador);
		model.put("personas",personas);
		model.put("cargos", cargos);
		model.put("titulo", "editar trabajador");
		return "/trabajador/form";
	}
	@RequestMapping(value="delete/{id}")
	public String delete (@PathVariable(value="id") Long id, RedirectAttributes flash) {
		Trabajador trabajador = null;
		if (id > 0) {
			trabajador = trabajadorService.findById(id);
			trabajadorService.delete(trabajador);
			flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
			if (trabajador == null) {
				flash.addFlashAttribute("error", "el ID no existe");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "el ID del cliente no puede ser cero");
			return "redirect:../listar";
		}		
		
		return "redirect:../listar";
	}
	@GetMapping (value="ver/{id}") 
	public String ver(@PathVariable(value="id")Long id, Model model, RedirectAttributes flash) {
		if (id>0) {
			Trabajador trabajador = trabajadorService.findById(id);
			model.addAttribute("trabajador", trabajador);
			model.addAttribute("titulo","Ver");
		}else{
			flash.addFlashAttribute("error", "el ID del cliente no puede ser cero");
			return "redirect:../listar";
		}
		return "/trabajador/ver";
	}
}
