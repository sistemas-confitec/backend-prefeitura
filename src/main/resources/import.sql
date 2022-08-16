-- CREATE TABLES
-- 
-- CREATE TABLE cliente(
-- id serial primary key,
-- nome varchar(65) not null);
-- 
-- CREATE TABLE secretaria(
-- id serial primary key,
-- nome varchar(90) not null,
-- descricao varchar(50) not null);
-- 
-- 
-- CREATE TABLE servico(
-- id serial primary key,
-- nome varchar(45) not null,
-- descricao varchar(50) not null,
-- id_secretaria int,
-- foreign key (id_secretaria) references secretaria(id));
-- 
-- 
-- CREATE TABLE agendamento(
-- id serial primary key,
-- id_secretaria int, 
-- id_servico int, 
-- data date not null, 
-- hora time not null,
-- foreign key (id_secretaria) references secretaria(id),
-- foreign key (id_servico) references servico(id));
-- 
-- 
-- CREATE TABLE comentario_cidadao(
-- id serial primary key,
-- comentario varchar(144) not null);
-- 
-- 
-- CREATE TABLE usuario(
-- id serial primary key,
-- nome varchar(45) not null,
-- matricula int not null, 
-- senha varchar not null);
-- 
-- 
-- CREATE TABLE endereco_unidade(
-- id serial primary key,
-- lougrado varchar(100) not null, 
-- numero varchar(10) not null, 
-- complemento varchar(40), 
-- bairro varchar(20) not null, 
-- cep varchar(10) not null, 
-- longitude varchar(15) not null, 
-- latitude varchar(15) not null);
-- 
-- CREATE TABLE unidade_saude(
-- id serial primary key, 
-- nome varchar(70) not null,
-- id_endereco int,
-- foreign key(id_endereco) references endereco_unidade(id));
-- 
-- 
-- CREATE TABLE menu(
-- id serial primary key,
-- nome varchar(65), 
-- role varchar(70),
-- descricao varchar(100));
-- 
-- 
-- CREATE TABLE secretaria_menu(
-- id serial primary key,
-- id_secretaria int, 
-- id_menu int,
-- foreign key (id_secretaria) references secretaria(id),
-- foreign key (id_menu) references menu(id));


-- INSERTS



INSERT INTO cliente (nome) VALUES ('Alex');
INSERT INTO cliente (nome) VALUES ('Maria');
INSERT INTO cliente (nome) VALUES ('Paulo');
INSERT INTO cliente (nome) VALUES ('Tomas');
INSERT INTO cliente (nome) VALUES ('Ana');
INSERT INTO cliente (nome) VALUES ('Marcos');

INSERT INTO secretaria (nome, descricao)  VALUES ('Gabinete do Prefeito', 'TEXTO 1');
INSERT INTO secretaria (nome, descricao)  VALUES ('Secretaria de Saúde', 'TEXTO 2');
INSERT INTO secretaria (nome, descricao)  VALUES ('Secretaria de Educação', 'TEXTO 3');
INSERT INTO secretaria (nome, descricao)  VALUES ('Secretaria de Meio Ambiente', 'TEXTO 4');
INSERT INTO secretaria (nome, descricao)  VALUES ('Secretaria de Infraestrutura', 'TEXTO 5');
INSERT INTO secretaria (nome, descricao)  VALUES ('Secretaria de Assistência Social', 'TEXTO 6');

INSERT INTO servico (nome, descricao, id_secretaria) VALUES ('Consulta', 'TESTE 1' , 1 );
INSERT INTO servico (nome, descricao, id_secretaria) VALUES ('Exame', 'TESTE 1', 2);

INSERT INTO agendamento (id_secretaria, id_servico, data, hora)  VALUES (1, 1, now(), now());
INSERT INTO agendamento (id_secretaria, id_servico, data, hora)  VALUES (2, 2, now(), now());

INSERT INTO comentario_cidadao (comentario) VALUES ('Comentario 1');
INSERT INTO comentario_cidadao (comentario) VALUES ('Comentario 2');

INSERT INTO usuario(nome, matricula, senha) VALUES ('Usuario 1', '30010','$2a$10$Gu2vZxbx3yiOXTM8xyNV/u7npdHfYPgj1PylGDsM/Q/VZ8yx238Oi');

INSERT INTO endereco_unidade(lougrado, numero, complemento, bairro, cep, longitude, latitude) VALUES ('Rua tal', '300', 'Perto de algum lugar', 'Bairro jw', '60000-000', '-3.8306615', '-38.5569961');

INSERT INTO unidade_saude(nome, id_endereco) VALUES ('Hospital', '1');



INSERT INTO menu(nome, role ,descricao) VALUES ('Agendamento de Serviço', 'com.secretaria.agendamento', 'Agendar um serviço com determinada secretaria');
INSERT INTO menu(nome, role ,descricao) VALUES ('Alvará','com.secretaria.alvará', '');
INSERT INTO menu(nome, role ,descricao) VALUES ('Certidões','com.secretaria.certidoes', '');
INSERT INTO menu(nome, role ,descricao) VALUES ('Unidades de Saúde','com.secretaria.unidade_saude', '');
INSERT INTO menu(nome, role ,descricao) VALUES ('Passaporte de Vacinação','com.secretaria.passaporte_vacinacao', '');
INSERT INTO menu(nome, role ,descricao) VALUES ('Consulta Médica','com.secretaria.consulta_medica', '');
INSERT INTO menu(nome, role ,descricao) VALUES ('Participa Cidadão','com.secretaria.participa_cidadao', 'Forum de comentarios de usuario');
INSERT INTO menu(nome, role ,descricao) VALUES ('Avaliações de Ações','com.secretaria.avaliacoes_acoes', 'Ações que foram feito por serviços de secretaria e foram avaliadas');
INSERT INTO menu(nome, role ,descricao) VALUES ('PodCasts','com.secretaria.podcasts','');
INSERT INTO menu(nome, role ,descricao) VALUES ('Ouvidoria','com.secretaria.ouvidoria','');
INSERT INTO menu(nome, role ,descricao) VALUES ('Vapt Vupt','com.secretaria.vapt_vupt','');
INSERT INTO menu(nome, role ,descricao) VALUES ('Portal Oficial','com.secretaria.portal_oficial','');


INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (1, 1);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (1, 2);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (1, 3);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (1, 8);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (2, 1);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (2, 4);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (2, 5);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (2, 6);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (3, 1);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (4, 1);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (5, 1);
INSERT INTO secretaria_menu(id_secretaria, id_menu) VALUES (6, 1);