package com.spring_security_project.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.read_CSV.CSVHelper;
import com.spring_security_project.repository.ComuneRepository;
import com.spring_security_project.repository.ProvinciaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComuneService {
	@Autowired ProvinciaRepository repoP;
	@Autowired ComuneRepository repo;

	public List<Comune> findAll(){
		return (List<Comune>) repo.findAll();
	}
	
	public Comune findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun Comune associato a questo ID");
		}
		return repo.findById(id).get();
	}
	
	public String addComune(Comune comune) {
	
		repo.save(comune);
		return "Comune aggiunta";
	}
	public void saveCSV(MultipartFile file) throws IOException {
		  

			BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));

					CSVParser csvParser = new CSVParser(fileReader, CSVFormat.newFormat(';').withFirstRecordAsHeader()
							.withIgnoreHeaderCase().withTrim().withAllowMissingColumnNames());

				List<Comune> tutorials = new ArrayList<Comune>();
					
				Iterable<CSVRecord> csvRecords = csvParser.getRecords();

				for (CSVRecord csvRecord : csvRecords) {
					Comune tutorial = new Comune(Long.parseLong(csvRecord.get(1)), csvRecord.get(2),repoP.findById(Long.parseLong(csvRecord.get(0))).get(),
							csvRecord.get(3)

					);

					tutorials.add(tutorial);

				
		
		      repo.saveAll(tutorials);
				}}
	public Comune editComune(Comune comune) {
		if(!repo.existsById(comune.getProgressivoComune())) {
			throw new EntityNotFoundException("Nessun comune trovato");
		} return repo.save(comune);
	}
		
	public String deleteComuneById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Nessun comune trovato");
		}  
		repo.deleteById(id);
		return "comune eliminato";
	}

	public Page<Comune> getAllComunePageable(Pageable pageable) {
		if(repo.findAll(pageable).isEmpty()) {
			throw new EntityNotFoundException("Nessun comune");
		}
        
		else return repo.findAll(pageable);
    }
}
