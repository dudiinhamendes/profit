package br.com.sistema.profit.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Plano;
import br.com.sistema.profit.repository.PlanoRepository;
import br.com.sistema.profit.security.FoiEncontradoException;
import br.com.sistema.profit.security.NaoEncontradoException;

@Service
public class PlanoService {
	
	private PlanoRepository planoRepository;
	
	public PlanoService(PlanoRepository planoRepository) {
		this.planoRepository=planoRepository;
	}

	
	public List<Plano>listar(){
		
		return planoRepository.findAll();
	}


	public Plano buscarPorId(Long id) throws NaoEncontradoException {
		return planoRepository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("Plano não encontrado: " + id));
	}
	
	public void deletar(Long id) {
		planoRepository.deleteById(id);
	}
	
	
	public Long salvar(Plano plano) throws FoiEncontradoException{ 
		
		boolean existePlanoComMesmoNome = planoRepository.existsByNome(plano.getNome());
		
		if (plano.getId() == null && existePlanoComMesmoNome) {
			throw new FoiEncontradoException("Já existe um plano cadastrado com este nome.");
		}
		
		if (plano.getDataInicio() == null) {
			plano.setDataInicio(LocalDate.now());
		}
		 
		return planoRepository.save(plano).getId();	 
	}
	
}
