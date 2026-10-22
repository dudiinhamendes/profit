package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.AvaliacaoFisica;
import br.com.sistema.profit.repository.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {
	
	
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
		this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
	}

	public List<AvaliacaoFisica> listar(){
		
		return avaliacaoFisicaRepository.findAll();
	}

}
