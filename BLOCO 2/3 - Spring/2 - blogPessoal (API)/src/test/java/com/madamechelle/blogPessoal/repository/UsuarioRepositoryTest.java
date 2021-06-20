package com.madamechelle.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.madamechelle.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@BeforeAll
	void start () {
		Usuario usuario = new Usuario ("Michelle Bernardo","chellebernardo", "14256378");
		if (repository.findByUsuario(usuario.getUsuario())!=null)
			repository.save(usuario);
		
		usuario = new Usuario ("Claudia Bernardo","craubernardo", "15263978");
		if (repository.findByUsuario(usuario.getUsuario())!=null)
			repository.save(usuario);
		
		usuario = new Usuario ("Glaucia Bernardo", "glaubernardo", "142536987");
		if (repository.findByUsuario(usuario.getUsuario())!=null)
				repository.save(usuario);
		
		usuario = new Usuario ("Brandow Bernardo", "bradockbernardo", "142536987");
		if (repository.findByUsuario(usuario.getUsuario())!=null)
				repository.save(usuario);
	}
	
	@Test
	public void findByUsuarioRetornaUsuario() throws Exception {
		Usuario usuario = repository.findByUsuario("chellebernardo").get();
		assertTrue(usuario.getUsuario().equals("chellebernardo"));
	}
	
	@Test
	public void findAllByUsuarioContainingCaseRetornaTresUsuarios() {
		List<Usuario> listaDeUsuarios = repository.findAllByNomeContainingIgnoreCase("Bernardo");
		assertEquals(4, listaDeUsuarios.size());
	}
	@AfterAll
	public void end () {
		repository.deleteAll();
	}
}
