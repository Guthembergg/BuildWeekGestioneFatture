package com.spring_security_project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.model.StatoFattura;
import com.spring_security_project.repository.ClienteRepository;
import com.spring_security_project.repository.FatturaRepository;
import com.spring_security_project.repository.IndirizzoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FatturaService {

	@Autowired FatturaRepository repo;
	@Autowired IndirizzoRepository repoInd;
	@Autowired ClienteRepository repoCliente;

	public List<Fattura> findAll(){
		return repo.findAll();
	}
	
	public Fattura findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessuna Fattura associata a questo ID");
		}
		return repo.findById(id).get();
	}
	
	public List<Fattura> findByCliente(Long id){
		if(!repoCliente.existsById(id)) {
			throw new EntityNotFoundException("Nessun cliente trovato");
		}
		return repo.findByCliente(id);
	}
	
	public List<Fattura> findByStatoFattura(StatoFattura statoFattura){		
		return repo.findByStatoFattura(statoFattura);
	}
	
	public List<Fattura> findByData(Date data){
		return repo.findByData(data);
	}
	
	public List<Fattura> findByAnno(Integer anno){	
		return repo.findByAnno(anno);
	}
	
	public List<Fattura> findByImportoBetween(Double importoIniziale, Double importoFinale){
		return repo.findByImportoBetween(importoIniziale, importoFinale);
	}
	
	public String addFattura(Fattura fattura) {
	
		repo.save(fattura);
		return "Fattura aggiunta";
	}
	
	public Fattura editFattura(Fattura fattura) {
		if(!repo.existsById(fattura.getId())) {
			throw new EntityNotFoundException("Nessuna fattura trovata");
		} return repo.save(fattura);
	}
		
	public String deleteFatturaById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessuna fattura trovata");
		}  
		repo.deleteById(id);
		return "fattura eliminata";
	}
	
	public String associaFatturaCliente(Fattura f, Cliente c) {
		if(repoCliente.existsById(c.getId())) {
			f.setCliente(c);
			c.getListaFatture().add(f);
			repo.save(f);	
			repoCliente.save(c);
			return "Fattura associata";
		} else {
			throw new EntityNotFoundException("Il cliente inserito non esiste");
		}
	}
	
	public String associaFatturaEsistente( Long idCliente ,Long id) {
		if(repo.existsById(id) && repoCliente.existsById(idCliente)) {
			Cliente c = repoCliente.findById(idCliente).get();
			Fattura f = repo.findById(id).get();
			c.getListaFatture().add(f);
			repo.save(f);
			repoCliente.save(c);
			return "Fattura associata";
		} throw new EntityNotFoundException("Fattura o cliente non esistenti");
	}

	
}
