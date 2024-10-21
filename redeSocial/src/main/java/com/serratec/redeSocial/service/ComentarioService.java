package com.serratec.redeSocial.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serratec.redeSocial.domain.Comentario;
import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.domain.Relacionamento;
import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.dto.ComentarioDTO;
import com.serratec.redeSocial.repository.ComentarioRepository;
import com.serratec.redeSocial.repository.PostagemRepository;
import com.serratec.redeSocial.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PostagemRepository postagemRepository;

	@Transactional
	public Comentario addComment(ComentarioDTO comentarioDTO) {

		Postagem post = postagemRepository.findById(comentarioDTO.getPostagemId())
				.orElseThrow(() -> new EntityNotFoundException("Postagem não encontrada"));

		Usuario usuario = usuarioRepository.findById(comentarioDTO.getIdUsuario())
				.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

//		if (!usuario.getRelacionamentoSeguidores().contains(post.getUsuario().getId())) {
//			throw new IllegalArgumentException("Você precisa seguir o autor para comentar nesta postagem");
//		}

		for (Relacionamento i : usuario.getRelacionamentoSeguidores()) {
			if (!i.getRelacionamentoPK().getSeguidor().getRelacionamentoSeguidores()
					.contains(post.getUsuario().getId())) {
				throw new IllegalArgumentException("Você precisa seguir o autor para comentar nesta postagem");
			}
		}

		Comentario comentario = new Comentario();
		comentario.setTexto(comentarioDTO.getTexto());
		comentario.setDataCriacao(LocalDate.now());
		comentario.setPostagem(post);
		comentario.setUsuario(usuario);
		comentarioDTO.setDataCriacao(comentario.getDataCriacao());
//		comentarioDTO.getIdUsuario().get
		comentarioRepository.save(comentario);
		return comentario;
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
