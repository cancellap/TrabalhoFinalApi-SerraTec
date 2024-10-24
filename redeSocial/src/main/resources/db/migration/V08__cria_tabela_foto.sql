create table foto (
                      id_foto serial primary key,
                      dados bytea,
                      tipo varchar(100),
                      nome varchar(100),
                      usuario_id bigint,
                      foreign key (usuario_id) references usuario(usuario_id))
