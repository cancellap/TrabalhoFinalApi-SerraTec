package com.serratec.redeSocial.dto;

public class PostagemDTO {

	private String titulo;

	private String conteudo;

	private Long idUsuario;

	public PostagemDTO() {}
	
	public PostagemDTO(String titulo, String conteudo, Long idUsuario) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.idUsuario = idUsuario;
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

}
