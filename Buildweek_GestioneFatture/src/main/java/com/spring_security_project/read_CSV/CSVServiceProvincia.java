package com.spring_security_project.read_CSV;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring_security_project.model.Provincia;
import com.spring_security_project.repository.ProvinciaRepository;
@Service
public class CSVServiceProvincia {
	
		@Autowired
	  public static ProvinciaRepository p;
	 public void save() {
		    List<Provincia> province = CSVHelper.csvToProvincia();
		    System.out.println(province);
		      p.saveAll(province);
		  }

		  public List<Provincia> getAllProvince() {
		    return (List<Provincia>) p.findAll();
		  }
	
}
