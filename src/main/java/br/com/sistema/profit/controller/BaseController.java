package br.com.sistema.profit.controller; 

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.security.AcessoUsuario;

@Controller
@RequestMapping("/")
public class BaseController {
	
	@GetMapping
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam Optional<String> error, @RequestParam Optional<String> logout,
		 Model model, @AuthenticationPrincipal AcessoUsuario usuarioAtual) {
		if (usuarioAtual != null) {
			return "redirect:/";
		}
		
		error.ifPresent(_ -> model.addAttribute("mensagemErro", "Username e/ou senha incorretos."));
		logout.ifPresent(_ -> model.addAttribute("mensagemLogout", "Você saiu."));
	
	    return "base/login";
	}
	
	
} 