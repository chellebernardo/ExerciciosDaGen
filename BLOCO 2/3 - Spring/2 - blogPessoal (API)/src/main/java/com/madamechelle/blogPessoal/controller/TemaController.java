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

import com.madamechelle.blogPessoal.model.Tema;
import com.madamechelle.blogPessoal.repository.TemaRepository;
import com.madamechelle.blogPessoal.service.UsuarioServices;

@RestController
@RequestMapping ("/tema")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	@Autowired
	private UsuarioServices services;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Tema> getById (@PathVariable long idTema){
		return repository.findById(idTema).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Tema>> getByNome (@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Tema> cadastrarTema (@PathVariable  (value = "id_tema") Long idTema,
			@Valid @RequestBody Tema novoTema) {
		return services.cadastrarTema(idTema, novoTema)
				.map(newTema -> ResponseEntity.status(201).body(newTema))
				.orElse(ResponseEntity.status(304).build());
	}
	
	@PutMapping
	public ResponseEntity<Tema> atualizarTema (@PathVariable  (value = "id_tema") Long idTema,
			@Valid @RequestBody Tema atualizacaoTema) {
		return services.atualizarTema(idTema, atualizacaoTema)
				.map(attTema -> ResponseEntity.status(201).body(attTema))
				.orElse(ResponseEntity.status(304).build());
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long idTema) {
		repository.deleteById(idTema);
	}
}
