package com.serratec.redeSocial.domain;

import java.time.LocalDate;
import java.util.List;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "seguidor", cascade = CascadeType.ALL)
	private Set<Relacionamento> seguidor;

	@OneToMany(mappedBy = "seguido", cascade = CascadeType.ALL)
	private Set<Relacionamento> seguido;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Postagem> postagens;

	public Usuario(Long id, @NotBlank(message = "Nome do usuario deve ser preenchido") String nome,
			@NotBlank(message = "Sobrenome do usuario deve ser preenchido") String sobrenome,
			@NotBlank(message = "E-mail do usuario deve ser preenchido") String email,
			@NotBlank(message = "Senha do usuario deve ser preenchida") String senha, LocalDate dataNascimento,
			Set<Relacionamento> seguidor, Set<Relacionamento> seguido, List<Postagem> postagens) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.seguidor = seguidor;
		this.seguido = seguido;
		this.postagens = postagens;
	}

	public Usuario() {
		super();
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Relacionamento> getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(Set<Relacionamento> seguidor) {
		this.seguidor = seguidor;
	}

	public Set<Relacionamento> getSeguido() {
		return seguido;
	}

	public void setSeguido(Set<Relacionamento> seguido) {
		this.seguido = seguido;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

}