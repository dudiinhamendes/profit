package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Professor;
import br.com.sistema.profit.model.Usuario;
import br.com.sistema.profit.repository.ProfessorRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class ProfessorService {
	
	private ProfessorRepository professorRepository;
    private PasswordEncoder passwordEncoder;
	
	public ProfessorService(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	public List<Professor>listar(){
		return professorRepository.findAll();
	}

	public Professor buscarPorId(Long id) {
		return professorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Professor não encontrado: " + id));
	}
	
public Long salvar(Professor professor) {
		
	professor.setRole("ROLE_PROFESSOR");
 
	if (professor.getId() != null) {
		Professor professorBanco = buscarPorId(professor.getId());
		if (professor.getSenha() == null || professor.getSenha().trim().isEmpty()) {
			professor.setSenha(professorBanco.getSenha());
		} else {
			professor.setSenha(passwordEncoder.encode(professor.getSenha()));
		}
	} else {
		if (professor.getSenha() != null && !professor.getSenha().trim().isEmpty()) {
			professor.setSenha(passwordEncoder.encode(professor.getSenha()));
		}
	}
 
		return professorRepository.save(professor).getId();
	}

}
