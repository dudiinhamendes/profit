package br.com.sistema.profit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
	
	private Long id_aluno;
	
	private Long id_professor;
	
	private Long peso;
	
	private Double percentualGordura;
	
	private Double altura;

}
