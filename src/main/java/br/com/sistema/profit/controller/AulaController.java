package br.com.sistema.profit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.Aula;
import br.com.sistema.profit.service.AulaService;

@Controller
@RequestMapping("/aula")
public class AulaController implements CrudController<Aula> {

	AulaService aulaService;

	public AulaController(AulaService aulaService) {
		this.aulaService=aulaService;
	}

	@Override
	@GetMapping("/cadastrar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN', 'PROFESSOR')")
	public String cadastrar(Model model) {
		model.addAttribute("aula", new Aula());
		return "aula/form";
	}

	@Override
	@GetMapping("/visualizar")
	public String visualizar(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/editar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN', 'PROFESSOR')")
	public String editar(@RequestParam Long id, Model model) {
		Aula aula = aulaService.buscarPorId(id);
		if (aula != null) {
			model.addAttribute("edit", true);
			model.addAttribute("aula", aula);
			return "aula/form";
		} else {
			return "redirect:/aula/listar?error=notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("listaAula", aulaService.listar());
		return "aula/listar";
	}

	@Override
	@PostMapping("/salvar")
	public String salvar(Aula t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/deletar")
	public String deletar(@RequestParam Long id) {
	aulaService.deletar(id);
	return "redirect:/aula/listar?success=deleted";
	}
}
