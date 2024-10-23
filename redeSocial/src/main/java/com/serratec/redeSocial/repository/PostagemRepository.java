package com.serratec.redeSocial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serratec.redeSocial.domain.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	List<Postagem> findAllByUsuarioId(Long usuarioId);
	
	Optional<Postagem> findById(Postagem postagem);
	
	Page<Postagem> findAll(Pageable pageable);
}
