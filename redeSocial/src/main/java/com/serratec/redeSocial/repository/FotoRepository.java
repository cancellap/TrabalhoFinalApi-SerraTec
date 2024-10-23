package com.serratec.redeSocial.repository;

import com.serratec.redeSocial.domain.Foto;
import com.serratec.redeSocial.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

    Optional<Foto> findByUsuario(Usuario usuario);
}
