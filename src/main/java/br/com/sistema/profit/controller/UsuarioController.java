package br.com.sistema.profit.controller; 

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sistema.profit.model.Usuario;
import br.com.sistema.profit.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/cadastro")
	public String cadastrar(Model model) {
		model.addAttribute("usuario", new Usuario());
	    return "usuario/cadastro";
	}
	
	@GetMapping("/listar")
	String listar(Model model) {
		List<Usuario> listaUsuario = usuarioService.listar();
		model.addAttribute("listaU", listaUsuario);
		return "usuario/listar";
	}
	
	
} 