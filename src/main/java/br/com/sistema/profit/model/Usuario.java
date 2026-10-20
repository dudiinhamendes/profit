package br.com.sistema.profit.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


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
@Table(name = "usuario")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true) 
	private String username;
	
	private String senha;
	
	private String nome;
	
	private String role;
	
	private String telefone;
	
	@CreationTimestamp
	@Column(updatable = false) 
	private LocalDateTime dataCriacao;
	
	@Column (nullable = false) 
	private boolean ativo = true;
	
}