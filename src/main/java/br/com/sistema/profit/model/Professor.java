package br.com.sistema.profit.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends Usuario {
	
	@Column(unique = true)
	private String cpf;
	
	private LocalDate dataDemissao;
}