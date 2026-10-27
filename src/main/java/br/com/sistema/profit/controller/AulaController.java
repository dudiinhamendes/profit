package br.com.sistema.profit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Aula;
import br.com.sistema.profit.service.AulaService;

@Controller
@RequestMapping("/aula")
public class AulaController implements CrudController<Aula> {

	AulaService aulaService;

	public AulaController(AulaService aulaService) {
		this.aulaService=aulaService;
	}

	@Override
	@GetMapping("/cadastrar")
	public String cadastrar(Model model) {
		model.addAttribute("aula", new Aula());
		return "aula/form";
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
		model.addAttribute("listaAula", aulaService.listar());
		return "aula/listar";
	}

	@Override
	public String salvar(Aula t) {
		// TODO Auto-generated method stub
		return null;
	}

}
