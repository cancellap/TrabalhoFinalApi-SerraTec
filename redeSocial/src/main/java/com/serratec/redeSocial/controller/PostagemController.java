package com.serratec.redeSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.redeSocial.domain.Postagem;
import com.serratec.redeSocial.dto.PostagemDTO;
import com.serratec.redeSocial.repository.PostagemRepository;
import com.serratec.redeSocial.service.PostagemService;

@RestController
@RequestMapping("/post")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;
	
	@Autowired
	private PostagemRepository postagemRepository;

	@GetMapping
	public ResponseEntity<List<Postagem>> listarPostagem() {
		return ResponseEntity.ok(postagemService.getAllListar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(postagemService.getById(1L));
	}

	@PostMapping
	public ResponseEntity<Postagem> salvar(@RequestBody PostagemDTO postagemDTO) {
		return new ResponseEntity<>(postagemService.save(postagemDTO), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		postagemService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
