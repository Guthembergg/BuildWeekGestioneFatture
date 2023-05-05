package it.epicode.gestione_fatture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.TipoCliente;
import com.spring_security_project.repository.ClienteRepository;
import com.spring_security_project.repository.IndirizzoRepository;
import com.spring_security_project.service.ClienteService;
import com.spring_security_project.service.FatturaService;
@SpringBootTest(classes = ClienteService.class)
class TestServiceClienteFindALL {
	@Autowired
	ClienteService serv;
	@MockBean
	ClienteRepository cRepository;
	@MockBean
	IndirizzoRepository iRepository;
	@Test
	void testFindALL() {
	 Cliente c = new Cliente(1l,"MarioRossi_PA", "138539853", "mario@example.it", LocalDate.now(), LocalDate.now(), 9999, "pecdimario@aruba.sos", "091 44455559", "pecdimario@aruba.sos","prova", "prova2", "908302", TipoCliente.PA);
	serv.addCliente(c);
		//Cliente c1 =serv.findById(c.getId());
		List<Cliente> a= new ArrayList<Cliente>();
		a.add(c);
		Mockito.when( cRepository.findAll()).thenReturn( a);

		assertThat(serv.findAll()).isEqualTo(a);
		
	
	}

}
