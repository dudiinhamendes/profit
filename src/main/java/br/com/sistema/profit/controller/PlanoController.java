package br.com.sistema.profit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.service.PlanoService;

@Controller
@RequestMapping("/plano")
public class PlanoController {

	
	PlanoService planoService;
	
	public PlanoController(PlanoService planoService) {
		this.planoService=planoService;
	}
	
	@GetMapping("/listar")
	String listar(Model model) {
		model.addAttribute("listarPlano",planoService.listar());
		return "plano/listar";
		
	}
	
	
	
}
