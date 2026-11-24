package br.com.sistema.profit.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.model.Plano;
import br.com.sistema.profit.model.Usuario;
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
	
	public List<Plano> buscarPorAluno(Aluno aluno) {
		return planoRepository.findAllByAlunos(aluno);
	}
	
	public void deletar(Long id) {
		planoRepository.deleteById(id);
	}
	
	
	public Long salvar(Plano plano) throws FoiEncontradoException, NaoEncontradoException{ 
		
		boolean existePlanoComMesmoNome = planoRepository.existsByNome(plano.getNome());
		
		if (plano.getId() == null && existePlanoComMesmoNome) {
			throw new FoiEncontradoException("Já existe um plano cadastrado com este nome.");
		}
		
		if (plano.getDataInicio() == null) {
			plano.setDataInicio(LocalDate.now());
		}
		
		if (plano.getId() != null) {
			Plano planoBanco = buscarPorId(plano.getId());
			plano.setAlunos(planoBanco.getAlunos());
		}
		 
		return planoRepository.save(plano).getId();	 
	}


	public void removerAluno(Long idPlano, Long idAluno) {
		Optional<Plano> plano = planoRepository.findById(idPlano);
		plano.ifPresent(p -> {
			Set<Aluno> listaAlunos = p.getAlunos().stream().filter(a -> !idAluno.equals(a.getId())).collect(Collectors.toSet());
			p.setAlunos(listaAlunos);
			planoRepository.save(p);
		});
	}
	
}
