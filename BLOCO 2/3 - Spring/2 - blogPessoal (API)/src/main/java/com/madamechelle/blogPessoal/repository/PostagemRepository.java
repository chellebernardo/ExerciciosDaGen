package com.madamechelle.blogPessoal.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.madamechelle.blogPessoal.model.Postagem;
import com.madamechelle.blogPessoal.model.Usuario;

@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long> { 
	//adicionar o tipo primitivo da pk (long = Long)

	public List <Postagem> findByTituloContainingIgnoreCase (String titulo); 
	// IgnoreCase = para fazer a busca sem levar em consideração maíuscula e minúscula

	public Optional<Postagem> findAllByTituloContaining(Postagem postagem);

	public Object save(Usuario criador);

	

	
}
