package it.epicode.gestione_fatture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring_security_project.model.Cliente;
import com.spring_security_project.model.Fattura;
import com.spring_security_project.model.StatoFattura;
import com.spring_security_project.model.TipoCliente;
import com.spring_security_project.repository.ClienteRepository;
import com.spring_security_project.repository.FatturaRepository;
import com.spring_security_project.repository.IndirizzoRepository;
import com.spring_security_project.service.ClienteService;
import com.spring_security_project.service.FatturaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FatturaService.class)
class FatturaServiceTest {

	@Autowired
	FatturaService serv;

	@MockBean
	FatturaRepository cRepository;
	@MockBean
	IndirizzoRepository iRepository;
	@MockBean
	ClienteRepository dRepository;
	static Fattura f = new Fattura(2023, new Date(2022, 03, 12), 193.94, 2, StatoFattura.EMESSA, null);

	@Test
	void test2() {
		f.setId(2l);

		// Cliente c1 = serv.findById(2l);
		Mockito.when(cRepository.save(f)).thenReturn(f);

		assertThat(serv.addFattura(f)).isEqualTo("Fattura aggiunta");
		// serv.findAll().forEach(e->System.out.println(e.getId()));
		// assertEquals(c1, c);
		// assertIterableEquals(serv.findAll(), null);
	}
}
