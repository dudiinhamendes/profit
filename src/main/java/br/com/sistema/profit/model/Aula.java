package br.com.sistema.profit.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	 
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // permite usar <input type="datetime-local">
	private LocalDateTime horario;
	
	@ManyToOne
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor; 
	
	@ManyToMany
	@JoinTable(
		name = "aula_aluno",
		joinColumns = @JoinColumn(name = "aula_id"),
		inverseJoinColumns = @JoinColumn(name = "aluno_id")
	)
	private Set<Aluno> alunos = new HashSet<>();
}