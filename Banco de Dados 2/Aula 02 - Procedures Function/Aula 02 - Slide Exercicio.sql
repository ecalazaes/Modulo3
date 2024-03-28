-- 1) Escreva �Bem-vindo a UC banco de dados II�

create procedure p_Bem_vindo
as
	begin
		print 'Bem-vindo a UC banco de dados II'
	end

exec p_Bem_vindo

----------------------------------------------------

-- 2) Liste os m�dicos que moram no RJ

create procedure p_medicos_rj(@p1 as char(20))
as
select Nome, Cidade
from medicos
where cidade = @p1

exec p_medicos_rj 'Rio de Janeiro'

----------------------------------------------------

-- 3) Dado CPF, liste as informa��es de um paciente

create procedure p_paciente(@p1 as char(11))
as
select *
from pacientes
where cpf = @p1

exec p_paciente '01287988790'

----------------------------------------------------

-- 4) Dado uma idade, liste os nomes e especialidade dos m�dicos

create procedure p_idade(@p1 as char(3))
as
select Nome, Especialidade, Idade
from medicos
where idade = @p1

exec p_idade '50'

----------------------------------------------------

-- 5) Dado um c�digo de m�dico (codm) liste o andar e numero do ambulatorio

create procedure p_medico_andar_amb(@p1 as char(3))
as
select m.codm as C�digoMedico, m.nome as NomeMedico, a.nroa as Ambulatorio, a.Andar
from medicos m inner join ambulatorio a on m.nroa = a.nroa 
where m.codm = @p1

exec p_medico_andar_amb '45'

----------------------------------------------------

-- 6) Calcule a m�dia de 5 n�meros
create function media(@x float,@a float,@b float,@c float,@d float)
returns float
begin
	return (@x + @a + @b + @c + @d) / 5
end

select dbo.media(5,10,15,20,25) as M�dia

----------------------------------------------------

--7) Retorne as 2 ra�zes de uma equa��o do 2� grau, dado os coeficientes A, B e C (testar com os seguintes par�metros: (3,-7,4), (9,-12,4) e (5,3,5) )

alter function bhascara(@a float, @b float, @c float)
returns @resultados table (x1 FLOAT, x2 FLOAT, Observacao char(100))
as
begin
	declare @delta float;
	set @delta = (@b * @b) - (4 * @a * @c);
	
	if @delta > 0
		begin
			insert into @resultados(x1, x2, Observacao)
			values ((-@b + sqrt(@delta)) / (2 * @a), (-@b - sqrt(@delta)) / (2 * @a), 'Delta > 0 ent�o a  equa��o possui duas ra�zes reais e diferentes');
		end
	else if @delta = 0
		begin
			insert into @resultados(x1, x2, Observacao)
			values (-@B / (2 * @A), -@B / (2 * @A), 'Delta = 0 ent�o a equa��o tem duas ra�zes reais e iguais')
		end
	else if @delta < 0
		begin			
			INSERT INTO @resultados(x1, x2, Observacao)
			VALUES (NULL, NULL, 'Delta < 0 ent�o a equa��o n�o possui ra�zes reais.');
		end
	return;
end;

SELECT * FROM bhascara(3, -7, 4);
SELECT * FROM bhascara(9, -12, 4);
SELECT * FROM bhascara(5, 3, 5);

----------------------------------------------------


	

	




