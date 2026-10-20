package br.com.sistema.profit.controller; 

import java.time.LocalDateTime;
import java.util.logging.Logger;

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
	
	@GetMapping("/visualizar")
	public String visualizar(@RequestParam Long id, Model model) {
		Usuario usuario = usuarioService.buscarPorId(id);
		if (usuario != null) {
			model.addAttribute("edit", false);
			model.addAttribute("usuario", usuario);
		    return "usuario/form";
		} else {
			// adicionar erro ao log de usuário não encontrado
			return "redirect:/usuario/listar?error=notFound";
		}
	}
	
	@GetMapping("/listar")
	String listar(Model model) {
		model.addAttribute("listaU", usuarioService.listar());
		return "usuario/listar";
	}
	
	
} 