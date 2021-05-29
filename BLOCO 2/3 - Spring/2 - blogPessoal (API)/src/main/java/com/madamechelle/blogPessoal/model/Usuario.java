package com.madamechelle.blogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Usuario {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long idUsuario;
	private @NotNull (message = "Precisa ter um nome!")String nome;
	
	@NotNull (message = "Aqui precisa ter um usuário válido!")
	@Size (min = 3, max = 15, message = "User entre 3 e 15")
	private String usuario;
	
	private @NotNull (message = "A senha não pode ser nula, please!")String senha;
	private String tipo;
	
	@OneToMany (mappedBy = "criador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties ({"criador"})
	private List <Postagem> minhasPostagens = new ArrayList<>();
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Postagem> getMinhasPostagens() {
		return minhasPostagens;
	}
	public void setMinhasPostagens(List<Postagem> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}
	
	
	
}
