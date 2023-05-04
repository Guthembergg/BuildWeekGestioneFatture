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

import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.service.IndirizzoService;

@RestController
@RequestMapping("/indirizzi")
public class IndirizzoController {
	
	@Autowired IndirizzoService service;
	
	@PostMapping
	public ResponseEntity<?> registraIndirizzo(@RequestBody Indirizzo i){
		try {
			return new ResponseEntity<String>(service.addIndirizzo(i), HttpStatus.CREATED);			
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/lista")
	public ResponseEntity<?> recuperaIndirizzo(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> trovaIndirizzo(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> registraIndirizzo(@RequestBody Indirizzo c, @PathVariable Long id){
		try {return new ResponseEntity<Indirizzo>(service.editIndirizzo(c), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaIndirizzo(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.deleteIndirizzoById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/associaComune/{idIndirizzo}/{idComune}")
	public ResponseEntity<?> associaIndirizzoLegaleEsistente(@PathVariable Long idIndirizzo,@PathVariable Long idComune){
		try {return new ResponseEntity<String>(service.associaComuneEsistente(idIndirizzo, idComune), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
	

}
