package it.epicode.gestione_fatture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.postgresql.plugin.AuthenticationRequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.jayway.jsonpath.JsonPath;
import com.spring_security_project.auth.entity.ERole;
import com.spring_security_project.auth.entity.Role;
import com.spring_security_project.auth.entity.User;
import com.spring_security_project.auth.repository.RoleRepository;
import com.spring_security_project.auth.repository.UserRepository;
import com.spring_security_project.configuration.ClienteConfiguration;
import com.spring_security_project.controller.ClienteController;
import com.spring_security_project.model.Cliente;
import com.spring_security_project.service.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Cliente.class)
class ControllerClienteTestMockMVC {

	@Autowired
	private MockMvc mockMvc;
	String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJnZ2dnQGhmaGQuY29tIiwiaWF0IjoxNjgzMjgwMDAxLCJleHAiOjE2ODM4ODQ4MDF9._lFVLqd410agvj4gxHRj_NQPPn5Gvp7-RiRsQzLXfgt4aR19fodUZ-BEwz3qk1Mf";
//@Autowired
//	UserRepository repoUser;
//@Autowired
//RoleRepository repoRole;
//@Autowired
//private PasswordEncoder passwordEncoder;
//@BeforeAll
//public void doInit() throws Exception {
//    final User user = new User();
//    user.setUsername("user");
//    user.setPassword("pass");
//    Set<Role> ruoli = new HashSet<Role>();
// Role ruolo = new Role(1l,ERole.ROLE_ADMIN);
//    ruoli.add(ruolo);
//    
//    user.setRoles(ruoli);
//    repoUser.save(user);
//   
//}
//	
	@Test
	// @WithMockUser(username = "k", password = "k")
	//@WithAnonymousUser
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/clienti/lista").header("Authorization", "Bearer " + token)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(containsString("OK")));

	}
}
