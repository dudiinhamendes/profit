package br.com.sistema.profit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity 
@Table(name = "aluno")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Aluno extends Usuario{

	

	private String sexo;
	private  String id_plano;
	
	
}
