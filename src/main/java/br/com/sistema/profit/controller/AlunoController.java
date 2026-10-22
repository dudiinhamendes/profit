package br.com.sistema.profit.controller;

import java.util.List;

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
		List<Aluno> listaAluno = alunoService.listar();
		model.addAttribute("listaAluno",listaAluno);
		
		return "paciente/listar";
	}
  
	@GetMapping("/cadastrar")
	String cadastrarAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "aluno/form";
  }

}
