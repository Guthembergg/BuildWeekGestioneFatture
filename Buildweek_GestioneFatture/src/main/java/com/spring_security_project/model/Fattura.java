package com.spring_security_project.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fatture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fattura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer anno; 
	@Column(nullable = false)
	private Date data;
	@Column(nullable = false)
	private Double importo; 
	@Column(nullable = false, unique = true)
	private Integer numero; 
	
	public Fattura(Integer anno, Date data, Double importo, Integer numero, StatoFattura statoFattura,
			Cliente cliente) {
		super();
		this.anno = anno;
		this.data = data;
		this.importo = importo;
		this.numero = numero;
		this.statoFattura = statoFattura;
		this.cliente = cliente;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatoFattura statoFattura;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Cliente cliente;
	
}
