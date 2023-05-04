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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.service.ProvinciaService;
@Controller
public class CSVHelper {

	@Autowired
	public static ProvinciaService servP;
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "id", "Sigla", "Provincia", "Regione" };
	static String[] HEADERs2 = { "Codice Provincia (Storico)(1)" + "Progressivo del Comune (2)"
			+ "Denominazione in italiano" + "Nome provincia" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Provincia> csvToProvincia(InputStream is) {// InputStream is
		try // (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,
			// "UTF-8"));
		(BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.newFormat(';').withFirstRecordAsHeader()
						.withIgnoreHeaderCase().withTrim().withAllowMissingColumnNames());) {

			List<Provincia> tutorials = new ArrayList<Provincia>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Provincia tutorial = new Provincia(Long.parseLong(csvRecord.get(0)), csvRecord.get(1), csvRecord.get(2),
						csvRecord.get(3)

				);

				tutorials.add(tutorial);
			}

			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	public static List<Comune> csvToComune(InputStream is) {// InputStream is
		try // (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,
			// "UTF-8"));
		(BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				CSVParser csvParser = new CSVParser(fileReader, CSVFormat.newFormat(';').withFirstRecordAsHeader()
						.withIgnoreHeaderCase().withTrim().withAllowMissingColumnNames());) {

			List<Comune> tutorials = new ArrayList<Comune>();
				
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Comune tutorial = new Comune(Long.parseLong(csvRecord.get(1)), csvRecord.get(2),servP.findById(Long.parseLong(csvRecord.get(0))),
						csvRecord.get(3)

				);

				tutorials.add(tutorial);
			}

			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}

	}
}
