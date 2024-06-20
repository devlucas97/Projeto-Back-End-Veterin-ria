package com.projeto.veterinaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Column(name = "especie", length = 50, nullable = false)
	private String especie;
	
	


}
