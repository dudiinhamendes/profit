package br.com.sistema.profit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("listarPlano", planoService.listar());
		return "plano/listar";
		
	}

	@Override
	public String cadastrar(Model model) {
		// TODO Auto-generated method stub
		return null;
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
	public String salvar(Plano t) {
		// TODO Auto-generated method stub
		return null;
	}
}
