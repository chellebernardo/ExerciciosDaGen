package com.madamechelle.blogPessoal.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.madamechelle.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Usuario usuario;
	private Usuario usuarioAlterar;
	
	@BeforeAll
	public void start () {
		usuario = new Usuario("Michelle", "chellebernardo","123dasilva4");
		usuarioAlterar = new Usuario ("Michelle Bernardo", "chellebernardo", "12345678");
	}
	
	@Disabled //anotação para desabilitar um test específico
	@Test
	void deveSalvarUsuarioRetornaStatus201() {
		
		/*
		 * Criando um objeto do tipo HttpEntity para enviar como terceiro 
		 * parâmetro do método exchange. (Enviando um objeto usuario via body)
		 * 
		 */
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/novo", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	/*
	 * Para liberar o acesso a uma rota: quando a API já estiver com basic config 
	 * acrescentar o ".withBasicAuth ("NomeUsuario", "Senha")" depois do testRestTemplate
	 */
	@Disabled
	@Test
	void deveRetornarListaDeUsuarioRetornaStatus200() {
		ResponseEntity<String> resposta = testRestTemplate
				.exchange("/usuarios/todes", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Test
	void deveAtualizarSenhaUsuarioRetornaStatus201() {
		
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioAlterar);
		ResponseEntity<Usuario> resposta = testRestTemplate
				.exchange("/usuarios/atualizar/17",HttpMethod.PUT, request, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		
	}
}
