package com.serratec.redeSocial.repository;

import com.serratec.redeSocial.domain.RelacionamentoPK;
import com.serratec.redeSocial.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacionamentoPKRepository extends JpaRepository<RelacionamentoPK, Usuario> {
}
