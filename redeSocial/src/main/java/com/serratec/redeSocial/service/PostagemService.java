package com.serratec.redeSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.repository.PostagemRepository;
import com.serratec.redeSocial.repository.UsuarioRepository;

@Service
public class PostagemService {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Postagem> findAll() {
		return postagemRepository.findAll();
	}
	
	public Postagem buscarPorId(Long id) {
        return postagemRepository.findById(id).orElse(null);
    }

	public Postagem savar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }
	
	public void deletarById(Long id) {
        postagemRepository.deleteById(id);
    }
	

}
