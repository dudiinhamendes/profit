package br.com.sistema.profit.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Aluno;

@RequestMapping("/aluno")
public class AlunoController {

	@GetMapping("/cadastro")
	String cadastrarAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "aluno/form";
	}

}
