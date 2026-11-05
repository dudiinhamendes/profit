package br.com.sistema.profit.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.repository.AlunoRepository;
import br.com.sistema.profit.security.NaoEncontradoException;

@Service
public class AlunoService {

	private AlunoRepository  alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	

	public Aluno buscarPorId(Long id) throws NaoEncontradoException {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("Aluno não encontrado: " + id));
	}
	
	public Long salvar(Aluno aluno) throws NaoEncontradoException {
		
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
