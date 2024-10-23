package com.serratec.redeSocial.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.dto.PostagemDTO;
import com.serratec.redeSocial.service.PostagemService;

@RestController
@RequestMapping("/post")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;

	@GetMapping
	public ResponseEntity<List<Postagem>> listarPostagem() {
		return ResponseEntity.ok(postagemService.getAllListar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(postagemService.getById(id));
	}

	@PostMapping
	public ResponseEntity<PostagemDTO> salvar(@RequestBody PostagemDTO postagemDTO) {
		Postagem post = postagemService.createPost(postagemDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/post/{id}")
				.buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).body(postagemDTO);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		postagemService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
