package com.spring_security_project.configuration;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.model.TipoCliente;

@Configuration
@PropertySource("classpath:application.properties")
public class ClienteConfiguration {
	
	@Autowired IndirizzoConfiguration indirizzo;

	@Bean
	@Scope("prototype")
	public Cliente creaCliente() {

		return new Cliente();

	}

	@Bean("FakeCliente")
	@Scope("prototype")
	public Cliente fakeCliente() {
		Cliente u = new Cliente();
		Faker fake = new Faker(new Locale("it-IT"));
		u.setTipoCliente(TipoCliente.PA);
		u.setNomeContatto(fake.name().firstName());
		u.setCognomeContatto(fake.name().lastName());
		u.setRagioneSociale(u.getNomeContatto() + " " + u.getCognomeContatto() + " " + u.getTipoCliente());
		u.setEmailContatto(fake.internet().emailAddress());
		u.setPartitaIva("P.IVA" + fake.number().numberBetween(10000000, 99999999));
		u.setEmail(fake.internet().emailAddress());
		u.setDataInserimento(LocalDate.now());
		u.setDataUltimoContatto(LocalDate.now());
		u.setFatturatoAnnuale(0);
		u.setPec(fake.internet().safeEmailAddress());
		u.setTelefono(fake.phoneNumber().cellPhone());
		u.setTelefonoContatto(fake.phoneNumber().cellPhone());
		u.setSedeLegale(indirizzo.creaIndirizzoFake());
		u.setSedeOperativa(u.getSedeLegale());

		return u;
	}

	@Bean("CustomCliente")
	@Scope("prototype")
	public Cliente customCliente(String ragioneSociale, String partitaIva, String email, LocalDate dataInserimento,
			LocalDate dataUltimoContatto, Integer fatturatoAnnuale, String pec, String telefono, String emailContatto, String nomeContatto, String cognomeContatto, String telefonoContatto, TipoCliente tipoCliente, Indirizzo sedeLegale) {
		Cliente u = new Cliente();
		u.setNomeContatto(nomeContatto);
		u.setCognomeContatto(cognomeContatto);
		u.setEmailContatto(emailContatto);
		u.setPartitaIva("P.IVA" + partitaIva);
		u.setEmail(email);
		u.setDataInserimento(dataInserimento);
		u.setDataUltimoContatto(dataUltimoContatto);
		u.setFatturatoAnnuale(0);
		u.setPec(pec);
		u.setTelefono(telefono);
		u.setTelefonoContatto(telefonoContatto);
		u.setTipoCliente(tipoCliente);
		u.setSedeLegale(sedeLegale);

		return u;
	}

}
