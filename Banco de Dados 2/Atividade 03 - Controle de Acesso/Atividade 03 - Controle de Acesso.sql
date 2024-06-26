--1a)
create login aluno_lg with password = '12345', default_database = SENACDCL, check_policy=off 
-- O banco de dados 'SENACDCL' não existe. Forneça um nome de banco de dados válido. Para ver os bancos de dados disponíveis, use sys.databases.

--1b)
create login aluno_lg with password = '12345', check_policy=off 
create user Aluno1 for login aluno_lg

--2a)
select * from automoveis where Fabricante = 'Chevrolet'
-- A permissão SELECT foi negada no objeto 'AUTOMOVEIS', banco de dados 'AUTO', esquema 'dbo'.

--2b)
grant select on schema::dbo to Aluno1

--2c)
select * from automoveis where Fabricante = 'Chevrolet'
-- Agora funcionou

--2d)
insert into automoveis values ('99','Chevrolet', 'Zafira', 2018 ,'Brasil', 80000);
-- A permissão INSERT foi negada no objeto 'AUTOMOVEIS', banco de dados 'AUTO', esquema 'dbo'.

--2e)
grant insert on automoveis to Aluno1

--2f)
insert into automoveis values ('99','Chevrolet', 'Zafira', 2018 ,'Brasil', 80000);
-- Agora funcionou

--2g)
update automoveis set preco_tabela = 90000 where codigo = 99
-- A permissão UPDATE foi negada no objeto 'AUTOMOVEIS', banco de dados 'AUTO', esquema 'dbo'.

--2h)
grant update on automoveis to Aluno1

--2i)
delete from automoveis where codigo = 99
-- A permissão DELETE foi negada no objeto 'AUTOMOVEIS', banco de dados 'AUTO', esquema 'dbo'.

--2j)
grant delete on automoveis to Aluno1

--2k)
delete from automoveis where codigo = 99
-- Agora funcionou

--2l)
deny select on automoveis(preco_tabela) to Aluno1

--2m)
select * from automoveis
-- A permissão SELECT foi negada na coluna 'Preco_tabela' do objeto 'AUTOMOVEIS', banco de dados 'AUTO', esquema 'dbo'.

--2n)
deny select on automoveis to Aluno1

--2o)
select * from automoveis
-- A permissão SELECT foi negada no objeto 'AUTOMOVEIS', banco de dados 'AUTO', esquema 'dbo'.

--3)
create database novoauto
-- Permissão CREATE DATABASE negada no banco de dados 'master'.

--4)
alter server role dbcreator add member aluno_lg
create database novoauto
-- Agora foi


--5)
create table FABRICA (
Fabricante int,
Nome char(20),
Estado char(20)
);


--6)
alter role db_ddladmin add member Aluno1

create table FABRICA (
Fabricante int,
Nome char(20),
Estado char(20)
);

-- Agora foi

