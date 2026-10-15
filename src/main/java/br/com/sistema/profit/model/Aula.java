package br.com.sistema.profit.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name = "aula")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (unique = true)
	private String nome;
	 
	private LocalDateTime horario;
	
	private Long idProfessor; 
	
	private Long idAluno; 
}

