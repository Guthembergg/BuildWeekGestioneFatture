package com.spring_security_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "indirizzi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private Integer civico;
	@Column(nullable = false)
	private String localita;
	@Column(nullable = false)
	private Integer cap;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Comune comune;
	
	public Indirizzo(String via, Integer civico, String localita, Integer cap) {
		super();
		this.via = via;
		this.civico = civico;
		this.localita = localita;
		this.cap = cap;
	}
	
	
}
