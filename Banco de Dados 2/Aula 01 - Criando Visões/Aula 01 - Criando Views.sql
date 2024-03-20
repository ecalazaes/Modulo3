-- Criando views
create view MedicoCardio as 
select nome, idade, especialidade
from medicos
where Especialidade = 'Cardiologia'

select * from MedicoCardio

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Criando views
create view MedicoOrtopedia as
select nome, idade, especialidade
from medicos
where Especialidade = 'Ortopedia'

select * from MedicoOrtopedia

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Deletando views
drop view MedicosAmb

create view MedicosAmb as
select m.nome as Médico, m.nroa as NúmeroAmbulatório, a.andar
from Medicos m inner join ambulatorio a on m.nroa = a.nroa


select médico from MedicosAmb
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Create view com COUNT
create view NumMedicosEspecialidade as 
select especialidade, count(*) as Quantidade
from medicos
group by Especialidade

select * from NumMedicosEspecialidade