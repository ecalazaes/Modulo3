-- Criando um Procedure
create procedure p_especialista
as
select nome, especialidade
from medicos

-- Executando um procedure
exec p_especialista

-- Deletando um procedure
drop procedure p_especialista

-- Para visualizar o procedimento criado.
exec sp_helptext p_especialista 

-- Para alterar um procedimento criado.
alter procedure p_especialista(@p1 as char(20))
as 
select nome, especialidade
from medicos
where especialidade = @p1

-------------------------------------------------------------

-- Criando um procedure com parâmetros
create procedure p_especialista(@p1 as char(20))
as 
select nome, especialidade
from medicos
where especialidade = @p1

exec p_especialista 'Pediatria'

-------------------------------------------------------------

-- Criando procedure com criptografia
create procedure p_especialista
with encryption
as
select nome, especialidade
from medicos

-------------------------------------------------------------

-- Criando uma função escalar
create function quadrado(@x INT)
returns int
begin
	return @x*@x
end

-- Executando uma função
select dbo.quadrado(8) as Quadrado

select idade, dbo.quadrado(idade)
from medicos

-------------------------------------------------------------

-- Criando uma função que retorne uma tabela
CREATE FUNCTION DtsMinutos(@min int, @dti datetime, @dtf datetime)
RETURNS @tbl TABLE(dt datetime)
AS
BEGIN
    WHILE @dti <= @dtf
    BEGIN
      INSERT INTO @tbl(dt) VALUES (@dti)
      SET @dti = DATEADD(MINUTE,@min,@dti)
    END      
    RETURN
END

SELECT *
FROM   DtsMinutos(12,'2011-01-01 12:00','2011-01-01 17:00')

-------------------------------------------------------------

CREATE FUNCTION DtsMinutos1(@min int, @dti datetime, @dtf datetime)
RETURNS @tbl TABLE(dt datetime, lg char(10))
AS
BEGIN
    WHILE @dti <= @dtf
    BEGIN
      INSERT INTO @tbl(dt, lg) VALUES (@dti, 'BOB')
      SET @dti = DATEADD(MINUTE,@min,@dti)
    END      
    RETURN
END

SELECT *
FROM   DtsMinutos1(12,'2011-01-01 12:00','2011-01-01 17:00')

-------------------------------------------------------------



