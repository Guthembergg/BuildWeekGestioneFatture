package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.repository.ClienteRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	
	@Autowired ClienteRepository repo;
	
	public List<Cliente> findAll(){
	
		return repo.findAll();
	}
	
	public Cliente findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun cliente associato a questo ID");
		}
		return repo.findById(id).get();
	}
	
	public String addCliente(Cliente cliente) {
		if(repo.existsById(cliente.getId())) {
			throw new EntityExistsException("Esiste già un cliente con questo id");
		}
		repo.save(cliente);
		return "Cliente aggiunto";
	}
	
	public Cliente editCliente(Cliente cliente) {
		if(!repo.existsById(cliente.getId())) {
			throw new EntityNotFoundException("Nessun cliente trovato");
		} return repo.save(cliente);
	}
		
	public String deleteClienteById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun cliente trovato");
		}  
		repo.deleteById(id);
		return "Cliente eliminato";
	}
	
	

}
