package com.spring_security_project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.read_CSV.CSVHelper;
import com.spring_security_project.repository.ProvinciaRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.multipart.MultipartFile;
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
	public void saveCSV(MultipartFile file) {
		   List<Provincia> province;
		try {
			province = CSVHelper.csvToProvincia(file.getInputStream());
		     repo.saveAll(province);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    //System.out.println(province);
		 
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
	
	public Page<Provincia> getAllProvinciaPageable(Pageable pageable) {
		if(repo.findAll(pageable).isEmpty()) {
			throw new EntityNotFoundException("Nessuna provincia");
		}
        
		else return repo.findAll(pageable);
    }
	
	
	
}
