package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.read_CSV.CSVHelper;
import com.spring_security_project.repository.ProvinciaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProvinciaService {

	@Autowired 
	ProvinciaRepository repo;

	public List<Provincia> findAll(){
		return (List<Provincia>) repo.findAll();
	}
	
	public Provincia findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessuna Provincia associata a questo ID");
		}
		return repo.findById(id).get();
	}
	
	public String addProvincia(Provincia provincia) {
	
		repo.save(provincia);
		return "Provincia aggiunta";
	}
	public void saveCSV() {
		   List<Provincia> province = CSVHelper.csvToProvincia();
		    System.out.println(province);
		      repo.saveAll(province);
	}
	
	public Provincia editProvincia(Provincia provincia) {
		if(!repo.existsById(provincia.getId())) {
			throw new EntityNotFoundException("Nessuna provincia trovata");
		} return repo.save(provincia);
	}
		
	public String deleteProvinciaById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessuna provincia trovata");
		}  
		repo.deleteById(id);
		return "provincia eliminata";
	}
	
	
	
}
