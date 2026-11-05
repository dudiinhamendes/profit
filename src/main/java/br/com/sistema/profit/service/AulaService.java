package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aula;
import br.com.sistema.profit.repository.AulaRepository;
import br.com.sistema.profit.security.NaoEncontradoException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AulaService {
	
	private AulaRepository aulaRepository;
	
	public AulaService(AulaRepository aulaRepository) {
		this.aulaRepository = aulaRepository;
	}

	public List<Aula> listar(){
		
		return aulaRepository.findAll();
	}
	
	public void deletar(Long id) {
	  aulaRepository.deleteById(id);
	}

	public Aula buscarPorId(Long id) throws NaoEncontradoException{
		return aulaRepository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("Aluno não encontrado: " + id));
	}

	public Long salvar(Aula aula) {
		
		return aulaRepository.save(aula).getId();
	}
	
}

