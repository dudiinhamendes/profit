package br.com.sistema.profit.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	    return "usuario/form";
	}
	
	@GetMapping("/listar")
	String listar(Model model) {
		model.addAttribute("listaUsuario", usuarioService.listar());
		return "usuario/listar";
	}
	
	@GetMapping("/editar")
	public String editar(@RequestParam Long id, Model model) {
		Usuario usuario = usuarioService.buscarPorId(id);
		if(usuario != null) {
			model.addAttribute("edit", true);
			model.addAttribute("usuario", usuario);
			return "usuario/cadastro";
		}else {
		return "usuario/listar";
		}
	}
}