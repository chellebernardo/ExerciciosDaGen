package com.madamechelle.blogPessoal.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madamechelle.blogPessoal.model.Postagem;
import com.madamechelle.blogPessoal.repository.PostagemRepository;
import com.madamechelle.blogPessoal.service.UsuarioServices;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	// Injeção de dependência
	@Autowired
	private PostagemRepository repository;
	@Autowired
	private UsuarioServices services;

	// Para obter todas as postagens através de uma lista criada no repository
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	//Outra forma de buscar por todas as postagens
	/*
	 List <Postagem> listaDePostagem = repository.findAll(); 
	 if (!listaDePostagegm.isEmpty()){ 
	  		returnResponseEntity.status(200).body(listaDePostagem); 
	 } else { 
	  		returnResponseEntity.status(204).build(); 
	  		}
	 */

	// Obtendo as postagens por idPostagem
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long idPostagem) {
		return repository.findPostById(idPostagem)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	}

	// Para obter as postagens por título
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(titulo));
	}
	

	/*@PostMapping
	public ResponseEntity<Postagem> novoPost(@RequestBody Postagem postagem) {
		return ResponseEntity.status(201).body(repository.save(postagem));
	}*/
	
	@PostMapping ("/{id_usuario}/novo/post")
	public ResponseEntity<Postagem> novoPost (@PathVariable (value = "id_usuario") Long idUsuario, 
			@RequestBody Postagem novoPost) {
		return ResponseEntity.status(201).body(repository.save(novoPost));
	}
	
	@PutMapping ("/{id_usuario}/{id_postagem}/atualizar/post")
	public ResponseEntity<Postagem> atualizarPost (@PathVariable (value = "id_usuario") Long idUsuario, 
			@PathVariable (value = "id_postagem") Long idPostagem,
			@Valid @RequestBody Postagem atualizacaoPost) {
		return services.atualizarPost(idPostagem, atualizacaoPost)
				.map(attPost -> ResponseEntity.status(201).body(attPost))
				.orElse(ResponseEntity.status(304).build());
	}
	
	
	/*@PutMapping ("/{id_usuario}/{id_postagem}/atualizar/post")
	public ResponseEntity<Postagem> atualizarPost (@PathVariable (value = "id_usuario") Long idUsuario, 
			@PathVariable (value = "id_postagem") Long idPostagem,
			@Valid @RequestBody Postagem atualizacaoPost){
		return	repository.findPostById(idPostagem)
				.map(postExistente -> ResponseEntity.status(201).body(postExistente))
				.orElse(ResponseEntity.status(400).build());
	}*/

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
