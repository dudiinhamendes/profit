package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Plano;
import br.com.sistema.profit.repository.PlanoRepository;

@Service
public class PlanoService {
	
	private PlanoRepository planoRepository;
	
	public PlanoService(PlanoRepository planoRepository) {
		this.planoRepository=planoRepository;
	}

	
	public List<Plano>listar(){
		
		return planoRepository.findAll();
	}
	
	public void deletar(Long id) {
		planoRepository.deleteById(id);
	}
}
