package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.repository.ClienteRepository;
import com.spring_security_project.repository.IndirizzoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	@Autowired
	IndirizzoRepository repoInd;

	public List<Cliente> findAll() {

		return repo.findAll();
	}
	
	public Page<Cliente> getAllClientePageable(Pageable pageable){
		if(repo.findAll(pageable).isEmpty()) {
			throw new EntityNotFoundException("Nessun cliente in archivio");
		} else return repo.findAll(pageable);
	}
	
	public List<Cliente> getAllClientePageableByName(){
		if(repo.findAll().isEmpty()) {
			throw new EntityNotFoundException("Nessun cliente in archivio");
		} else return (repo.findAllOrderBynameDesc());
	}
	

	public Cliente findById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun cliente associato a questo ID");
		}
		return repo.findById(id).get();
	}

	public String addCliente(Cliente cliente) {
		if (repo.existsByEmail(cliente.getEmail())) {
			throw new EntityExistsException("Esiste già un cliente con questo id");
		}
		repo.save(cliente);
		return "Cliente aggiunto";
	}

	public Cliente editCliente(Cliente cliente) {
		if (!repo.existsById(cliente.getId())) {
			throw new EntityNotFoundException("Nessun cliente trovato");
		}
		return repo.save(cliente);
	}

	public String deleteClienteById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun cliente trovato");
		}
		repo.deleteById(id);
		return "Cliente eliminato";
	}

	public String associaIndirizzoEsistente(Long idCliente, Long id,  String type) {
		if (repoInd.existsById(id) && repo.existsById(idCliente)) {
			Cliente c = repo.findById(idCliente).get();
			Indirizzo f = repoInd.findById(id).get();
			if (type == "legale") {
				
				c.setSedeLegale(f);
				repoInd.save(f);
				repo.save(c);
			} else if (type == "operativo") {
				c.setSedeOperativa(f);
				repoInd.save(f);
				repo.save(c);
			}else throw new EntityNotFoundException("tipologia indirizzo sbagliato in sevice");

		
			return "Indirizzo legale associato";
		}
		throw new EntityNotFoundException("Fattura o cliente non esistenti");
	}

}
