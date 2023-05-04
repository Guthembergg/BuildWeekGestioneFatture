package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.repository.IndirizzoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IndirizzoService {

	@Autowired
	IndirizzoRepository repo;

	public List<Indirizzo> findAll() {
		return repo.findAll();
	}

	public Indirizzo findById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun Indirizzo associato a questo ID");
		}
		return repo.findById(id).get();
	}

	public String addIndirizzo(Indirizzo indirizzo) {
	
		repo.save(indirizzo);
		return "Indirizzo aggiunto";
	}

	public Indirizzo editIndirizzo(Indirizzo indirizzo) {
		if (!repo.existsById(indirizzo.getId())) {
			throw new EntityNotFoundException("Nessun indirizzo trovato");
		}
		return repo.save(indirizzo);
	}

	public String deleteIndirizzoById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun Indirizzo trovato");
		}
		repo.deleteById(id);
		return "Indirizzo eliminato";
	}

}
