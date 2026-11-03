package br.com.sistema.profit.service;

import java.time.LocalDate;
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


	public Plano buscarPorId(Long id) {
		return planoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Plano não encontrado: " + id));
	}
	
	public void deletar(Long id) {
		planoRepository.deleteById(id);
	}
	
	
	public Long salvar(Plano plano) { 
		
		boolean existePlanoComMesmoNome = planoRepository.existsByNome(plano.getNome());
		
		if (plano.getId() == null && existePlanoComMesmoNome) {
			throw new IllegalArgumentException("Já existe um plano cadastrado com este nome.");
		}
		
		if (plano.getDataInicio() == null) {
			plano.setDataInicio(LocalDate.now());
		}
		 
		return planoRepository.save(plano).getId();	 
	}
	
}
