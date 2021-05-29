package com.madamechelle.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madamechelle.blogPessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	Optional <Usuario> findByUsuario(String usuario);
	
	Optional <Usuario> findById(Long idUsuario);
	
	List<Usuario> findAllByNomeContaining(String nome); //Método para fazer uma pesquisa por nome
}
