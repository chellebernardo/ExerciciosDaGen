package com.madamechelle.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private long idTema;
	
	@NotNull
	private String descricao;

	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("tema")
	private List<Postagem> postagem;

	public long getId() {
		return idTema;
	}

	public void setId(long idTema) {
		this.idTema = idTema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
