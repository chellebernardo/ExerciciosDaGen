package com.madamechelle.blogPessoal.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madamechelle.blogPessoal.model.Usuario;
import com.madamechelle.blogPessoal.repository.UsuarioRepository;
import com.madamechelle.blogPessoal.service.UsuarioServices;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	
	private @Autowired UsuarioRepository repository;
	private @Autowired UsuarioServices services;
	
	@GetMapping ("/all")
	public ResponseEntity <List<Usuario>> GetAll (){
		List <Usuario> listaDeUsuarios = repository.findAll();
		if (!listaDeUsuarios.isEmpty()) {
			return ResponseEntity.status(200).body(listaDeUsuarios);
		} else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PostMapping ("/salvar")
	public ResponseEntity<Usuario> salvarUsuario (@Valid @RequestBody Usuario usuario){
		return services.cadastrarUsuario(usuario)
				.map(usuarioExistente -> ResponseEntity.status(201).body(usuarioExistente))
				.orElse(ResponseEntity.status(400).build());
	}
	
	@GetMapping("/id/{id_usuario}")
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		return repository.findById(idUsuario)
				.map(usuarioExistente -> ResponseEntity.status(200).body(usuarioExistente))
				.orElse(ResponseEntity.status(204).build()); 
	}
	
	@GetMapping
	public ResponseEntity<Object> buscarUsuarioPorNome (@RequestParam (defaultValue = "") String nome) {
		List<Usuario> listaDeUsuarios = repository.findAllByNomeContaining(nome);
		
		if (!listaDeUsuarios.isEmpty()){
			return ResponseEntity.status(200).body(listaDeUsuarios);
		} else {
			return ResponseEntity.status(204).body("Ooops... Parece que isso não existe!");
		}
	}
	
	@PutMapping ("/atualizar/{id_usuario}")
	public ResponseEntity <Usuario> atualizarUsuario (@PathVariable  (value = "id_usuario") Long idUsuario,
			@Valid @RequestBody Usuario atualizacaoUsuario) {
		return services.atualizarUsuario(idUsuario, atualizacaoUsuario)
				.map(usuarioAtualizado -> ResponseEntity.status(201).body(usuarioAtualizado))
				.orElse(ResponseEntity.status(304).build());
	}
}
