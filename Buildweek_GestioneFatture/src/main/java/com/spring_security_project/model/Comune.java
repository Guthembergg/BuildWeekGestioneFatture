package com.spring_security_project.model;

import java.util.List;

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
	@ManyToOne
	private Provincia codice_provincia;
	private String nome_provincia;
	@OneToMany(mappedBy = "comune")
	private List<Indirizzo> listaIndirizzi;
	
}
