package com.spring_security_project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.spring_security_project.model.StatoFattura;
import com.spring_security_project.service.FatturaService;

@RestController
@RequestMapping("/fatture")
public class FatturaController {
	
@Autowired FatturaService service;
	
	@PostMapping
	public ResponseEntity<?> registraFattura(@RequestBody Fattura f){
		try {
			return new ResponseEntity<String>(service.addFattura(f), HttpStatus.CREATED);			
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/lista")
	public ResponseEntity<?> recuperaFattura(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> trovaFattura(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
	
	//ritorna lista di fatture associate a un cliente
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?>findByCliente(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.findByCliente(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//ritorna lista di fatture con uno stato specifico
		@GetMapping("/lista/{stato}")
		public ResponseEntity<?>findByStato(@PathVariable StatoFattura stato){
			try {
				return new ResponseEntity<>(service.findByStatoFattura(stato), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		//ritorna lista di fatture emesse tra due date specifiche
				@GetMapping("/lista/{data}")
				public ResponseEntity<?>findByData(@PathVariable Date data){
					try {
						return new ResponseEntity<>(service.findByData(data), HttpStatus.OK);
					} catch (Exception e) {
						// TODO: handle exception
						return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
					}
				}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> registraFattura(@RequestBody Fattura c, @PathVariable Long id){
		try {return new ResponseEntity<Fattura>(service.editFattura(c), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaFattura(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.deleteFatturaById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}

}
