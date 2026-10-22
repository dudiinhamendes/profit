package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.repository.AlunoRepository;

@Service
public class AlunoService {

	private AlunoRepository  alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

	public Aluno buscarPorId(Long id) {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
	}
}
