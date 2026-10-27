package br.com.sistema.profit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController implements CrudController<Aluno> {

	AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@Override
	@GetMapping("/cadastrar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String cadastrar(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "aluno/form";
	}

	@Override
	@GetMapping("/visualizar")
	public String visualizar(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/editar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String editar(@RequestParam Long id, Model model) {
		Aluno aluno = alunoService.buscarPorId(id);
		if (aluno != null) {
			model.addAttribute("edit", true);
			model.addAttribute("aluno", aluno);
			return "aluno/form";
		} else {
			return "redirect:/aluno/listar?error=notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN', 'PROFESSOR')")
	public String listar(Model model) {
		model.addAttribute("listaAluno",alunoService.listar());
		return "aluno/listar";
	}

	@Override
	@PostMapping("/salvar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String salvar(Aluno t) {
		// TODO Auto-generated method stub
		return null;
	} 
}
