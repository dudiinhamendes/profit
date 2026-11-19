package br.com.sistema.profit.controller; 

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistema.profit.model.Usuario;
import br.com.sistema.profit.security.AcessoUsuario;
import br.com.sistema.profit.security.NaoEncontradoException;
import br.com.sistema.profit.security.PreenchimentoInvalidoException;
import br.com.sistema.profit.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
@PreAuthorize("hasAnyRole('ADMIN')")
public class UsuarioController implements CrudController<Usuario> {

	UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService; 
	}	

	@Override
	@GetMapping("/cadastrar")
	public String cadastrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
	}

	@Override
	@GetMapping("/visualizar")
	@PreAuthorize("hasAnyRole('ADMIN', 'ATENDENTE')")
	public String visualizar(@RequestParam Long id, Model model) {
	/*AcessoUsuario logado = (AcessoUsuario) SecurityContextHolder
			.getContext()
			.getAuthentication()
			.getPrincipal();
		if(logado.isAdmin() && logado.getId().equals(id)) {
			return "redirect:/usuario/visualizar?id=";
		}*/
		try {
			
			Usuario usuario = usuarioService.buscarPorId(id);
			model.addAttribute("edit", false);
			model.addAttribute("usuario", usuario);
			return "usuario/form";
		} catch(NaoEncontradoException _) {
			// adicionar erro ao log de usuário não encontrado
			return "redirect:/usuario/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/editar")
	public String editar(@RequestParam Long id, Model model) {
		try {
			Usuario usuario = usuarioService.buscarPorId(id);
			if(usuario.getRole().equals("ROLE_ALUNO") || usuario.getRole().equals("ROLE_PROFESSOR")) {
				return "redirect:/usuario/listar?msg=e-notFound";
			}
			model.addAttribute("edit", true);
			model.addAttribute("usuario", usuario);
			return "usuario/form";
		} catch(NaoEncontradoException _) {
			// adicionar erro ao log de usuário não encontrado
			return "redirect:/usuario/listar?msg=e-notFound";
		}
	}

	@Override
	@GetMapping("/listar")
	public String listar(@RequestParam Optional<String> msg, Model model) {
		msg.ifPresent(m -> adicionaMensagem(model, m));
		model.addAttribute("listaUsuario", usuarioService.listar());
		return "usuario/listar";
	}

	@Override
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Usuario usuario) {
		try {
			usuarioService.salvar(usuario);
			return "redirect:/usuario/listar?msg=s-saved";
		} catch(NaoEncontradoException _) {
			return "redirect:/usuario/listar?msg=e-notFound";
		} catch(PreenchimentoInvalidoException _) {
			return "redirect:/usuario/listar?msg=e-invalidData";
		}

	}

	@PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR', 'ATENDENTE', 'ALUNO')")
	@GetMapping("/profile")
	public String profile(Model model, @AuthenticationPrincipal AcessoUsuario usuarioAtual) {

		String urlDestino = "redirect:/";
		if (usuarioAtual.isAluno()) {
			urlDestino += "aluno";
		} else if (usuarioAtual.isProfessor()) {
			urlDestino += "professor";
		} else {
			urlDestino += "usuario";
		}
		return urlDestino + "/visualizar?id=" + usuarioAtual.getId();

	}

}