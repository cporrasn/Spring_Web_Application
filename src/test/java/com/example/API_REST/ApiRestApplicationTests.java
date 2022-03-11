package com.example.API_REST;

import com.example.API_REST.models.UsuarioModel;
import com.example.API_REST.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApiRestApplicationTests {

	@Autowired
	private UsuarioRepository repositorio;

	/*@Autowired
	private BCryptPasswordEncoder encoder;*/

	@Test
	void crearUsuarioTest() {
		UsuarioModel user=new UsuarioModel();
		user.setNombre("Juan");
		user.setApellido("Perez");
		user.setEmail("A@gmail.com");
		user.setUser("juan");
		//user.setPass(encoder.encode("123"));
		UsuarioModel retorno=repositorio.save(user);
		assertTrue(retorno.getPass().equalsIgnoreCase(user.getPass()));
	}

}
