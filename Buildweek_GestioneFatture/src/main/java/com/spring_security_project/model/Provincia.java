package com.spring_security_project.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "province")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provincia {

	@Id
	private Long id;
	@Column(nullable = false, unique = true)
	private String sigla;
	@Column(nullable = false)
	private String provincia;
	@Column(nullable = false)
	private String regione;
	@OneToMany(mappedBy = "codice_provincia")
	@JsonIgnoreProperties
	private List<Comune> listaComuni;
	public Provincia(String sigla, String provincia, String regione) {
		super();
		this.sigla = sigla;
		this.provincia = provincia;
		this.regione = regione;
	}
	public Provincia(Long id, String sigla, String provincia, String regione) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.provincia = provincia;
		this.regione = regione;
	}
	
}
