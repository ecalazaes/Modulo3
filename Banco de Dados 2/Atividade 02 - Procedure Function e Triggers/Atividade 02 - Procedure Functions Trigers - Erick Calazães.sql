-- Atividade 02 - Erick Calaz�es - Procedures,Functions e Triggers

 -- 1) Crie um procedimento armazenado que escreva a frase �SENAC RIO�
create procedure p_senac
as
	begin
		print 'SENAC RIO'
	end

exec p_senac

-- 2) Crie um procedimento armazenado que liste os pacientes com sarampo
create procedure p_pac_sarampo (@p1 as char (20))
as
	select Nome, Sexo, Idade, Doen�a
	from Pacientes
	where doen�a = @p1

exec p_pac_sarampo 'Sarampo'

-- 3) Crie um procedimento armazenado que selecione e liste os pacientes com determinada doen�a (passada como par�metro) 
create procedure p_pac_doenca (@p1 as char (20))
as
	select Nome, Sexo, Idade, Doen�a
	from Pacientes
	where doen�a = @p1

exec p_pac_doenca 'Diabetes'

-- 4) Listar nome e dados de consultas de determinado paciente (par�metro = codp)
create procedure p_pac_consulta (@p1 as int)
as
	select nome, p.codp codm, data, hora
	from pacientes p inner join consultas c on p.codp = c.codp
	where p.codp = @p1

exec p_pac_consulta 1070

-- 5) crie uma fun��o que calcule o cubo de um numero X
create function calc_cubo(@x float)
		returns float
		begin		
			return ( @x * @x * @x );
		end

select dbo.calc_cubo(2) as Cubo

-- 6) Crie uma fun��o que calcule a raiz de uma equa��o do primeiro grau do tipo Ax+B=0, dados os coeficientes A e B (dica x=-B/A)
create function calc_raiz(@a float, @b float)
		returns float
		begin
			declare @x float;
			set @x = (-@b / @a);
			return @x;
		end

select dbo.calc_raiz(1,10) as Raiz

-- 7) Crie uma fun��o chamada ConsultasApos que retorne as consultas com data posterior a um par�metro passado (teste com �01/10/2020�)
create function ConsultasApos (@dt datetime)
returns table
	as
		return ( select * from consultas where data >= @dt );

select * from ConsultasApos ('01/10/2020')

-- 8) Criar uma trigger que se cadastrar um novo paciente verifique se o mesmo � do grupo de risco (�Diabetes�, �Hipertens�o�, Zica�) 
-- e caso seja, o registre na tabela GrpRisco (dica: utilize a fun��o do SQL GETDATE() para obter a data/hora do registro para o campo �data�)
create trigger check_risco
on pacientes
after insert 
as 
begin
	insert into GrpRisco(codp, nome, data, doenca)
	select codp, nome, getdate(), doen�a
	from inserted 
	where doen�a IN ('Diabetes', 'Hipertens�o', 'Zica')
end
