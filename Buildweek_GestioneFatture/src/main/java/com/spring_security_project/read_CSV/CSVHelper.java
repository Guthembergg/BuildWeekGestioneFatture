package com.spring_security_project.read_CSV;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.spring_security_project.model.Provincia;


public class CSVHelper {
	

		  public static String TYPE = "text/csv";
		  static String[] HEADERs = { "id","Sigla", "Provincia", "Regione"};

		  public static boolean hasCSVFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }
		    public static List<Provincia> csvToProvincia() {//InputStream is
		        try //(BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		         (BufferedReader fileReader = new BufferedReader(new  FileReader("province-italiane-id2.csv"));

		            CSVParser csvParser = new CSVParser(fileReader,
		                CSVFormat.newFormat(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withAllowMissingColumnNames());) {

		          List<Provincia> tutorials = new ArrayList<Provincia>();

		          Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		          for (CSVRecord csvRecord : csvRecords) {
		        	  Provincia tutorial = new Provincia(
		        			  Long.parseLong(csvRecord.get(0)),
		                 csvRecord.get(1),
		                  csvRecord.get(2),
		                  csvRecord.get(3)
		            
		                );

		            tutorials.add(tutorial);
		          }

		          return tutorials;
		        } catch (IOException e) {
		          throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		        }
		    
		    
}}
