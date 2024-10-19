package com.serratec.redeSocial.domain;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//	atribudos vindos do RelacionamentoPK atraves do EmbededId
//	
//	notacoes para join no banco de dados	
//	


public class Relacionamento {

	private LocalDate dataDeInicio1;
	@EmbeddedId
	private RelacionamentoPK relacionamentoPK = new RelacionamentoPK();

	@ManyToOne
	@JoinColumn(name = "id_principal")
	private Long idPrincipal;

	@ManyToOne
	@JoinColumn(name = "id_secundario")
	private Long IdSecundario;

	@Column
	private LocalDate dataDeInicio;

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
		return dataDeInicio1;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio1 = dataDeInicio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IdSecundario, dataDeInicio1, idPrincipal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relacionamento other = (Relacionamento) obj;
		return Objects.equals(IdSecundario, other.IdSecundario) && Objects.equals(dataDeInicio1, other.dataDeInicio1)
				&& Objects.equals(idPrincipal, other.idPrincipal);
	}

}
