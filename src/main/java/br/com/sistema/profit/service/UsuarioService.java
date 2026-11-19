package br.com.sistema.profit.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.model.Professor;
import br.com.sistema.profit.model.Usuario;
import br.com.sistema.profit.repository.UsuarioRepository;
import br.com.sistema.profit.security.NaoEncontradoException;
import br.com.sistema.profit.security.PreenchimentoInvalidoException;

@Service
public class UsuarioService implements UserDetailsService {
	
	private final AlunoService alunoService;
	private final ProfessorService professorService;	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UsuarioService(AlunoService alunoService, ProfessorService professorService,
			UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.alunoService = alunoService;
		this.professorService = professorService;
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
	
	public Long salvar(Usuario usuario) throws NaoEncontradoException, PreenchimentoInvalidoException {
		if (usuario.getRole() == null || usuario.getRole().trim().isEmpty()) {
			usuario.setRole("ROLE_ATENDENTE");
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
			} else {
				throw new PreenchimentoInvalidoException("CADE A SENHA MANO");
			}
		}

		usuario.setSenha(usuario.getSenha().toLowerCase());
		return usuarioRepository.save(usuario).getId();
	}
	 
	public Usuario buscarPorId(Long id) throws NaoEncontradoException {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado: " + id));
	}
}