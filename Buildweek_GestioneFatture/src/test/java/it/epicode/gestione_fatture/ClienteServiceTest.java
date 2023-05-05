package it.epicode.gestione_fatture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring_security_project.configuration.ClienteConfiguration;
import com.spring_security_project.controller.ClienteController;
import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Comune;
import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.Indirizzo;
import com.spring_security_project.model.Provincia;
import com.spring_security_project.model.TipoCliente;
import com.spring_security_project.repository.ClienteRepository;
import com.spring_security_project.repository.IndirizzoRepository;
import com.spring_security_project.runner.Runner;
import com.spring_security_project.service.ClienteService;
import com.spring_security_project.service.ComuneService;
import com.spring_security_project.service.FatturaService;
import com.spring_security_project.service.IndirizzoService;
import com.spring_security_project.service.ProvinciaService;

import jakarta.annotation.security.RunAs;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ClienteService.class)
class ClienteServiceTest {

	@Autowired
	ClienteService serv;

	@MockBean
	ClienteRepository cRepository;
	@MockBean
	IndirizzoRepository iRepository;
	static Cliente c = new Cliente(2l, "MarioRossi_PA", "138539853", "mario@example.it", LocalDate.now(),
			LocalDate.now(), 9999, "pecdimario@aruba.sos", "091 44455559", "pecdimario@aruba.sos", "prova", "prova2",
			"908302", TipoCliente.PA);

	@Test
	void test2() {
		c.setId(2l);

		
		Mockito.when(cRepository.save(c)).thenReturn(c);

		assertThat(serv.addCliente(c)).isEqualTo("Cliente aggiunto");

	}

}
