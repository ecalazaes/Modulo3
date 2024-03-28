-- 1) Crie um procedimento armazenado que selecione e liste os pacientes com determinada doença (passada como parâmetro) 

create procedure p_pacientes_doenca (@p1 char(20))
as
select Nome, Doença
from pacientes
where doença = @p1

exec p_pacientes_doenca 'Diabetes'

-----------------------------------------

-- 2) Crie uma função que calcule o cubo de um numero X

alter function calc_cubo(@x float)
returns float
begin	
	return ( @x * @x * @x );
end

select dbo.calc_cubo(3) as Cubo

-----------------------------------------

-- 3) Crie uma função que calcule a raiz de uma equação do primeiro grau do tipo Ax+B=0, dados os coeficientes A e B (dica x=-B/A)

create function calc_raiz(@a float, @b float)
returns float
begin
	declare @x float;
	set @x = (-@b / @a);
	return @x;
end


select dbo.calc_raiz(1,10) as Raiz
-----------------------------------------

-- 4) Crie uma função chamada ConsultasApos que retorne as consultas com data posterior a um parâmetro passado (teste com ‘01/10/2020’)
alter function ConsultasApos (@dt datetime)
returns table
as
return ( select * from consultas where data >= @dt );

select * from ConsultasApos ('01/10/2020')



