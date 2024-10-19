package com.serratec.redeSocial.domain;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//	atribudos vindos do RelacionamentoPK atraves do EmbededId
//	
//	notacoes para join no banco de dados	
//	

@Entity
public class Relacionamento {

	private LocalDate dataDeInicio;
	@EmbeddedId
	private RelacionamentoPK relacionamentoPK = new RelacionamentoPK();

	@ManyToOne
	@JoinColumn(name = "id_principal")
	private Long idPrincipal;

	@ManyToOne
	@JoinColumn(name = "id_secundario")
	private Long IdSecundario;

	public RelacionamentoPK getRelacionamentoPK() {
		return relacionamentoPK;
	}

	public void setRelacionamentoPK(RelacionamentoPK relacionamentoPK) {
		this.relacionamentoPK = relacionamentoPK;
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

	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

}
