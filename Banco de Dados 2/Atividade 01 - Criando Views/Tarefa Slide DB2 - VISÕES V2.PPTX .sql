-- Tarefa Slide " DB2 - VIS�ES V2.PPTX "

-- 1) Construa uma vis�o chamada �EspecialistaRJ� com m�dicos somente com os atributos codm, nome e especialidade daqueles m�dicos que moram no �Rio de Janeiro� 
create view EspecialistaRJ as
select codm, nome, especialidade
from medicos
where cidade = 'Rio de Janeiro'

select * from EspecialistaRJ

-- 2) Construa uma vis�o chamada �GrupodeRisco� da tabela pacientes, com os campos nome, doen�a, cidade que tem como doen�as �Pneumonia�, �Hipertens�o� ou �Gripe�
create view GrupodeRisco as
select nome,doen�a,cidade
from pacientes
where doen�a in ( 'Penumonia', 'Hipertens�o', 'Gripe' )

select * from GrupodeRisco

-- 3) Construa uma vis�o chamada �CapacidadesMedicas� com os campos especialidade, e sua quantidade
create view CapacidadesMedicas as
select especialidade, count(*) as 'N�mero de M�dicos'
from medicos
group by especialidade

select * from CapacidadesMedicas

-- 4) Construa uma vis�o chamada �consultasout20� com nome do medico, nome do paciente, data e hora das consultas dos m�s de outubro de 2020
create view ConsultasOut20 as
select m.nome as M�dico, p.nome as Paciente, c.data, c.hora
from pacientes p inner join consultas c on p.codp = c.codp 
inner join medicos m on m.codm = c.codm
where c.data between '01/10/2020' and '31/10/2020' 

select * from ConsultasOut20

-- 5) Construa uma vis�o chamada �consultasRiscoDez20� com a quantidade de consultas para cada doen�a do grupo de risco �Pneumonia�, �Hipertens�o� ou �Gripe� em 2020
create view ConsultasRiscoDez20 as
select doen�a as 'Doen�a de Risco', count(*) as ' Quantidade de Consultas '
from pacientes p inner join consultas c on p.codp = c.codp
where c.data between '01/01/2020' and '31/12/2020' and doen�a in ( 'Penumonia', 'Hipertens�o', 'Gripe' )
group by p.doen�a

select * from ConsultasRiscoDez20



