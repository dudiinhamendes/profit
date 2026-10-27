package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Professor;
import br.com.sistema.profit.repository.ProfessorRepository;

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

}
