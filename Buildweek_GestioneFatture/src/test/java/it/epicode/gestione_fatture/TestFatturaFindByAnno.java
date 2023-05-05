package it.epicode.gestione_fatture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.spring_security_project.repository.ClienteRepository;
import com.spring_security_project.repository.FatturaRepository;
import com.spring_security_project.repository.IndirizzoRepository;
import com.spring_security_project.service.FatturaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FatturaService.class)
class TestFatturaFindByAnno {

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
		List<Fattura> a = new ArrayList<Fattura>();
		a.add(f);

		Mockito.when(cRepository.findByAnno(f.getAnno())).thenReturn(a);

		assertThat(serv.findByAnno(f.getAnno())).isEqualTo(a);

	}

}
