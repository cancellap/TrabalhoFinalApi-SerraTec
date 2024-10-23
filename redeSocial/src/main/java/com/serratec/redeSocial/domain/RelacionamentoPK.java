package com.serratec.redeSocial.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RelacionamentoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_principal")
	private Usuario seguidor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_secundario")
	private Usuario seguido;

	public RelacionamentoPK(Usuario seguidor, Usuario seguido) {
		this.seguidor = seguidor;
		this.seguido = seguido;
	}

	public RelacionamentoPK() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(Usuario seguidor) {
		this.seguidor = seguidor;
	}

	public Usuario getSeguido() {
		return seguido;
	}

	public void setSeguido(Usuario seguido) {
		this.seguido = seguido;
	}

}
