-- Tarefa Slide " DB2 - VISÕES V2.PPTX "

-- 1) Construa uma visão chamada “EspecialistaRJ” com médicos somente com os atributos codm, nome e especialidade daqueles médicos que moram no “Rio de Janeiro” 
create view EspecialistaRJ as
select codm, nome, especialidade
from medicos
where cidade = 'Rio de Janeiro'

select * from EspecialistaRJ

-- 2) Construa uma visão chamada “GrupodeRisco” da tabela pacientes, com os campos nome, doença, cidade que tem como doenças “Pneumonia”, “Hipertensão” ou “Gripe”
create view GrupodeRisco as
select nome,doença,cidade
from pacientes
where doença in ( 'Penumonia', 'Hipertensão', 'Gripe' )

select * from GrupodeRisco

-- 3) Construa uma visão chamada “CapacidadesMedicas” com os campos especialidade, e sua quantidade
create view CapacidadesMedicas as
select especialidade, count(*) as 'Número de Médicos'
from medicos
group by especialidade

select * from CapacidadesMedicas

-- 4) Construa uma visão chamada “consultasout20” com nome do medico, nome do paciente, data e hora das consultas dos mês de outubro de 2020
create view ConsultasOut20 as
select m.nome as Médico, p.nome as Paciente, c.data, c.hora
from pacientes p inner join consultas c on p.codp = c.codp 
inner join medicos m on m.codm = c.codm
where c.data between '01/10/2020' and '31/10/2020' 

select * from ConsultasOut20

-- 5) Construa uma visão chamada “consultasRiscoDez20” com a quantidade de consultas para cada doença do grupo de risco “Pneumonia”, “Hipertensão” ou “Gripe” em 2020
create view ConsultasRiscoDez20 as
select doença as 'Doença de Risco', count(*) as ' Quantidade de Consultas '
from pacientes p inner join consultas c on p.codp = c.codp
where c.data between '01/01/2020' and '31/12/2020' and doença in ( 'Penumonia', 'Hipertensão', 'Gripe' )
group by p.doença

select * from ConsultasRiscoDez20



