package com.serratec.redeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.domain.Usuario;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	List<Postagem> findAllByUsuario(Long usuarioId);
}
