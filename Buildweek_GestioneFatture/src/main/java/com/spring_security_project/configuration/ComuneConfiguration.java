package com.spring_security_project.configuration;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Indirizzo;

@Configuration
public class ComuneConfiguration {
	
	@Autowired IndirizzoConfiguration indirizzo;
	
	@Bean
	@Scope("prototype")
	public Comune creaComune() {
		return new Comune();
	}
	
	@Bean("comuneFake")
	@Scope("prototype")
	public Comune creaComuneFake() {
		Faker fake = new Faker(new Locale("it-IT"));
		Comune comune = new Comune();
		 comune.setDenominazione(fake.address().cityName());
		 comune.setNome_provincia(fake.address().city());
		 for(int i = 0; i < 5; i++) {			 
			 comune.getListaIndirizzi().add(indirizzo.creaIndirizzoFake());
		 }
		return comune;
	}
	
	@Bean("comuneCustom")
	@Scope("prototype")
	public Comune creaComuneCustom(String denominazione, String nome_provincia, List<Indirizzo> listaIndirizzi) {
		Comune comune = new Comune();
		return comune.builder()
		.denominazione(denominazione)
		.nome_provincia(nome_provincia)
		.listaIndirizzi(listaIndirizzi)
		.build();		
	}
	
}
