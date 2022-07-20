INSERT INTO tb_client (name) VALUES ('Alex');
INSERT INTO tb_client (name) VALUES ('Maria');
INSERT INTO tb_client (name) VALUES ('Paulo');
INSERT INTO tb_client (name) VALUES ('Tomas');
INSERT INTO tb_client (name) VALUES ('Ana');
INSERT INTO tb_client (name) VALUES ('Marcos');

INSERT INTO tb_secretaria (nome, descricao)  VALUES ('Gabinete do Prefeito', 'TEXTO 1')
INSERT INTO tb_secretaria (nome, descricao)  VALUES ('Secretaria de Saúde', 'TEXTO 2')
INSERT INTO tb_secretaria (nome, descricao)  VALUES ('Secretaria de Educação', 'TEXTO 3')
INSERT INTO tb_secretaria (nome, descricao)  VALUES ('Secretaria de Meio Ambiente', 'TEXTO 4')
INSERT INTO tb_secretaria (nome, descricao)  VALUES ('Secretaria de Infraestrutura', 'TEXTO 5')
INSERT INTO tb_secretaria (nome, descricao)  VALUES ('Secretaria de Assistência Social', 'TEXTO 6')

INSERT INTO tb_servico (nome, descricao, id_secretaria) VALUES ('Consulta', 'TESTE 1' , 1 )
INSERT INTO tb_servico (nome, descricao, id_secretaria) VALUES ('Exame', 'TESTE 1', 2)

INSERT INTO tb_agendamento (id_secretaria, id_servico, data, hora)  VALUES (1, 1, now(), now())
INSERT INTO tb_agendamento (id_secretaria, id_servico, data, hora)  VALUES (2, 2, now(), now())

INSERT INTO tb_comentario_cidadao (comentario) VALUES ('Comentario 1')
INSERT INTO tb_comentario_cidadao (comentario) VALUES ('Comentario 2')

INSERT INTO tb_usuario(nome, matricula, senha) VALUES ('Usuario 1', '30010','$2a$10$Gu2vZxbx3yiOXTM8xyNV/u7npdHfYPgj1PylGDsM/Q/VZ8yx238Oi')

INSERT INTO tb_endereco_unidade(lougrado, numero, complemento, bairro, cep, longitude, latitude) VALUES ('Rua tal', '300', 'Perto de algum lugar', 'Bairro jw', '60000-000', '-3.8306615', '-38.5569961')

INSERT INTO tb_unidade_saude(nome, endereco_id) VALUES ('Hospital', '1')