package com.spring_security_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.service.ProvinciaService;

@RestController
@RequestMapping("/province")
public class ProvinciaController {

	@Autowired ProvinciaService service;
	
	@GetMapping("/lista")
	private ResponseEntity<?> listaProvince(Pageable pageable){
		try {
			return new ResponseEntity<>(service.getAllProvinciaPageable(pageable), HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}

}