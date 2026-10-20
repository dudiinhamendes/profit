package br.com.sistema.profit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aula;
import br.com.sistema.profit.repository.AulaRepository;

@Service
public class AulaService {
	
	private AulaRepository aulaRepository;
	
	public List<Aula> listar(){
		
		return aulaRepository.findAll();
	}

}
