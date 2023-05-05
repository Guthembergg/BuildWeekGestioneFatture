package it.epicode.gestione_fatture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import com.spring_security_project.controller.ClienteController;
import com.spring_security_project.model.Cliente;
import com.spring_security_project.service.ClienteService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Cliente.class)
@SpringBootApplication
class TestControllerClienteRestTemplate {


		@LocalServerPort
		private int port;
		@Autowired
		private TestRestTemplate restTemplate;
		//@WithMockUser(username = "k", password = "k")
		@org.junit.jupiter.api.Test
		void testEndpoint () throws Exception {
		assertThat(this.restTemplate.withBasicAuth("k", "k").getForObject(
		"http://localhost:" +port +"/clienti/lista",
		String.class)).contains("OK");

}
	

}
