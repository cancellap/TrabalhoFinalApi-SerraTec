package com.serratec.redeSocial.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_usuario")
	private String nome;

	@Column(name = "sobrenome_usuario")
	private String sobrenome;

	@Column(name = "email_usuario")
	private String email;

	@Column(name = "senha_usuario")
	private String senha;

	@Column
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "seguidor", cascade = CascadeType.ALL)
	private Set<Relacionamento> seguidor;

	@OneToMany(mappedBy = "seguido", cascade = CascadeType.ALL)
	private Set<Relacionamento> seguido;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Postagem> postagens;

	public Usuario(Long id, String nome, String sobrenome, String email, String senha, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
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


	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;

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

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, email, id, nome, seguido, seguidor, senha, sobreNome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(seguido, other.seguido) && Objects.equals(seguidor, other.seguidor)
				&& Objects.equals(senha, other.senha) && Objects.equals(sobreNome, other.sobreNome);
	}

	

}
