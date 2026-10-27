package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.repository.AlunoRepository;
import io.micrometer.common.util.StringUtils;

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
				.orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado: " + id));
	}
	
	public Long salvar(Aluno aluno) {
		
		aluno.setRole("ROLE_ALUNO");
 
		if (aluno.getId() != null) {
			Aluno alunoBanco = buscarPorId(aluno.getId());
			if (StringUtils.isBlank(aluno.getSenha())) {
				aluno.setSenha(alunoBanco.getSenha());
			}
		}
 
		return alunoRepository.save(aluno).getId();
	}
	
}
