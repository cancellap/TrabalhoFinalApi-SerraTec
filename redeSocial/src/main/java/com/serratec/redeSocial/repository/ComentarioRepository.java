package com.serratec.redeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.redeSocial.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
	
	List<Comentario> findByPostId(Long postId);

}
