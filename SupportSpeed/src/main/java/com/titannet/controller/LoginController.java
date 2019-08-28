package com.titannet.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.titannet.service.ObtVariosService;



@Controller
public class LoginController {

	@Autowired
	ObtVariosService obtvarios;
	
	
	@GetMapping({"/login", "/"})
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
			String rol =obtvarios.obtRol(obtvarios.obtUsuario());
			if (rol.equals("ROLE_ADMIN")) {
				return "redirect:/listarEstado/1";	
			}else  if (rol.equals("ROLE_CLIENTE")) {
				return "redirect:/listarEstado/3";
			}else {
				return "redirect:/listarEstado/2";
			}			
		}
		
		if(error != null) {
			model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}
		//String rol= usuarioservice
		if(logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}
		
		return "login";
	}
}
