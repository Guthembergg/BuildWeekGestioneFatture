package com.spring_security_project.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.model.StatoFattura;
import com.spring_security_project.model.TipoCliente;
import com.spring_security_project.service.ClienteService;
import com.spring_security_project.service.ComuneService;
import com.spring_security_project.service.FatturaService;
import com.spring_security_project.service.IndirizzoService;
import com.spring_security_project.service.ProvinciaService;

@Component
public class Runner implements ApplicationRunner {
	
	@Autowired ClienteService clienteServ;
	@Autowired ProvinciaService provinciaServ;
	@Autowired ComuneService comuneServ;
	@Autowired IndirizzoService indirizzoServ;
	@Autowired FatturaService fatturaServ;
	
	@Autowired @Qualifier("clienteFake") ObjectProvider<Cliente> cliente;
	@Autowired @Qualifier("clienteCustom") ObjectProvider<Cliente> clienteCustom;
	@Autowired @Qualifier("provinciaFake") ObjectProvider<Provincia> provincia;
	@Autowired @Qualifier("comuneFake") ObjectProvider<Comune> comune;
	@Autowired @Qualifier("indirizzoFake") ObjectProvider<Indirizzo> indirizzo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		provinciaServ.saveCSV();
		// METODI COMUNE
		// problema: id provincia non assegnato
		// problema: id da assegnare manualmente(per import excel)
		Provincia p = provincia.getObject();
		p.setId(1l);
		Comune com = comune.getObject();
		com.setProgressivoComune(1l);
		com.setCodice_provincia(p);
		comuneServ.addComune(com);
		//System.out.println(com);
		
		// METODI PROVINCIA
		// problema: id da assegnare manualmente(per import excel)
		p.getListaComuni().add(com);
		//p.setId(2l);
		System.out.println(p.getListaComuni().size());
	//	provinciaServ.addProvincia(p);
	//	Provincia pLetto = provinciaServ.findById(2l);
	//	System.out.println(pLetto);
//		provinciaServ.deleteProvinciaById(3l);
		
		// METODI INDIRIZZO
		// problema creazione fake di comuni dentro indirizzi e viceversa
		// creano un circolo errato
		Indirizzo i = indirizzo.getObject();
		//System.err.println(i);
		//indirizzoServ.addIndirizzo(i);
//		Indirizzo iLetto = indirizzoServ.findById(6l);
//		System.out.println(iLetto);
	//	indirizzoServ.deleteIndirizzoById(6l);
		
		// METODI CLIENTE
		Cliente cl = cliente.getObject();
//		System.out.println(cl);
		
		Cliente cl2 = new Cliente(1l,"MarioRossi_PA", "138539853", "mario@example.it", LocalDate.now(), LocalDate.now(), 9999, "pecdimario@aruba.sos", "091 44455559", "pecdimario@aruba.sos","prova", "prova2", "908302", TipoCliente.PA, i, i);
		System.out.println(cl2);
		//clienteServ.addCliente(cl2);
		
		Fattura f = new Fattura(1l, 2023, new Date(2022, 03, 12), 193.94, 1, StatoFattura.EMESSA, null );
		//fatturaServ.addFattura(f);
		
//		Fattura f2 = new Fattura(2l, 2023, new Date(2022, 03, 12), 142.94, 1, StatoFattura.EMESSA, null );
		fatturaServ.associaFatturaCliente(f, cl2);
		
//		clienteServ.addCliente(cl);
//		clienteServ.deleteClienteById(4l);
		//Cliente clLetto = clienteServ.findById(1l);
		//System.out.println(clLetto);

		// ALTRO
		//1) Aggiungere messaggi di conferma di operazione
		//avvenuta
	
	}

}
