package com.serratec.redeSocial.dto;

import java.time.LocalDate;

import com.serratec.redeSocial.domain.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String sobreNome;
	private String email;
	private LocalDate dataNascimento;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario usuario) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
