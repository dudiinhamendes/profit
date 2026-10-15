package br.com.sistema.profit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.profit.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}
