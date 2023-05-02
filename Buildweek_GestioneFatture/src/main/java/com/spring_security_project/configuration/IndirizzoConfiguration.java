package com.spring_security_project.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Indirizzo;

@Configuration
public class IndirizzoConfiguration {

	@Bean
	@Scope("prototype")
	public Indirizzo creaIndirizzo() {
		return new Indirizzo();
	}

	@Bean("indirizzoFake")
	@Scope("prototype")
	public Indirizzo creaIndirizzoFake() {
		Faker fake = new Faker(new Locale("it-IT"));
		Indirizzo indirizzo = new Indirizzo();
		return indirizzo.builder().via(fake.address().streetAddress()).civico(fake.number().numberBetween(1, 300))
				.localita(fake.address().country()).cap(fake.number().numberBetween(10000, 99999)).build();
	}

	@Bean("indirizzoCustom")
	@Scope("prototype")
	public Indirizzo creaIndirizzoCustom(String via, Integer civico, String localita, Integer cap, Comune comune) {
		Indirizzo indirizzo = new Indirizzo();
		return indirizzo.builder().via(via).civico(civico).localita(localita).cap(cap).comune(comune).build();
	}
}
