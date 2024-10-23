package com.serratec.redeSocial.service;

import com.serratec.redeSocial.domain.RelacionamentoPK;
import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.repository.RelacionamentoPKRepository;
import com.serratec.redeSocial.repository.RelacionamentoRepository;
import com.serratec.redeSocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class RelacionamentoPKService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RelacionamentoPKRepository relacionamentoPKRepository;

    public RelacionamentoPK criaPK(Usuario usuarioPrincipal, Usuario usuarioSecundario) {

//        Optional<Usuario> usuarioPrincipal = usuarioRepository.findById(idPrincipal);
//        Optional<Usuario> usuarioSecundario = usuarioRepository.findById(idSecundario);
//        if (usuarioPrincipal.isPresent() && usuarioSecundario.isPresent()) {

            RelacionamentoPK relacionamentoPK = new RelacionamentoPK(usuarioPrincipal, usuarioSecundario);

            return relacionamentoPK;



    }



}
