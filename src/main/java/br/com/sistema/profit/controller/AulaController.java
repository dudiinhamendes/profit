package br.com.sistema.profit.controller;

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
		model.addAttribute("listaAula",aulaService.listar());
		return "aula/listar";
	}
	
	@GetMapping("/cadastrar")
	String cadastrarAula(Model model) {
		model.addAttribute("aula",new Aula());
		return "aula/form";
	}

}
