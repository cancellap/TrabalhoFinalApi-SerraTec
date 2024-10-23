package com.serratec.redeSocial.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.serratec.redeSocial.domain.Relacionamento;
import com.serratec.redeSocial.domain.RelacionamentoPK;
import com.serratec.redeSocial.repository.RelacionamentoRepository;
import com.serratec.redeSocial.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.dto.UsuarioDTO;
import com.serratec.redeSocial.dto.UsuarioInserirDTO;
import com.serratec.redeSocial.exception.EmailException;
import com.serratec.redeSocial.exception.SenhaException;
import com.serratec.redeSocial.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private RelacionamentoPKService relacionamentoPKService;

	@Autowired
	private RelacionamentoRepository relacionamentoRepository;

	@Autowired
	private FotoService fotoService;

	public Page<UsuarioDTO> findAll(Pageable pageable) {
		Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
		return usuarios.map(UsuarioDTO::new);
	}

//    public Optional<Usuario> buscar(Long id) {
//        return usuarioRepository.findById(id);
//    }

	@Transactional
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) {

		if (!usuarioInserirDTO.getSenha().equals(usuarioInserirDTO.getSenhaConfirma())) {
			throw new SenhaException("Senhas não coincidem ╥﹏╥");
		}
		if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()).isPresent()) {
			throw new EmailException("Email já existente ╥﹏╥");
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

	public UsuarioDTO alterarUsuario(UsuarioInserirDTO usuarioInserirDTO, Long id) {

		Usuario user = new Usuario();
		user.setId(id);
		user.setNome(usuarioInserirDTO.getNome());
		user.setSobrenome(usuarioInserirDTO.getSobrenome());
		user.setEmail(usuarioInserirDTO.getEmail());
		user.setSenha(encoder.encode(usuarioInserirDTO.getSenha()));
		user.setDataNascimento(usuarioInserirDTO.getDataNascimento());
		user = usuarioRepository.save(user);
		UsuarioDTO usuarioDTO = new UsuarioDTO(user);

		return usuarioDTO;

	}

	public Relacionamento seguir(Long idSecundario) {

		String token = httpServletRequest.getHeader("Authorization");
		token = token.substring(7);

		String email = jwtUtil.getUserName(token);
		Long id = usuarioRepository.findByEmail(email).get().getId();

		Relacionamento relacionamento = new Relacionamento(relacionamentoPKService.criaPK(id, idSecundario),
				LocalDate.now());

		relacionamentoRepository.save(relacionamento);

		return relacionamento;
	}

	public UsuarioDTO inserirFoto(UsuarioInserirDTO usuarioInserirDTO, MultipartFile file) throws IOException {

		Usuario usuario = new Usuario();

		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setSobrenome(usuarioInserirDTO.getSobrenome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(encoder.encode(usuarioInserirDTO.getSenha()));
		usuario.setDataNascimento(usuarioInserirDTO.getDataNascimento());

		usuario = usuarioRepository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuarios/{id}/foto")
				.buildAndExpand(usuario.getId()).toUri();
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		usuarioDTO.setUrl(uri.toString());
		fotoService.inserir(usuario, file);
		adicionarFotoUri(usuario);

		return usuarioDTO;
	}

	public UsuarioDTO adicionarFotoUri(Usuario usuario) {

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuarios/{id}/foto")
				.buildAndExpand(usuario.getId()).toUri();

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNome(usuario.getNome());
		usuarioDTO.setSobrenome(usuario.getSobrenome());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setDataNascimento(usuario.getDataNascimento());
		usuarioDTO.setUrl(uri.toString());

		return usuarioDTO;

	}

	// Convertando usuario em usuarioInserirDTO e pega a foto
	public List<UsuarioDTO> listar() {
		List<UsuarioDTO> usuarios = usuarioRepository.findAll().stream().map(u -> adicionarFotoUri(u)).toList();
		return usuarios;
	}


        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setSobrenome(usuario.getSobrenome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioDTO.setUrl(uri.toString());

        return usuarioDTO;


    }

    //Convertando usuario em usuarioInserirDTO e pega a foto
    public List<UsuarioDTO> listar() {
        List<UsuarioDTO> usuarios = usuarioRepository.findAll().stream().map(u -> adicionarFotoUri(u)).toList();
        return usuarios;
    }

    public UsuarioDTO buscar(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            return null;
        }
        return adicionarFotoUri(usuarioOpt.get());
    }

}