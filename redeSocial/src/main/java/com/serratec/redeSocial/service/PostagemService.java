package com.serratec.redeSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Postagem> getAllListar() {
		return postagemRepository.findAll();
	}

	public List<Postagem> getAllPorUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado ╥﹏╥"));
		return postagemRepository.findAllByUsuario(idUsuario);
	}

	public Postagem getById(Long id) {
		return postagemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Postagem não encontrada ╥﹏╥"));
	}

	public Postagem createPost(PostagemDTO postagemDTO) {
	    Usuario usuario = usuarioRepository.findById(postagemDTO.getIdUsuario())
	            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado ╥﹏╥"));

	    Postagem postagem = new Postagem();
	    postagem.setTitulo(postagemDTO.getTitulo());
	    postagem.setConteudo(postagemDTO.getConteudo());
	    postagem.setUsuario(usuario);

	    return postagemRepository.save(postagem);
	}

	public void delete(Long id) {
		postagemRepository.deleteById(id);
	}

}
