package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.repository.ComuneRepository;
import com.spring_security_project.repository.ProvinciaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComuneService {
	
	@Autowired ComuneRepository repo;

	public List<Comune> findAll(){
		return (List<Comune>) repo.findAll();
	}
	
	public Comune findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun Comune associato a questo ID");
		}
		return repo.findById(id).get();
	}
	
	public String addComune(Comune comune) {
	
		repo.save(comune);
		return "Comune aggiunta";
	}
	
	public Comune editComune(Comune comune) {
		if(!repo.existsById(comune.getProgressivoComune())) {
			throw new EntityNotFoundException("Nessun comune trovato");
		} return repo.save(comune);
	}
		
	public String deleteComuneById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun comune trovato");
		}  
		repo.deleteById(id);
		return "comune eliminato";
	}

}
