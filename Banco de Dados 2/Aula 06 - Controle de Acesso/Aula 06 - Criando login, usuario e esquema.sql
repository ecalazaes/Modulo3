-- Criando Login
create login aluno_lg with password = '12345678';

-- Criando Usuário
create user alunoUser for login aluno_lg

-- Criando um Esquema ou Pacote
create schema STESTE;

-- Criando uma tabela no esquema "STESTE"
create table  STESTE.coordenadas (x int, y int);
create table STESTE.coordenadas3d (x int, y int , z int);


-- Criando uma view no esquema STESTE
create view steste.vcoord as 
select x from steste.coordenadas;

select * from steste.vcoord

