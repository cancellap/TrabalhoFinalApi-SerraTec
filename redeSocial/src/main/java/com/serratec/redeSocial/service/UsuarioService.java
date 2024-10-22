package com.serratec.redeSocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.dto.UsuarioDTO;
import com.serratec.redeSocial.dto.UsuarioInserirDTO;
import com.serratec.redeSocial.exception.EmailException;
import com.serratec.redeSocial.exception.SenhaException;
import com.serratec.redeSocial.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::new).toList();

		return usuariosDTO;
	}

	public Optional<Usuario> buscar(Long id) {
		return usuarioRepository.findById(id);
	}

	@Transactional
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) {

		if (!usuarioInserirDTO.getSenha().equals(usuarioInserirDTO.getSenhaConfirma())) {
			throw new SenhaException("Senhas não coincidem.");
		}
		if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()).isPresent()) {
			throw new EmailException("Email já existente.");
		}

		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setSobrenome(usuarioInserirDTO.getSobrenome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(encoder.encode(usuarioInserirDTO.getSenha()));
		usuario.setDataNascimento(usuarioInserirDTO.getDataNascimento());

		usuario = usuarioRepository.save(usuario);

		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDTO;
	}

}