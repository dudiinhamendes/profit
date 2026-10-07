package br.com.sistema.profit.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.sistema.profit.model.Usuario;
import br.com.sistema.profit.repository.UsuarioRepository;

@Service
public class AcessoUsuarioService implements UserDetailsService {
	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AcessoUsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username) 
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
		
		 return User.builder() 
				 .username(usuario.getUsername())
					.password(usuario.getSenha())
					.roles(usuario.getRole().replace("ROLE_", ""))
					.build();
	}  
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public Long salvar(Usuario usuario) {
		if (usuario.getRole() == null || usuario.getRole().trim().isEmpty()) {
			usuario.setRole("ROLE_USUARIO");
		}

		if (usuario.getId() != null) {
			Usuario usuarioBanco = buscarPorId(usuario.getId());
			if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
				usuario.setSenha(usuarioBanco.getSenha());
			} else {
				usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			}
		} else {
			if (usuario.getSenha() != null && !usuario.getSenha().trim().isEmpty()) {
				usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			}
		}

		return usuarioRepository.save(usuario).getId();
	}
	 
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
	}
}