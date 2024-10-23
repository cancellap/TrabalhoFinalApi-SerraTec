package com.serratec.redeSocial.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serratec.redeSocial.domain.Comentario;
import com.serratec.redeSocial.dto.ComentarioDTO;
import com.serratec.redeSocial.dto.UsuarioDTO;
import com.serratec.redeSocial.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	@GetMapping
	public ResponseEntity<Page<ComentarioDTO>> listarPaginado(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 40)
			Pageable pageable) {
		Page<ComentarioDTO> comentarios = comentarioService.findAll(pageable);
		return ResponseEntity.ok(comentarios);
	}

	@PostMapping
	public ResponseEntity<ComentarioDTO> salvar(@RequestBody ComentarioDTO comentarioDTO) {
		Comentario comment = comentarioService.addComment(comentarioDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/comentarios/{id}")
				.buildAndExpand(comment.getId()).toUri();
		return ResponseEntity.created(uri).body(comentarioDTO);
	}

}
