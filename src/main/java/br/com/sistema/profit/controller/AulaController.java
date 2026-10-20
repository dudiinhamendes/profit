package br.com.sistema.profit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Aula;
import br.com.sistema.profit.service.AulaService;

@Controller
@RequestMapping("/aula")
public class AulaController {
	
	AulaService aulaService;
	
	public AulaController(AulaService aulaService) {
		
		this.aulaService=aulaService;
	}
	
	@GetMapping("/listar")
	String listarAula(Model model) {
		List<Aula>listaAula=aulaService.listar();
		model.addAttribute("lisataAula",listaAula);
		
		return "aula/listar";
		
	}

}
