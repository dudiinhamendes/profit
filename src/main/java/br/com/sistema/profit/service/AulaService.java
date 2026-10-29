package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aula;
import br.com.sistema.profit.repository.AulaRepository;

@Service
public class AulaService {

	private AulaRepository aulaRepository;

	public AulaService(AulaRepository aulaRepository) {
		this.aulaRepository = aulaRepository;
	}

	public List<Aula> listar() {
		return aulaRepository.findAll();
	}

	public Aula buscarPorId(Long id) {
		return aulaRepository.findById(id).orElse(null);
	}

	public Long salvar(Aula aula) {
		return aulaRepository.save(aula).getId();
	}

	public void deletar(Long id) {
		aulaRepository.deleteById(id);
	}
}