package com.serratec.redeSocial.domain;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@JsonBackReference
	@ManyToOne // Muitos comentários para uma postagem
	@JoinColumn(name = "postagem_id")
	private Postagem postagem;

	private String texto;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
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
		Comentario other = (Comentario) obj;
		return Objects.equals(id, other.id);
	}

}
