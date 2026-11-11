package br.com.sistema.profit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.model.AvaliacaoFisica;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica,Long> {

	List<AvaliacaoFisica> findAllByAluno(Aluno aluno);


}
