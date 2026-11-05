package br.com.sistema.profit.controller;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.Aula;
import br.com.sistema.profit.security.NaoEncontradoException;
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
	@PreAuthorize("hasAnyRole('ALUNO', 'ATENDENTE', 'ADMIN', 'PROFESSOR')")
	public String visualizar(@RequestParam Long id, Model model) {
		try {
			Aula aula = aulaService.buscarPorId(id);
			model.addAttribute("edit", false);
			model.addAttribute("aula", aula);
			return "aula/form";
		} catch (NaoEncontradoException e) {
			return "redirect:/aula/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/editar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN', 'PROFESSOR')")
	public String editar(@RequestParam Long id, Model model) {
		try {
			Aula aula = aulaService.buscarPorId(id);
			model.addAttribute("edit", true);
			model.addAttribute("aula", aula);
			return "aula/form";
		} catch (NaoEncontradoException e) {
			return "redirect:/aula/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	public String listar(@RequestParam Optional<String> msg, Model model) {
		msg.ifPresent(m -> adicionaMensagem(model, m));
		model.addAttribute("listaAula", aulaService.listar());
		return "aula/listar";
	}

	@Override
	@PostMapping("/salvar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN', 'PROFESSOR')")
	public String salvar(@ModelAttribute Aula aula) {
		aulaService.salvar(aula);
		return "redirect:/aula/listar?msg=s-saved";
	}

	@GetMapping("/deletar")
	public String deletar(@RequestParam Long id) {
		aulaService.deletar(id);
		return "redirect:/aula/listar?msg=s-deleted";
	}
}
