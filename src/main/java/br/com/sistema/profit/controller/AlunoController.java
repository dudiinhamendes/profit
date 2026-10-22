package br.com.sistema.profit.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Aluno;

import br.com.sistema.profit.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	AlunoService alunoService;
	
	public AlunoController(AlunoService alunoService) {
		this.alunoService=alunoService;
	}
	
	@GetMapping("/listar")
	String listarAluno(Model model) {
		model.addAttribute("listaAluno",alunoService.listar());
		return "aluno/listar";
	}
	
	@GetMapping("/cadastro")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	String cadastrarAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "aluno/form";
	}
  	

}
