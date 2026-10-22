package br.com.sistema.profit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;


@Entity 
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Aluno extends Usuario{

	private String sexo;
}
