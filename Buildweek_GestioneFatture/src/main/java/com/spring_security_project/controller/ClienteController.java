package com.spring_security_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.spring_security_project.repository.FatturaRepository;
import com.spring_security_project.service.ClienteService;
import com.spring_security_project.service.FatturaService;

@RestController
@RequestMapping("/clienti")
public class ClienteController {

	@Autowired ClienteService service;
	@Autowired FatturaService fatturaServ;
	@Autowired FatturaRepository fatturaRepo;
	
	// FORSE AGGIUNGERE ASSOCIA SEDE OPERATIVA CLIENTE
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> registraCliente(@RequestBody Cliente c){
		try {
			return new ResponseEntity<String>(service.addCliente(c), HttpStatus.CREATED);			
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/lista")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> recuperaClienti(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	
	//ritorna lista con paginazione
		@GetMapping("/paginazione")
		@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
		public ResponseEntity<?> recuperaClientiPageable(Pageable pageable){
			try {
				return new ResponseEntity<>(service.getAllClientePageable(pageable), HttpStatus.FOUND);
			} catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}		
		}
		
		//ritorna lista ordinata per nome
			@GetMapping("/paginazione/nomi")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPageableName(Pageable pageable){
				try {
					return new ResponseEntity<>(service.getAllClientePageableByName(), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
			//ritorna lista ordinata per fatturato
			@GetMapping("/paginazione/fatturato")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPageableFatturato(Pageable pageable){
				try {
					return new ResponseEntity<>(service.getAllClientePageableByFatturato(), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
			//ritorna lista ordinata per data inserimento
			@GetMapping("/paginazione/data_ins")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPageableDataIns(Pageable pageable){
				try {
					return new ResponseEntity<>(service.getAllClientePageableByDataInserimento(), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
			//ritorna lista ordinata per data ultimo contatto (NON PAGINATO)
			@GetMapping("/paginazione/data_ult")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPageableDataUltCont(){
				try {
					return new ResponseEntity<>(service.getAllClientePageableByDataUltimoContatto(), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
			//ritorna lista ordinata per provincia (DA SISTEMARE)
			@GetMapping("/paginazione/prov")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPageableProvincia(){
				try {
					return new ResponseEntity<>(service.getAllClientePageableByProvincia(), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
			//ritorna lista ordinata per parte del nome (NON PAGINATO)
			@GetMapping("/paginazione/cercaPerParteNome/{parteNome}")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPerParteNome(Pageable pageable, @PathVariable String parteNome){
				try {
					return new ResponseEntity<>(service.findByParteDelNome(parteNome), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
			//ritorna lista ordinata per fatturato maggiore di {param} (NON PAGINATO)
			@GetMapping("/paginazione/fatturato_maggiore_di{fatturato}")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPerFatturatoMaggioreDi(Pageable pageable, @PathVariable Integer fatturato){
				try {
					return new ResponseEntity<>(service.findByFatturatoMaggioreDi(fatturato), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
			//ritorna lista ordinata per fatturato minore di {param} (NON PAGINATO)
			@GetMapping("/paginazione/fatturato_minore_di{fatturato}")
			@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
			public ResponseEntity<?> recuperaClientiPerFatturatoMinoreDi(Pageable pageable, @PathVariable Integer fatturato){
				try {
					return new ResponseEntity<>(service.findByFatturatoMinoreDi(fatturato), HttpStatus.FOUND);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}		
			}
			
		
	
	
	@GetMapping("/trovaPerId/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> trovaCliente(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
	
	
	@PutMapping("/modifica/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> modificaCliente(@RequestBody Cliente c, @PathVariable Long id){
		c.setId(id);
		try {return new ResponseEntity<Cliente>(service.editCliente(c), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
	
	@DeleteMapping("/elimina/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> eliminaCliente(@PathVariable Long id){
		try {
			return new ResponseEntity<>(service.deleteClienteById(id), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
	
	@PutMapping("/associaFattura/{idCliente}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> associaFatturaAClienteEsistente(@RequestBody Fattura f, @PathVariable Long idCliente){
		if(fatturaRepo.existsByNumero(f.getNumero())) {
			return new ResponseEntity<>("Numero fattura già esistente, inseriscine uno diverso", HttpStatus.FOUND);
		} 
		
		try {return new ResponseEntity<String>(fatturaServ.associaFatturaCliente(f, service.findById(idCliente)), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
	
	
	@PutMapping("/associa/{idCliente}/{idFattura}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> associaFatturaEsistenteAClienteEsistente(@PathVariable Long idCliente,@PathVariable Long idFattura){
		 		
		try {return new ResponseEntity<String>(fatturaServ.associaFatturaEsistente(idCliente, idFattura), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}		 
	}
}
