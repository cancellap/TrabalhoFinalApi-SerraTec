package com.serratec.redeSocial.domain;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//	atribudos vindos do RelacionamentoPK atraves do EmbededId
//	
//	notacoes para join no banco de dados	
//	

@Entity
public class Relacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@EmbeddedId
	private RelacionamentoPK relacionamentoPK = new RelacionamentoPK();

	private LocalDate dataDeInicio;

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
