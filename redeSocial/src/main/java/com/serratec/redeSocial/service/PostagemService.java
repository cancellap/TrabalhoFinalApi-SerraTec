package com.serratec.redeSocial.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.dto.PostagemDTO;
import com.serratec.redeSocial.repository.PostagemRepository;
import com.serratec.redeSocial.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Page<PostagemDTO> findAll(Pageable pageable) {
		Page<Postagem> postagens = postagemRepository.findAll(pageable);
		return postagens.map(PostagemDTO:: new);
	}

	public List<Postagem> getAllPorUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado ╥﹏╥"));
		return postagemRepository.findAllByUsuarioId(usuario.getId());
	}

	public Postagem getById(Long id) {
		return postagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Postagem não encontrada ╥﹏╥"));
	}

	public Postagem createPost(PostagemDTO postagemDTO) {
		Usuario usuario = usuarioRepository.findById(postagemDTO.getIdUsuario())
				.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado ╥﹏╥"));

		Postagem postagem = new Postagem();
		postagem.setTitulo(postagemDTO.getTitulo());
		postagem.setDataCriacao(LocalDate.now());
		postagem.setConteudo(postagemDTO.getConteudo());
		postagem.setUsuario(usuario);
		postagemDTO.setDataCriacao(postagem.getDataCriacao());
		postagemRepository.save(postagem);
		usuario.getPostagens().add(postagem);
		return postagem;
	}

	public void delete(Long id) {
		postagemRepository.deleteById(id);
	}

}
