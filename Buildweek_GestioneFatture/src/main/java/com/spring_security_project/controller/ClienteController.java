package com.spring_security_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Fattura;
import com.spring_security_project.service.ClienteService;
import com.spring_security_project.service.FatturaService;

@RestController
@RequestMapping("/clienti")
public class ClienteController {

	@Autowired ClienteService service;
	@Autowired FatturaService fatturaServ;
	
	@PostMapping
	public ResponseEntity<?> registraCliente(@RequestBody Cliente c){
		try {
			return new ResponseEntity<String>(service.addCliente(c), HttpStatus.CREATED);			
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/lista")
	public ResponseEntity<?> recuperaClienti(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> trovaCliente(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> registraCliente(@RequestBody Cliente c, @PathVariable Long id){
		try {return new ResponseEntity<Cliente>(service.editCliente(c), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaCliente(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.deleteClienteById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/associa/{id}")
	public ResponseEntity<?> associaFatturaCliente(@RequestBody Fattura f, @PathVariable Long id){
		try {return new ResponseEntity<String>(fatturaServ.associaFatturaCliente(f, service.findById(id)), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
	
	
	@PutMapping("/associa/{idCliente}/{idFattura}")
	public ResponseEntity<?> associaFatturaEsistente(@PathVariable Long idCliente,@PathVariable Long idFattura){
		try {return new ResponseEntity<String>(fatturaServ.associaFatturaEsistente(idCliente, idFattura), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
}
