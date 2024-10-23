package com.serratec.redeSocial.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class UsuarioInserirDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;

	@NotBlank(message = "Nome do usuario deve ser preenchido")
	@Column(name = "nome_usuario", nullable = false)
	private String nome;

	@NotBlank(message = "Sobrenome do usuario deve ser preenchido")
	@Column(name = "sobrenome_usuario", nullable = false)
	private String sobrenome;

	@NotBlank(message = "E-mail do usuario deve ser preenchido")
	@Column(name = "email_usuario", nullable = false)
	private String email;

	@NotBlank(message = "Senha do usuario deve ser preenchida")
	@Column(name = "senha_usuario", nullable = false)
	private String senha;

	@NotBlank(message = "Senha do usuario deve ser preenchida")
	private String senhaConfirma;
//	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private String url;

	public UsuarioInserirDTO() {

	}

	public UsuarioInserirDTO(Long id, String nome, String sobrenome, String email, String senha, LocalDate dataNascimento ) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;

	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaConfirma() {
		return senhaConfirma;
	}

	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}