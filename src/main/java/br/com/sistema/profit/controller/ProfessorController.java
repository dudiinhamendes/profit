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
public class ProfessorController {
	
	ProfessorService professorService;
	
	public ProfessorController(ProfessorService professorService) {
		this.professorService=professorService;
	}
	
	@GetMapping("/listar")
	String listarProfessor(Model model) {
		List<Professor>listaProfessor=professorService.listar();
		model.addAttribute("listaProfessor",listaProfessor);
		return "professor/listar";
	}

	@GetMapping("/cadastrar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	String cadastrarProfessor(Model model) {
		 model.addAttribute("professor",new Professor());
		 return "professor/form";
	}
	
}
