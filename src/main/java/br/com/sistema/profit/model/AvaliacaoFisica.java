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
@Table(name = "avalicaoFisica")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class AvaliacaoFisica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Long id_aluno;
	
	@ManyToOne
	@JoinColumn(name = "professor_id", nullable = false)
	private Long id_professor;
	
	private Long peso;
	
	private Double percentualGordura;
	
	private Double altura;

	public AvaliacaoFisica() {}
	
	public AvaliacaoFisica(Long id, Long id_aluno, Long id_professor, Long peso, Double percentualGordura,
			Double altura) {
		this.id = id;
		this.id_aluno = id_aluno;
		this.id_professor = id_professor;
		this.peso = peso;
		this.percentualGordura = percentualGordura;
		this.altura = altura;
	}
}
