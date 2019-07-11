package com.titannet.controller;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.titannet.entity.Trabajador;
import com.titannet.service.ITrabajadorService;
import com.titannet.util.paginator.PageRender;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("trabajador")
public class TrabajadorController {

@Autowired
ITrabajadorService trabajadorService;

@RequestMapping(value = {"/listar","/"}, method = RequestMethod.GET)
public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

	PageRequest pageRequest = new PageRequest(page, 5);

	Page<Trabajador> trabajadores = trabajadorService.findAll(pageRequest);
	
	

	PageRender<Trabajador> pageRender = new PageRender<Trabajador>("/listar", trabajadores);

	model.addAttribute("titulo", "Listado de Trabajadores");
	model.addAttribute("trabajadores", trabajadores);
	model.addAttribute("page", pageRender);
	return "listar";
}
}
