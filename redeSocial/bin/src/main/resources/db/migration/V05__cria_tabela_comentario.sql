CREATE TABLE comentario
(
    id          serial PRIMARY KEY,
    usuario_id  bigint,
    postagem_id bigint,
    texto       VARCHAR(100),
    data_criacao DATE DEFAULT CURRENT_DATE,
    foreign key (usuario_id) references usuario (usuario_id),
    foreign key (postagem_id) references postagem (id)
)