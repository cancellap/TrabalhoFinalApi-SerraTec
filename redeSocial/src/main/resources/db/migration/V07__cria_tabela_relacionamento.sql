CREATE TABLE relacionamento (
                                id_principal int references usuario (usuario_id),
                                id_secundario int references usuario (usuario_id),
                                data_criacao date DEFAULT CURRENT_DATE,
                                constraint pk_relacionamento primary key (id_principal, id_secundario));