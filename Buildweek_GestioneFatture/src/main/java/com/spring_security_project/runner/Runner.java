package com.spring_security_project.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	@Autowired @Qualifier("fakeFattura") ObjectProvider<Fattura> fatturaFake;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//provinciaServ.saveCSV();
		// METODI COMUNE
		// problema: id provincia non assegnato
		// problema: id da assegnare manualmente(per import excel)
//		Provincia p = provincia.getObject();
//		p.setId(1l);
//		Comune com = comune.getObject();
//		com.setProgressivoComune(1l);
//		com.setCodice_provincia(p);
		// comuneServ.addComune(com);
		//System.out.println(com);
		Comune comune = comuneServ.findById(1l);
		System.out.println(comune.getDenominazione());
		
		// METODI PROVINCIA
		// problema: id da assegnare manualmente(per import excel)
//		p.getListaComuni().add(com);
//		//p.setId(2l);
//		System.out.println(p.getListaComuni().size());
	//	provinciaServ.addProvincia(p);
	//	Provincia pLetto = provinciaServ.findById(2l);
	//	System.out.println(pLetto);
//		provinciaServ.deleteProvinciaById(3l);
		
		// METODI INDIRIZZO
		// problema creazione fake di comuni dentro indirizzi e viceversa
		// creano un circolo errato
		//Indirizzo i = indirizzo.getObject();
//		System.err.println(i);
	//	i.setId(1l);
	//	indirizzoServ.addIndirizzo(i);
//		Indirizzo iLetto = indirizzoServ.findById(6l);
//		System.out.println(iLetto);
	//	indirizzoServ.deleteIndirizzoById(6l);
		Indirizzo ind = indirizzo.getObject();
		Indirizzo ind2 = indirizzo.getObject();
		ind.setComune(comune);
		ind2.setComune(comune);
		
		
		// METODI CLIENTE
		//Cliente cl = cliente.getObject();
//		System.out.println(cl);
		Cliente cl2 = new Cliente("MarioRossi_PA", "138539853", "mario@example.it", LocalDate.now(), LocalDate.now(), 9999, "pecdimario@aruba.sos", "091 44455559", "pecdimario@aruba.sos","prova", "prova2", "908302", TipoCliente.PA);
		List<Fattura> lista = new ArrayList<>();		
//		System.out.println(cl);
	//clienteServ.addCliente(cl2);
	
		// FATTURE
		Fattura f = new Fattura(2023, new Date(2022, 03, 12), 193.94, 2, StatoFattura.EMESSA, null );
		//fatturaServ.addFattura(f);
		
		lista.add(f);
	//	Cliente clFatture = new Cliente("GV_SPA", "138539135", "g@example.it", LocalDate.now(), LocalDate.now(), 13242, "pecdig@aruba.sos", "091 44455349", "pecdg@aruba.sos","prova", "prova2", "908302", TipoCliente.PA, indirizzoServ.findById(1l), indirizzoServ.findById(2l), lista);
		//clienteServ.addCliente(clFatture);
		//f.setCliente(cl2);
		//fatturaServ.addFattura(f);
//		cl2.getListaFatture().add(f);
//		clienteServ.editCliente(cl2);
		
	//	Cliente cLetto = clienteServ.findById(1l);
//		Fattura f2 = new Fattura(2l, 2023, new Date(2022, 03, 12), 142.94, 1, StatoFattura.EMESSA, null );
		//fatturaServ.associaFatturaCliente(f, cl2);
	//	fatturaServ.associaFatturaEsistente(1l, 1l);
		
//		clienteServ.addCliente(cl);
//		clienteServ.deleteClienteById(4l);
		//Cliente clLetto = clienteServ.findById(1l);
		//System.out.println(clLetto);

		// ALTRO
		//1) Aggiungere messaggi di conferma di operazione
		//avvenuta
	
	}

}
