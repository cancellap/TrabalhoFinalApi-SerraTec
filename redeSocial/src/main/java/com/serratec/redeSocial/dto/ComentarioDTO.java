package com.serratec.redeSocial.dto;

import java.time.LocalDate;

import com.serratec.redeSocial.domain.Comentario;
import com.serratec.redeSocial.domain.Postagem;

public class ComentarioDTO {

	private Long id;

	private Long idUsuario;

	private String texto;

	private LocalDate dataCriacao;

	private Postagem postagem;

	public ComentarioDTO() {
	}

	public ComentarioDTO(Comentario comentario) {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

}