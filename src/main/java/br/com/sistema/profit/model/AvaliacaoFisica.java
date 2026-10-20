package br.com.sistema.profit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "avaliacaoFisica")
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

	public AvaliacaoFisica() {}

	public AvaliacaoFisica(Long id, Aluno aluno, Professor professor, Long peso, Double percentualGordura,
			Double altura) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.professor = professor;
		this.peso = peso;
		this.percentualGordura = percentualGordura;
		this.altura = altura;
	}
	
}
