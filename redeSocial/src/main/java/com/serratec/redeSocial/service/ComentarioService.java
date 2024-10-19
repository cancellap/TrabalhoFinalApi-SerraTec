package com.serratec.redeSocial.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.serratec.redeSocial.domain.Comentario;
import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.dto.ComentarioDTO;
import com.serratec.redeSocial.repository.ComentarioRepository;
import com.serratec.redeSocial.repository.PostagemRepository;
import com.serratec.redeSocial.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PostagemRepository postagemRepository;

	public Comentario addComment(ComentarioDTO comentarioDTO) {
		Postagem post = postagemRepository.findById(comentarioDTO.getPostagem())
				.orElseThrow(() -> new EntityNotFoundException("Postagem não encontrada"));
		Usuario usuario = usuarioRepository.findById(comentarioDTO.getIdUsuario())
				.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

		if (!usuario.getseguidores().contains(post.getUsuario())) {
			throw new IllegalArgumentException("Você precisa seguir o autor para comentar nesta postagem");
		}

		Comentario comentario = new Comentario();
		comentario.setTexto(comentarioDTO.getPostagem());
		comentario.setPostagem(post);
		comentario.setIdUsuario(usuario);

		return comentarioRepository.save(comentario);
	}

	/*
	 * public List<ComentarioDTO> findAll() { List<Comentario> comentarios =
	 * comentarioRepository.findAll();
	 * 
	 * List<ComentarioDTO> comentariosDTO =
	 * comentarios.stream().map(ComentarioDTO::new).toList();
	 * 
	 * return comentariosDTO; }
	 * 
	 * public Optional<Comentario> buscar(Long id) { return
	 * comentarioRepository.findById(id); }
	 * 
	 * @Transactional public ComentarioDTO inserir(ComentarioDTO comentarioDTO) {
	 * 
	 * Comentario comentario = new Comentario();
	 * comentario.setTexto(comentarioDTO.getTexto());
	 * comentario.setIdUsuario(comentarioDTO.getIdUsuario());
	 * comentario.setDataCriacao(comentarioDTO.getDataCriacao());
	 * comentario.setPostagem(comentarioDTO.getPostagem());
	 * 
	 * 
	 * comentario = comentarioRepository.save(comentario);
	 * 
	 * ComentarioDTO comentarios = new ComentarioDTO(comentario); return
	 * comentarios; }
	 */
}
