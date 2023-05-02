package com.spring_security_project.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Provincia;

@Configuration
@PropertySource("classpath:application.properties")
public class ProvinciaConfig {

	@Bean
	@Scope("prototype")
	public Provincia creaProvincia() {

		return new Provincia();

	}

}
