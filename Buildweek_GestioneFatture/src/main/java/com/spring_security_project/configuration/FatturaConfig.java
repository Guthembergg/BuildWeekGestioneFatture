package com.spring_security_project.configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.StatoFattura;

@Configuration
public class FatturaConfig {
	
	@Autowired ClienteConfiguration cliente;
	
	@Bean
	@Scope("prototype")
	public Fattura creaFattura() {
		return new Fattura();
	}
	
	@Bean("fakeFattura")
	@Scope("prototype")
	public Fattura fakeFattura() {
		Fattura f = new Fattura();
		Faker fake = new Faker(new Locale ("it-IT"));
		f.setData(fake.date().between(new Date(2000), new Date(2023)));
		f.setAnno(f.getData().getYear());
		f.setImporto(fake.number().randomDouble(2, 1, 100000));
		f.setNumero(fake.number().numberBetween(1, 10000));
		f.setStatoFattura(StatoFattura.EMESSA);
		f.setCliente(cliente.fakeCliente());
		return f;
		
	}
	
	@Bean("customFattura")
	@Scope("prototype")
	public Fattura customFattura(Integer anno, Date data, Double importo, Integer numero, StatoFattura stato, Cliente cliente) {
		Fattura f = new Fattura();
		return f.builder().anno(anno).data(data).importo(importo).numero(numero).statoFattura(stato).cliente(cliente).build();
	}

}
