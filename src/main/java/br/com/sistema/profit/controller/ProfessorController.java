package br.com.sistema.profit.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String visualizar(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Professor>listaProfessor=professorService.listar();
		model.addAttribute("listaProfessor",listaProfessor);
		return "professor/listar";
	}

	@Override
	public String salvar(Professor t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
