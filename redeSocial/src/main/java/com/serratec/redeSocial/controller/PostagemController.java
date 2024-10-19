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
import com.serratec.redeSocial.service.PostagemService;

@RestController
@RequestMapping("/post")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;

	@GetMapping
	public ResponseEntity<List<Postagem>> listar() {
		return ResponseEntity.ok(postagemService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> buscar() {
		return ResponseEntity.ok(postagemService.buscarPorId(1L));
	}

	@PostMapping
	public ResponseEntity<Postagem> salvar(@RequestBody Postagem postagem) {
		return new ResponseEntity<>(postagemService.salvar(postagem), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		postagemService.deletarById(id);
		return ResponseEntity.noContent().build();
	}
}
