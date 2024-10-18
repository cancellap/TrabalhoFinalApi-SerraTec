package com.serratec.redeSocial.domain;


import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class RelacionamentoPK {

	private Usuario idPrincipal;
	
	private Usuario idSecundario;

	public Usuario getIdPrincipal() {
		return idPrincipal;
	}

	public void setIdPrincipal(Usuario idPrincipal) {
		this.idPrincipal = idPrincipal;
	}

	public Usuario getIdSecundario() {
		return idSecundario;
	}

	public void setIdSecundario(Usuario idSecundario) {
		this.idSecundario = idSecundario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPrincipal, idSecundario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelacionamentoPK other = (RelacionamentoPK) obj;
		return Objects.equals(idPrincipal, other.idPrincipal) && Objects.equals(idSecundario, other.idSecundario);
	}
	
	

}
