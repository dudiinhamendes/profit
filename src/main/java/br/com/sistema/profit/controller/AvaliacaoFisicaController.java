package br.com.sistema.profit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.model.AvaliacaoFisica;
import br.com.sistema.profit.security.AcessoUsuario;
import br.com.sistema.profit.security.NaoEncontradoException;
import br.com.sistema.profit.service.AlunoService;
import br.com.sistema.profit.service.AvaliacaoFisicaService;

@Controller
@RequestMapping("/avaliacao-fisica")
public class AvaliacaoFisicaController {

	AvaliacaoFisicaService avaliacaoFisicaService;
	AlunoService alunoService;

	public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService, AlunoService alunoService) {
		this.avaliacaoFisicaService = avaliacaoFisicaService;
		this.alunoService = alunoService;
	}

	@GetMapping("/cadastrar/{id}")
	@PreAuthorize("hasAnyRole('PROFESSOR')")
	public String cadastrar(@PathVariable String id, Model model) throws NaoEncontradoException {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		avaliacaoFisica.setAluno(alunoService.buscarPorId(Long.valueOf(id)));
		model.addAttribute("avaliacaoFisica", avaliacaoFisica);
	    return "avaliacaoFisica/form";
	}

	@GetMapping("/visualizar")
	public String visualizar(Long id, Model model) {
		try {
			AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.buscarPorId(id);
			model.addAttribute("edit", false);
			model.addAttribute("avaliacaoFisica" , avaliacaoFisica);
			return "avaliacaoFisica/form";
		} catch (NaoEncontradoException _) {
			return "redirect:/aluno/listar?msg=e-notFound";
		}
	}

	@GetMapping("/editar") 
	@PreAuthorize("hasAnyRole('PROFESSOR')")
	public String editar(@RequestParam Long id, Model model) {
		try {
			AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.buscarPorId(id);
			model.addAttribute("edit", true);
			model.addAttribute("avaliacaoFisica" , avaliacaoFisica);
			return "avaliacaoFisica/form";
		} catch(NaoEncontradoException _) {
			return "redirect:/aluno/listar?msg=e-notFound";
		}
	}

	@PostMapping("/salvar")
	@PreAuthorize("hasAnyRole('PROFESSOR')")
	public String salvar(AvaliacaoFisica avaliacaoFisica, @AuthenticationPrincipal AcessoUsuario usuarioAtual) {
		IO.println(usuarioAtual.getId());
		try {
			avaliacaoFisicaService.salvar(avaliacaoFisica, usuarioAtual.getId());
			return "redirect:/aluno/listar?msg=s-saved";
		} catch(NaoEncontradoException _) {
			return "redirect:/aluno/visualizar?id=" + avaliacaoFisica.getAluno().getId();
		}
	}
	
	@GetMapping("/deletar")
	public String deletar(@RequestParam Long id) {
		avaliacaoFisicaService.deletar(id);
		return "redirect:/avaliacao-fisica/listar?msg=s-deleted";
	}
}
