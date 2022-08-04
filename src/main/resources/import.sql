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



INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Agendamento de Serviço', 'com.secretaria.agendamento', 'Agendar um serviço com determinada secretaria')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Alvará','com.secretaria.alvará', '')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Certidões','com.secretaria.certidoes', '')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Unidades de Saúde','com.secretaria.unidade_saude', '')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Passaporte de Vacinação','com.secretaria.passaporte_vacinacao', '')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Consulta Médica','com.secretaria.consulta_medica', '')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Participa Cidadão','com.secretaria.participa_cidadao', 'Forum de comentarios de usuario')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Avaliações de Ações','com.secretaria.avaliacoes_acoes', 'Ações que foram feito por serviços de secretaria e foram avaliadas')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('PodCasts','com.secretaria.podcasts','')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Ouvidoria','com.secretaria.ouvidoria','')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Vapt Vupt','com.secretaria.vapt_vupt','')
INSERT INTO tb_menu(nome, role ,descricao) VALUES ('Portal Oficial','com.secretaria.portal_oficial','')


INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (1, 1) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (1, 2) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (1, 3) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (1, 8) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (2, 1) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (2, 4) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (2, 5) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (2, 6) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (3, 1) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (4, 1) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (5, 1) 
INSERT INTO tb_secretaria_menu(id_secretaria, id_menu) VALUES (6, 1)