package br.com.sistema.profit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.profit.model.Aluno;
import br.com.sistema.profit.model.Plano;

public interface PlanoRepository extends JpaRepository<Plano,Long>{

	boolean existsByNome (String nome);

	List<Plano> findAllByAlunos(Aluno aluno);
} 
