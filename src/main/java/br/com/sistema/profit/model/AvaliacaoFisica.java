package br.com.sistema.profit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class AvaliacaoFisica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor;
	
	private Long peso;
	
	private Double percentualGordura;
	
	private Double altura;
}
