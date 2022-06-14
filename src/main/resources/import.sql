INSERT INTO tb_client (name) VALUES ('Alex');
INSERT INTO tb_client (name) VALUES ('Maria');
INSERT INTO tb_client (name) VALUES ('Paulo');
INSERT INTO tb_client (name) VALUES ('Tomas');
INSERT INTO tb_client (name) VALUES ('Ana');
INSERT INTO tb_client (name) VALUES ('Marcos');

INSERT INTO tb_secretaria (nome)  VALUES ('Gabinete do Prefeito')
INSERT INTO tb_secretaria (nome)  VALUES ('Secretaria de Saúde')
INSERT INTO tb_secretaria (nome)  VALUES ('Secretaria de Educação')
INSERT INTO tb_secretaria (nome)  VALUES ('Secretaria de Meio Ambiente')
INSERT INTO tb_secretaria (nome)  VALUES ('Secretaria de Infraestrutura')
INSERT INTO tb_secretaria (nome)  VALUES ('Secretaria de Assistência Social')

INSERT INTO tb_tipo_servico (nome) VALUES ('Consulta')
INSERT INTO tb_tipo_servico (nome) VALUES ('Exame')

INSERT INTO tb_agendamento (id_secretaria, tipo_servico, data)  VALUES (1, 1, now())
INSERT INTO tb_agendamento (id_secretaria, tipo_servico, data)  VALUES (2, 2, now())

INSERT INTO tb_comentario_cidadao (comentario) VALUES ('Comentario 1')
INSERT INTO tb_comentario_cidadao (comentario) VALUES ('Comentario 2')

INSERT INTO tb_usuario(nome, matricula, senha) VALUES ('Usuario 1', '30010','$2a$10$Gu2vZxbx3yiOXTM8xyNV/u7npdHfYPgj1PylGDsM/Q/VZ8yx238Oi')
