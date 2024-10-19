package com.serratec.redeSocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.serratec.redeSocial.domain.Comentario;
import com.serratec.redeSocial.dto.ComentarioDTO;
import com.serratec.redeSocial.repository.ComentarioRepository;

public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	
	public List<ComentarioDTO> findAll() {
		List<Comentario> comentarios = comentarioRepository.findAll();

		List<ComentarioDTO> comentariosDTO = comentarios.stream().map(ComentarioDTO::new).toList();

		return comentariosDTO;
	}
	
	public Optional<Comentario> buscar(Long id) {
		return comentarioRepository.findById(id);
	}
	
	@Transactional
	public ComentarioDTO inserir(ComentarioDTO comentarioDTO) {

		Comentario comentario = new Comentario();
		comentario.setTexto(comentarioDTO.getTexto());
		comentario.setIdUsuario(comentarioDTO.getIdUsuario());
		comentario.setDataCriacao(comentarioDTO.getDataCriacao());
		comentario.setPostagem(comentarioDTO.getPostagem());
		

		comentario = comentarioRepository.save(comentario);

		ComentarioDTO comentarios = new ComentarioDTO(comentario);
		return comentarios;
	}
}
