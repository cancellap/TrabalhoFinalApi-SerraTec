CREATE TABLE postagem (id serial PRIMARY KEY,
                      titulo VARCHAR(50),
                      conteudo VARCHAR(100),
                      data_criacao DATE DEFAULT CURRENT_DATE,
                      usuario_id bigint,
                      foreign key (usuario_id) references usuario(usuario_id))