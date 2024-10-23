package com.serratec.redeSocial.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.serratec.redeSocial.domain.Foto;
import com.serratec.redeSocial.domain.Relacionamento;
import com.serratec.redeSocial.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.dto.UsuarioDTO;
import com.serratec.redeSocial.dto.UsuarioInserirDTO;
import com.serratec.redeSocial.repository.UsuarioRepository;
import com.serratec.redeSocial.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FotoService fotoService;

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> listarPaginado(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5)
            Pageable pageable) {
        Page<UsuarioDTO> usuarios = usuarioService.findAll(pageable);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscar(@PathVariable Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioOpt.get());
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/foto")
    public ResponseEntity<byte[]> buscarFoto(@PathVariable long id) {
        Foto foto = fotoService.buscarUsuarioPorId(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, foto.getTipo());
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(foto.getDados().length));

        return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);

    }

	@PostMapping("/seguir/{id}")
    public ResponseEntity<Relacionamento> inserirRelacionamento(@PathVariable Long id) {

        usuarioService.seguir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/seguir/{id}")
    public ResponseEntity<Set<UsuarioDTO>> buscarSeguidores(@PathVariable Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Set<UsuarioDTO> teste = usuarioOpt.get().getRelacionamentoSeguidores().stream()
                    .map(i -> new UsuarioDTO(i.getRelacionamentoPK().getSeguido()))
                    .collect(Collectors.toSet());
            System.out.println(usuarioOpt.get().getRelacionamentoSeguidores().size());
            System.out.println(usuarioOpt.get().getRelacionamentoSeguindo().size());

            return ResponseEntity.ok(teste);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity <UsuarioDTO> inserir(@RequestPart MultipartFile file, @RequestPart UsuarioInserirDTO usuarioInserirDTO) throws IOException {
        return ResponseEntity.ok(usuarioService.inserirFoto(usuarioInserirDTO, file));
    }


    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir(@Valid @RequestBody UsuarioInserirDTO usuarioInserirDTO) {
        UsuarioDTO usuarioDTO = usuarioService.inserir(usuarioInserirDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> alterar(@PathVariable Long id, @RequestBody UsuarioInserirDTO usuarioInserirDTO) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        UsuarioDTO usuarioDTO = usuarioService.alterarUsuario(usuarioInserirDTO, id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
