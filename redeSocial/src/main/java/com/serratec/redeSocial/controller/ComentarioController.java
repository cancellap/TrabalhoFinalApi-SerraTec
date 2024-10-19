package com.serratec.redeSocial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.redeSocial.domain.Comentario;
import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.dto.ComentarioDTO;
import com.serratec.redeSocial.dto.PostagemDTO;
import com.serratec.redeSocial.repository.ComentarioRepository;
import com.serratec.redeSocial.repository.PostagemRepository;
import com.serratec.redeSocial.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private PostagemRepository postagemRepository;



	@PostMapping
	public ResponseEntity<Comentario> salvar(@RequestBody ComentarioDTO comentarioDTO) {
		return new ResponseEntity<>(comentarioService.save(comentarioDTO), HttpStatus.CREATED);
	}


}
