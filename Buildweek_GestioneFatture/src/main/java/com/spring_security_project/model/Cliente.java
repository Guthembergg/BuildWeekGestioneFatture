package com.spring_security_project.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clienti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String ragioneSociale;
	@Column(unique = true, nullable = false)
	private String partitaIva;
	@Column(unique = true, nullable = false)
	private String email;
	private LocalDate dataInserimento;
	private LocalDate dataUltimoContatto;
	@Column(nullable = false)
	private Integer fatturatoAnnuale;
	@Column(unique = true, nullable = false)
	private String pec;
	@Column(unique = true)
	private String telefono;
	@Column(unique = true)
	private String emailContatto;
	@Column(nullable = false)
	private String nomeContatto;
	@Column(nullable = false)
	private String cognomeContatto;
	@Column(nullable = false)
	private String telefonoContatto;
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;
	@OneToOne(cascade = CascadeType.ALL)
	private Indirizzo sedeLegale;
	@OneToOne
	private Indirizzo sedeOperativa;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	@JsonIgnoreProperties
	private List<Fattura> listaFatture;
	
	

}
