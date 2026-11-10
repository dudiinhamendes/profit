package br.com.sistema.profit.controller;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.security.NaoEncontradoException;
import br.com.sistema.profit.service.AlunoService;
import br.com.sistema.profit.service.PlanoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController implements CrudController<Aluno> {

	AlunoService alunoService;
	PlanoService planoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@Override
	@GetMapping("/cadastrar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String cadastrar(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("listaPlano", planoService.listar());
		return "aluno/form";
	}

	@Override
	@GetMapping("/visualizar")
	public String visualizar(Long id, Model model) {
		try {
			Aluno aluno = alunoService.buscarPorId(id);
			model.addAttribute("edit", false);
			model.addAttribute("aluno", aluno);
			return "aluno/form";
		} catch(NaoEncontradoException  _) {
			return "redirect:/aluno/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/editar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String editar(@RequestParam Long id, Model model) {
		try {
			Aluno aluno = alunoService.buscarPorId(id);
			model.addAttribute("edit", true);
			model.addAttribute("aluno", aluno);
			model.addAttribute("listaPlano", planoService.listar());
			return "aluno/form";
		} catch(NaoEncontradoException _) {
			return "redirect:/aluno/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN', 'PROFESSOR')")
	public String listar(@RequestParam Optional<String> msg, Model model) {
		msg.ifPresent(m -> adicionaMensagem(model, m));
		model.addAttribute("listaAluno", alunoService.listar());
		return "aluno/listar";
	}

	@Override
	@PostMapping("/salvar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String salvar(Aluno aluno) {
		try {
			alunoService.salvar(aluno);
			return "redirect:/aluno/listar?msg=s-saved";
		} catch (NaoEncontradoException _) {
			return "redirect:/aluno/listar?msg=e-notFound";
		}
	} 
}
