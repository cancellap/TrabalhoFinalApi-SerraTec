package com.serratec.redeSocial.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RelacionamentoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_principal")
	private Long idPrincipal;

	@ManyToOne
	@JoinColumn(name = "id_secundario")
	private Long IdSecundario;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdPrincipal() {
		return idPrincipal;
	}

	public void setIdPrincipal(Long idPrincipal) {
		this.idPrincipal = idPrincipal;
	}

	public Long getIdSecundario() {
		return IdSecundario;
	}

	public void setIdSecundario(Long idSecundario) {
		IdSecundario = idSecundario;
	}

	
}
