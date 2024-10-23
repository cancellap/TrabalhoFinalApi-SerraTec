package com.serratec.redeSocial.domain;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails, Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;

	@Column(name = "nome_usuario", nullable = false)
	private String nome;

	@Column(name = "sobrenome_usuario", nullable = false)
	private String sobrenome;

	@Column(name = "email_usuario", nullable = false)
	private String email;

	@Column(name = "senha_usuario", nullable = false)
	private String senha;

	@Column
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "relacionamentoPK.seguidor", cascade = CascadeType.ALL)
	private Set<Relacionamento> relacionamentoSeguidores = new HashSet<>();

	@OneToMany(mappedBy = "relacionamentoPK.seguido", cascade = CascadeType.ALL)
	private Set<Relacionamento> relacionamentoSeguindo = new HashSet<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Postagem> postagens;

	public Usuario(Long id, @NotBlank(message = "Nome do usuario deve ser preenchido") String nome,
			@NotBlank(message = "Sobrenome do usuario deve ser preenchido") String sobrenome,
			@NotBlank(message = "E-mail do usuario deve ser preenchido") String email,
			@NotBlank(message = "Senha do usuario deve ser preenchida") String senha, LocalDate dataNascimento,
			Set<Relacionamento> relacionamentoSeguidores, Set<Relacionamento> relacionamentoSeguindo,
			List<Postagem> postagens) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.relacionamentoSeguidores = relacionamentoSeguidores;
		this.relacionamentoSeguindo = relacionamentoSeguindo;
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

	public Set<Relacionamento> getRelacionamentoSeguidores() {
		return relacionamentoSeguidores;
	}

	public void setRelacionamentoSeguidores(Set<Relacionamento> relacionamentoSeguidores) {
		this.relacionamentoSeguidores = relacionamentoSeguidores;
	}

	public Set<Relacionamento> getRelacionamentoSeguindo() {
		return relacionamentoSeguindo;
	}

	public void setRelacionamentoSeguindo(Set<Relacionamento> relacionamentoSeguindo) {
		this.relacionamentoSeguindo = relacionamentoSeguindo;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}
}