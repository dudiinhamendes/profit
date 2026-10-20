package br.com.sistema.profit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.AvaliacaoFisica;
import br.com.sistema.profit.service.AvaliacaoFisicaService;

@Controller
@RequestMapping("/avaliacao-fisica")
public class AvaliacaoFisicaController {
 
	AvaliacaoFisicaService avaliacaoFisicaService;
	
	public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService) {
		
		this.avaliacaoFisicaService =avaliacaoFisicaService;
	}
	
	
	@GetMapping("/listar")
	String listarAvaliacaoFisica(Model model) {
		List<AvaliacaoFisica> listaAvaliacao=avaliacaoFisicaService.listar();
		model.addAttribute("listaAvaliacao",listaAvaliacao);
		
		return "avaliacao-fisica/listar";
		
	}
	
	
}
