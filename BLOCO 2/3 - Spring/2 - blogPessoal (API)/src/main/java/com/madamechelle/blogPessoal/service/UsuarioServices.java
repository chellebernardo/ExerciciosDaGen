package com.madamechelle.blogPessoal.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madamechelle.blogPessoal.model.Postagem;
import com.madamechelle.blogPessoal.model.Usuario;
import com.madamechelle.blogPessoal.repository.PostagemRepository;
import com.madamechelle.blogPessoal.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PostagemRepository repositoryP;
	
	/**
	 * Metodo utilizado para cadastrar um usuario no sistema, validando sua existencia.
	 * @param novoUsuario
	 * @since 1.0
	 * @author Chelle
	 * @return Optional com entidade Usuario dentro ou Optional vazio.
	 */
	
	public Optional <Usuario> cadastrarUsuario (Usuario novoUsuario){
		Optional <Usuario> usuarioExistente = repository.findByUsuario(novoUsuario.getUsuario());
		
		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repository.save(novoUsuario));
		}
		
	}
	
	/**
	 * Método utilizado para atualizar os campos de nome e senha do Usuario
	 * @param idUsuario - LongidUsuario
	 * @param atualizacaoUsuario - representa a Entidade Usuario
	 * @since 1.0
	 * @author Chelle
	 * @return Retorna um Optional com entidade Usuario caso o mesmo exista, do contrário um Optional vazio
	 */
	
	  public Optional <Usuario> atualizarUsuario (Long idUsuario, Usuario atualizacaoUsuario){
		  Optional<Usuario> usuarioExistente = repository.findById(idUsuario);
		  
		  if (usuarioExistente.isPresent()) {
			  usuarioExistente.get().setNome(atualizacaoUsuario.getNome());
			  usuarioExistente.get().setSenha(atualizacaoUsuario.getSenha());
			  return Optional.ofNullable(repository.save(usuarioExistente.get()));
		  } else {
			  return Optional.empty();
		  }
	  }
	  
		public Optional<Object> atualizarPost (Long idUsuario, Postagem atualizacaoPost){
			  Optional<Postagem> postExistente = repositoryP.findAllByTituloContaining(atualizacaoPost);
			  
			  if (postExistente.isPresent()) {
				  postExistente.get().setTitulo(atualizacaoPost.getTitulo());
				  return Optional.ofNullable(repositoryP.save(atualizacaoPost.getCriador()));
			  } else {
				  return Optional.empty();
			  }
		  }

}