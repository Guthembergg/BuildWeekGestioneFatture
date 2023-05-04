package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.repository.ComuneRepository;
import com.spring_security_project.repository.IndirizzoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IndirizzoService {

	@Autowired
	IndirizzoRepository repo;
	@Autowired
	ComuneRepository repoC;
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
		if (repo.existsById(indirizzo.getId())) {
			throw new EntityExistsException("Esiste già un indirizzo con questo id");
		}
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
	
	public String associaComuneEsistente( Long idIndirizzo ,Long idC) {
		if(repo.existsById(idIndirizzo) && repoC.existsById(idC)) {
			Comune c = repoC.findById(idC).get();
			Indirizzo i = repo.findById(idIndirizzo).get();
			c.getListaIndirizzi().add(i);
			i.setComune(c);
			repo.save(i);
			repoC.save(c);
			return "Comune associato";
		} throw new EntityNotFoundException("Fattura o cliente non esistenti");
	}

}
