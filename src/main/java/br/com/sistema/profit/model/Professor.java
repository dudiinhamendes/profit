package br.com.sistema.profit.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "professor")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends Usuario {
	
	private String cpf;
	private LocalDate localDemissao;
}