package com.serratec.redeSocial.dto;

import java.time.LocalDate;

import com.serratec.redeSocial.domain.Postagem;

public class PostagemDTO {

	private String titulo;

	private String conteudo;

	private Long idUsuario;

	private LocalDate dataCriacao;

	public PostagemDTO() {
	}

	public PostagemDTO(Postagem postagem) {
		super();
		this.titulo = postagem.getTitulo();
		this.conteudo = postagem.getConteudo();
		this.idUsuario = postagem.getUsuario().getId();
		this.dataCriacao = postagem.getDataCriacao();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
