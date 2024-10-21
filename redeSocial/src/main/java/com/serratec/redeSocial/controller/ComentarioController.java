package com.serratec.redeSocial.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serratec.redeSocial.domain.Comentario;
import com.serratec.redeSocial.dto.ComentarioDTO;
import com.serratec.redeSocial.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;

	@PostMapping
	public ResponseEntity<ComentarioDTO> salvar(@RequestBody ComentarioDTO comentarioDTO) {
		Comentario comment = comentarioService.addComment(comentarioDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/comentarios/{id}")
				.buildAndExpand(comment.getId()).toUri();
		return ResponseEntity.created(uri).body(comentarioDTO);
	}

}
