package br.com.sistema.profit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.AvaliacaoFisica;
import br.com.sistema.profit.service.AvaliacaoFisicaService;

@Controller
@RequestMapping("/avaliacao-fisica")
public class AvaliacaoFisicaController implements CrudController<AvaliacaoFisica> {

	AvaliacaoFisicaService avaliacaoFisicaService;

	public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService) {
		this.avaliacaoFisicaService = avaliacaoFisicaService;
	}

	@Override
	@GetMapping("/cadastrar")
	@PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
	public String cadastrar(Model model) {
		model.addAttribute("avaliacaoFisica", new AvaliacaoFisica());
	    return "avaliacao-fisica/form";
	}

	@Override
	@GetMapping("/visualizar")
	public String visualizar(Long id, Model model) {
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.buscarPorId(id);
		if (avaliacaoFisica != null) {
			model.addAttribute("edit", false);
			model.addAttribute("avaliacaoFisica" , avaliacaoFisica);
			return "avaliacao-fisica/form";
		} else {
			return "redirect:/aluno/listar?error=notFound";
		}
	}

	@Override
	@GetMapping("/editar") 
	@PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
	public String editar(@RequestParam Long id, Model model) {
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.buscarPorId(id);
		if (avaliacaoFisica != null) {
			model.addAttribute("edit", true);
			model.addAttribute("avaliacaoFisica" , avaliacaoFisica);
			return "avaliacao-fisica/form";
		} else {
			return "redirect:/aluno/listar?error=notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("listaAvaliacao", avaliacaoFisicaService.listar());
		return "avaliacao-fisica/listar";
	}

	@Override
	@PostMapping("/salvar")
	@PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
	public String salvar(AvaliacaoFisica t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/deletar")
	public String deletar(@RequestParam Long id) {
		avaliacaoFisicaService.deletar(id);
		return "redirect:/avaliacao-fisica/listar?success=deleted";
	}
}
