package br.com.sistema.profit.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Usuario;
import br.com.sistema.profit.service.AcessoUsuarioService;
import br.com.sistema.profit.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	UsuarioService usuarioService;
	
	@GetMapping("/cadastro")
	public String cadastrar(Model model) {
		model.addAttribute("usuario", new Usuario());
	    return "usuario/cadastro";
	}
	
	
	@PostMapping("/salvar")
	String salvar(@ModelAttribute Usuario usuario) {
		usuarioService.salvar(usuario);
		return "redirect:/usuario/listar";
	}
	
} 