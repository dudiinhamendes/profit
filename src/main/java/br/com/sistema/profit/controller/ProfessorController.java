package br.com.sistema.profit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.Professor;
import br.com.sistema.profit.security.NaoEncontradoException;
import br.com.sistema.profit.service.ProfessorService;

@Controller
@RequestMapping("/professor")
@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
public class ProfessorController implements CrudController<Professor> {
	
	ProfessorService professorService;
	
	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}
	
	@Override
	@GetMapping("/cadastrar")
	public String cadastrar(Model model) {
		 model.addAttribute("professor",new Professor());
		 return "professor/form";
	}

	@Override
	@GetMapping("/visualizar")
	public String visualizar(@RequestParam Long id, Model model) {
		try {
			Professor professor = professorService.buscarPorId(id);
			model.addAttribute("edit", false);
			model.addAttribute("professor", professor);
			return "professor/form";
		} catch(NaoEncontradoException _) {
			return "redirect:/professor/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/editar")
	public String editar(Long id, Model model) {
		try {
			Professor professor = professorService.buscarPorId(id);
			model.addAttribute("edit", true);
			model.addAttribute("professor", professor);
			return "professor/form";
		} catch(NaoEncontradoException _) {
			// adicionar erro ao log de professor não encontrado
			return "redirect:/professor/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	public String listar(@RequestParam Optional<String> msg, Model model) {
		msg.ifPresent(m -> adicionaMensagem(model, m));
		List<Professor>listaProfessor=professorService.listar();
		model.addAttribute("listaProfessor", listaProfessor);
		return "professor/listar";
	}

	@Override
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Professor professor) {
		try {
			professorService.salvar(professor);
			return "redirect:/professor/listar?msg=s-saved";
		} catch(NaoEncontradoException _) {
			return "redirect:/professor/listar?msg=e-notFound";
		}
	}
	
}
