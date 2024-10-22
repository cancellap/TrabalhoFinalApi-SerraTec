package com.serratec.redeSocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serratec.redeSocial.domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	
	Optional<Comentario> findById(Long id);

}
