package com.spring_security_project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.StatoFattura;

public interface FatturaRepository extends JpaRepository<Fattura, Long> {
	
	public List<Fattura> findByCliente(Long id);
	
	public List<Fattura> findByStatoFattura(StatoFattura statoFattura);

	public List<Fattura> findByData(Date data);
	
	public List<Fattura> findByAnno(Integer anno);
	
	public List<Fattura> findByImportoBetween(Double importoIniziale, Double importoFinale);
}
