package com.serratec.redeSocial.service;


import com.serratec.redeSocial.domain.Foto;
import com.serratec.redeSocial.domain.Usuario;
import com.serratec.redeSocial.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public Foto inserirFoto (Usuario usuario, MultipartFile file) throws IOException {

        Foto foto = new Foto();
        foto.setNome(file.getName());
        foto.setTipo(file.getContentType());
        foto.setDados(file.getBytes());
        foto.setUsuario(usuario);

        return fotoRepository.save(foto);
    }

    @Transactional //Quando trabalhamos com objeto grande de dados vale a pena usar transactional para garantir o transporte do dado.
                    //Se der algum erro ele faz um row back
    public Foto buscarUsuarioPorId (Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        Optional<Foto> foto = fotoRepository.findByUsuario(usuario);
        if (foto.isEmpty()) {
            return null;
        }
        return foto.get();
    }
}
