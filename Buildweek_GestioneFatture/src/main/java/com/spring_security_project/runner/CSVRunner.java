package com.spring_security_project.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.spring_security_project.model.Provincia;
import com.spring_security_project.read_CSV.CSVHelper;
import com.spring_security_project.read_CSV.CSVServiceProvincia;
import com.spring_security_project.repository.ProvinciaRepository;
import com.spring_security_project.service.ProvinciaService;
@Component
public class CSVRunner implements CommandLineRunner {
@Autowired
	static ProvinciaService c ;
	

	

	

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
	}



}
