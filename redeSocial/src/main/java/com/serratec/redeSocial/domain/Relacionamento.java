package com.serratec.redeSocial.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
public class Relacionamento {

	@EmbeddedId
	private RelacionamentoPK relacionamentoPK = new RelacionamentoPK();

	@Column(name = "data_de_inicio")

	private LocalDate dataDeInicio;

	public Relacionamento(RelacionamentoPK relacionamentoPK, LocalDate dataDeInicio) {
		this.relacionamentoPK = relacionamentoPK;
		this.dataDeInicio = dataDeInicio;
	}

	public Relacionamento() {

	}

	public RelacionamentoPK getRelacionamentoPK() {
		return relacionamentoPK;
	}

	public void setRelacionamentoPK(RelacionamentoPK relacionamentoPK) {
		this.relacionamentoPK = relacionamentoPK;
	}

	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

}
