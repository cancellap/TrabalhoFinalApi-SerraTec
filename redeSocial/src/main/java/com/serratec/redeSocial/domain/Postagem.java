package com.serratec.redeSocial.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String conteudo;

	private LocalDate dataCriacao;

	//Uma postagem para
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
	private Set<Comentario> comentarios = new HashSet<>();

	//Relação de muitos para um postagem e usuário. Não sei se precisaremos das anotações JsonBackReference e IgnoreJson
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Postagem(Long id, String conteudo, LocalDate dataCriacao) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.dataCriacao = dataCriacao;
	}

	public Postagem() {
		super();
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	@OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postagem other = (Postagem) obj;
		return Objects.equals(id, other.id);
	}

}
