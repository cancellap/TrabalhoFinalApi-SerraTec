package com.serratec.redeSocial.dto;

import java.time.LocalDate;

import com.serratec.redeSocial.domain.Comentario;

public class ComentarioDTO {

	private Long idUsuario;

	private String texto;

	private LocalDate dataCriacao;

	private Long postagemId;

	public ComentarioDTO() {
	}

	public ComentarioDTO(Comentario comentario) {
		this.idUsuario = comentario.getUsuario().getId();
		this.texto = comentario.getTexto();
		this.dataCriacao = comentario.getDataCriacao();
		this.postagemId = comentario.getPostagem().getId();
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

	public Long getPostagemId() {
		return postagemId;
	}

	public void setPostagemId(Long postagemId) {
		this.postagemId = postagemId;
	}

}