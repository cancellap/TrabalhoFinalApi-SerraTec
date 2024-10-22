
CREATE TABLE usuario (usuario_id serial PRIMARY KEY,
                      nome_usuario VARCHAR(50),
                      sobrenome_usuario VARCHAR(50),
                      email_usuario VARCHAR(255),
                      senha_usuario VARCHAR(255),
                         data_nascimento DATE)