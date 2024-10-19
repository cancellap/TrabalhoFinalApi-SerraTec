package com.serratec.redeSocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serratec.redeSocial.domain.Relacionamento;
import com.serratec.redeSocial.domain.RelacionamentoPK;
import com.serratec.redeSocial.domain.Usuario;

@Repository
public interface RelacionamentoRepository extends JpaRepository<Relacionamento, RelacionamentoPK>{

	Optional<Usuario> findByRelacionamentoPK_Seguidor(Usuario seguidor);

}
