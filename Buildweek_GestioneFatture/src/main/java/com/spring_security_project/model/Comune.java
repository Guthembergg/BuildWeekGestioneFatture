package com.spring_security_project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comuni")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comune {

	@Id
	private Long progressivoComune;
	@Column(nullable = false)
	private String denominazione;	
	@JoinColumn(referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Provincia codice_provincia;
	private String nome_provincia;
	@OneToMany(mappedBy = "comune")
	@JsonIgnoreProperties
	private List<Indirizzo> listaIndirizzi;
	public Comune(Long progressivoComune, String denominazione, Provincia codice_provincia, String nome_provincia) {
		super();
		this.progressivoComune = progressivoComune;
		this.denominazione = denominazione;
		this.codice_provincia = codice_provincia;
		this.nome_provincia = nome_provincia;
	}
	
	
	
	public Comune(Long progressivoComune, String denominazione, Provincia codice_provincia, String nome_provincia) {
		super();
		this.progressivoComune = progressivoComune;
		this.denominazione = denominazione;
		this.codice_provincia = codice_provincia;
		this.nome_provincia = nome_provincia;
	}
	
	
	
}
