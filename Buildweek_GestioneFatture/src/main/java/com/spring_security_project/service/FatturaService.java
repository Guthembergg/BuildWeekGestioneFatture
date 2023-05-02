package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.repository.FatturaRepository;
import com.spring_security_project.repository.IndirizzoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FatturaService {

	@Autowired FatturaRepository repo;

	public List<Fattura> findAll(){
		return repo.findAll();
	}
	
	public Fattura findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessuna Fattura associata a questo ID");
		}
		return repo.findById(id).get();
	}
	
	public String addFattura(Fattura fattura) {
	
		repo.save(fattura);
		return "Indirizzo aggiunto";
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
	
}
