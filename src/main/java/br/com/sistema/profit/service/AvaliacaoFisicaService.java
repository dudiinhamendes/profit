package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.AvaliacaoFisica;
import br.com.sistema.profit.repository.AvaliacaoFisicaRepository;
import br.com.sistema.profit.repository.ProfessorRepository;
import br.com.sistema.profit.security.AcessoUsuario;
import br.com.sistema.profit.security.NaoEncontradoException;

@Service
public class AvaliacaoFisicaService {
	
	
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	private ProfessorService professorService;
	
	public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository,
			ProfessorService professorService) {
		this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
		this.professorService = professorService;
	}

	public List<AvaliacaoFisica> listar(){
		
		return avaliacaoFisicaRepository.findAll();
	}

	public AvaliacaoFisica buscarPorId(Long id) throws NaoEncontradoException {
		return avaliacaoFisicaRepository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("Avaliação Física não encontrado: " + id));
	}
	
	public void deletar(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}
	
	public Long salvar(AvaliacaoFisica avaliacaoFisica, Long id) throws NaoEncontradoException {
		avaliacaoFisica.setProfessor(professorService.buscarPorId(id));
		return avaliacaoFisicaRepository.save(avaliacaoFisica).getId();
	}
	
} 