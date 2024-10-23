package com.serratec.redeSocial.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Long idFoto;

    @Lob
    @JdbcTypeCode(Types.BINARY) //s
    private byte [] dados;

    private String tipo;

    private String nome;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public Foto() {}

    public Foto(Long idFoto, byte[] dados, String tipo, String nome, Usuario usuario) {
        this.idFoto = idFoto;
        this.dados = dados;
        this.tipo = tipo;
        this.nome = nome;
        this.usuario = usuario;
    }

    public Long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Long idFoto) {
        this.idFoto = idFoto;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


