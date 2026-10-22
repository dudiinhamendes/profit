package br.com.sistema.profit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("listaAvaliacao", avaliacaoFisicaService.listar());
		
		return "avaliacao-fisica/listar";
	}
	
	@GetMapping("/editar") 
	@PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
	public String editarAvaliacaoFisica(@RequestParam Long id, Model model) {
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.buscarPorId(id);
		if (avaliacaoFisica != null) {
			model.addAttribute("edit", true);
			model.addAttribute("avaliacaoFisica", avaliacaoFisica);
			return "avaliacaoFisica/form";
		} else {
			return "redirect:/avaliacaoFisica/listar?error=notFound";
		}
	}
	
}
