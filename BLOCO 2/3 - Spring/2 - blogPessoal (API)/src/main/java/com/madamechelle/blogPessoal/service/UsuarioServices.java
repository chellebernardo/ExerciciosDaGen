package com.madamechelle.blogPessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madamechelle.blogPessoal.model.Postagem;
import com.madamechelle.blogPessoal.model.Tema;
import com.madamechelle.blogPessoal.model.Usuario;
import com.madamechelle.blogPessoal.repository.PostagemRepository;
import com.madamechelle.blogPessoal.repository.TemaRepository;
import com.madamechelle.blogPessoal.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PostagemRepository repositoryP;
	@Autowired
	private TemaRepository repositoryT;

	/**
	 * Metodo utilizado para cadastrar um usuario no sistema, validando sua
	 * existencia.
	 * 
	 * @param novoUsuario
	 * @since 1.0
	 * @author Chelle
	 * @return Optional com entidade Usuario dentro ou Optional vazio.
	 */

	public Optional<Usuario> cadastrarUsuario(Usuario novoUsuario) {
		Optional<Usuario> usuarioExistente = repository.findByUsuario(novoUsuario.getUsuario());

		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repository.save(novoUsuario));
		}

	}

	/**
	 * Método utilizado para atualizar os campos de nome e senha do Usuario
	 * 
	 * @param idUsuario          - LongidUsuario
	 * @param atualizacaoUsuario - representando a Entidade Usuario
	 * @since 1.0
	 * @author Chelle
	 * @return Retorna um Optional com entidade Usuario caso o mesmo exista, do
	 *         contrário um Optional vazio
	 */

	public Optional<Usuario> atualizarUsuario(Long idUsuario, Usuario atualizacaoUsuario) {
		Optional<Usuario> usuarioExistente = repository.findById(idUsuario);

		if (usuarioExistente.isPresent()) {
			usuarioExistente.get().setNome(atualizacaoUsuario.getNome());
			usuarioExistente.get().setSenha(atualizacaoUsuario.getSenha());
			return Optional.ofNullable(repository.save(usuarioExistente.get()));
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Método utilizado para atualizar Título e Texto de postagens existentes.
	 * @param idPostagem - Long
	 * @param atualizacaoPost - representando Entidade Postagem
	 * @since 1.0
	 * @author Chelle
	 * @return Retorna um Optional com entidade Postagem caso exista,
	 * se não existir retorna um Optional vazio.
	 */
	public Optional <Postagem> atualizarPost (Long idPostagem, Postagem atualizacaoPost){
		Optional <Postagem> postExistente = repositoryP.findPostById(idPostagem);
		
		if (postExistente.isPresent()) {
			postExistente.get().setTitulo(atualizacaoPost.getTitulo());
			postExistente.get().setTexto(atualizacaoPost.getTexto());
			return Optional.ofNullable(repositoryP.save(atualizacaoPost));
		} else {
			return Optional.empty();
		}
	}
	/**
	 * Método utilizado para cadastrar um novo Tema caso o mesmo ainda não exista.
	 * @param idTema - Long
	 * @param novoTema - representando a Entidade Tema.
	 * @since 1.0
	 * @author Chelle
	 * @return Retorna um Optional vazio se o Tema existir. Se não o Tema ainda não
	 * existir, retorna um Optional que permite o novo cadastro.
	 */
	public Optional<Tema> cadastrarTema (Long idTema, Tema novoTema) {
		Optional <Tema> temaExistente = repositoryT.findByDescricao(novoTema.getDescricao());
		
		if (temaExistente.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repositoryT.save(novoTema));
		}
	}

	/**
	 * Método utilizado para atualizar um Tema existente no Banco de Dados.
	 * 
	 * @param idTema          - Long
	 * @param atualizacaoTema - respresentando a Entidade Tema.
	 * @since 1.0
	 * @author Chelle
	 * @return Retorna um Optional com a entidade Tema se ela existir, se não
	 *         existir retorna um Optional vazio.
	 */
	public Optional<Tema> atualizarTema(Long idTema, Tema atualizacaoTema) {
		Optional<Tema> temaExistente = repositoryT.findByTemaId(idTema);

		if (temaExistente.isPresent()) {
			temaExistente.get().setDescricao(atualizacaoTema.getDescricao());
			return Optional.ofNullable(repositoryT.save(atualizacaoTema));
		} else {
			return Optional.empty();
		}

	}
}