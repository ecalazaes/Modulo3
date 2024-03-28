-- 1) Escreva “Bem-vindo a UC banco de dados II”

create procedure Bem_vindo
as
	begin
		print 'Bem-vindo a UC banco de dados II'
	end

exec Bem_vindo

----------------------------------------------------

-- 2) Liste os médicos que moram no RJ

create procedure p_medicos_rj(@p1 as char(20))
as
select Nome, Cidade
from medicos
where cidade = @p1

exec p_medicos_rj 'Rio de Janeiro'

----------------------------------------------------

-- 3) Dado CPF, liste as informações de um paciente

create procedure p_paciente(@p1 as char(11))
as
select *
from pacientes
where cpf = @p1

exec p_paciente '01287988790'

----------------------------------------------------

-- 4) Dado uma idade, liste os nomes e especialidade dos médicos

create procedure p_idade(@p1 as char(3))
as
select Nome, Especialidade, Idade
from medicos
where idade = @p1

exec p_idade '50'

-- 5) Dado um código de médico (codm) liste o andar e numero do ambulatorio

create procedure codm(@p1 as char(3))
as
select nroa as Ambulatorio, Andar
from ambulatorio
where codm = @p1

select * from medicos





