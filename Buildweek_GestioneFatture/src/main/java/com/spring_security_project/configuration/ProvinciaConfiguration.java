package com.spring_security_project.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Provincia;

@Configuration
public class ProvinciaConfiguration {
	
	@Autowired ComuneConfiguration comune;

	@Bean
	@Scope("prototype")
	public Provincia creaProvincia() {
		return new Provincia();
	}
	
	@Bean("provinciaFake")
	@Scope("prototype")
	public Provincia creaProvinciaFake() {
		Faker fake = new Faker(new Locale("it-IT"));
		Provincia prov = new Provincia();
		prov.setSigla(fake.address().cityPrefix());
		prov.setProvincia(fake.address().city());
		prov.setRegione(fake.address().country());
		prov.setListaComuni(new ArrayList<Comune>());
		for(int i = 0; i < 5; i++) {
			prov.getListaComuni().add(comune.creaComuneFake());
		}
		return prov;
	}
	
	@Bean("provinciaCustom")
	@Scope("prototype")
	public Provincia creaProvinciaCustom(String sigla, String provincia, String regione, List<Comune>listaComuni) {
		Provincia prov = new Provincia();
		prov.setSigla(sigla);
		prov.setProvincia(provincia);
		prov.setRegione(regione);
		prov.setListaComuni(listaComuni);
		return prov;
	}
	
}
