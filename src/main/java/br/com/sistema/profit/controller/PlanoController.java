package br.com.sistema.profit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Plano;
import br.com.sistema.profit.service.PlanoService;

@Controller
@RequestMapping("/plano")
public class PlanoController implements CrudController<Plano> {

	PlanoService planoService;
	
	public PlanoController(PlanoService planoService) {
		this.planoService = planoService;
	}

	@Override
	@GetMapping("/cadastrar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String cadastrar(Model model) {
		model.addAttribute("plano",new Plano());
		return "plano/form";
	}

	@Override
	@GetMapping("/visualizar")
	@PreAuthorize("hasAnyRole('ALUNO', 'ATENDENTE', 'ADMIN')")
	public String visualizar(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/editar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String editar(Long id, Model model) {
		Plano plano = planoService.buscarPorId(id);
		if (plano != null) {
			model.addAttribute("edit", true);
			model.addAttribute("plano", plano);
			return "plano/form";
		} else {
			// adicionar erro ao log de plano não encontrado
			return "redirect:/plano/listar?error=notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	@PreAuthorize("hasAnyRole('ALUNO', 'ATENDENTE', 'ADMIN')")
	public String listar(Model model) {
		model.addAttribute("listarPlano", planoService.listar());
		return "plano/listar";
	}

	@Override
	@PostMapping("/salvar")
	@PreAuthorize("hasAnyRole('ATENDENTE', 'ADMIN')")
	public String salvar(Plano t) {
		// TODO Auto-generated method stub
		return null;
	}
}
