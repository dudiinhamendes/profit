package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.model.Professor;
import br.com.sistema.profit.repository.ProfessorRepository;
import io.micrometer.common.util.StringUtils;

@Service
public class ProfessorService {
	
	private ProfessorRepository professorRepository;	
	
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
			if (StringUtils.isBlank(professor.getSenha())) {
				professor.setSenha(professorBanco.getSenha());
			}
		}
 
		return professorRepository.save(professor).getId();
	}

}
