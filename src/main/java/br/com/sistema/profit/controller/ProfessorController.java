package br.com.sistema.profit.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Professor;
import br.com.sistema.profit.service.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController implements CrudController<Professor> {
	
	ProfessorService professorService;
	
	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}

	@Override
	@GetMapping("/cadastrar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String cadastrar(Model model) {
		 model.addAttribute("professor",new Professor());
		 return "professor/form";
	}

	@Override
	@GetMapping("/visualizar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String visualizar(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/editar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String editar(Long id, Model model) {
		Professor professor = professorService.buscarPorId(id);
		if (professor != null) {
			model.addAttribute("edit", true);
			model.addAttribute("professor", professor);
			return "professor/form";
		} else {
			// adicionar erro ao log de professor não encontrado
			return "redirect:/professor/listar?error=notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String listar(Model model) {
		List<Professor>listaProfessor=professorService.listar();
		model.addAttribute("listaProfessor",listaProfessor);
		return "professor/listar";
	}

	@Override
	@PostMapping("/salvar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String salvar(Professor t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
