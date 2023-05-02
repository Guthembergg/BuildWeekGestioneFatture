package com.spring_security_project.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.model.TipoCliente;
import com.spring_security_project.service.ClienteService;
import com.spring_security_project.service.ComuneService;
import com.spring_security_project.service.IndirizzoService;
import com.spring_security_project.service.ProvinciaService;

@Component
public class Runner implements ApplicationRunner {
	
	@Autowired ClienteService clienteServ;
	@Autowired ProvinciaService provinciaServ;
	@Autowired ComuneService comuneServ;
	@Autowired IndirizzoService indirizzoServ;
	
	@Autowired @Qualifier("clienteFake") ObjectProvider<Cliente> cliente;
	@Autowired @Qualifier("clienteCustom") ObjectProvider<Cliente> clienteCustom;
	@Autowired @Qualifier("provinciaFake") ObjectProvider<Provincia> provincia;
	@Autowired @Qualifier("comuneFake") ObjectProvider<Comune> comune;
	@Autowired @Qualifier("indirizzoFake") ObjectProvider<Indirizzo> indirizzo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Comune com = comune.getObject();
		//System.out.println(com);
		
		Provincia p = provincia.getObject();
		p.getListaComuni().add(com);
		System.out.println(p.getListaComuni().size());
		
		Indirizzo i = indirizzo.getObject();
		//System.err.println(i);
		
		Cliente cl = cliente.getObject();
//		System.out.println(cl);
		
		Cliente cl2 = clienteCustom.getObject("MarioRossi_PA", "138539853", "mario@example.it", LocalDate.now(), LocalDate.now(), 9999, "pecdimario@aruba.sos", "091 44455559", "pecdimario@aruba.sos","prova", "prova2", "908302", TipoCliente.PA, i);
		System.out.println(cl2);
	
				
	}

}
