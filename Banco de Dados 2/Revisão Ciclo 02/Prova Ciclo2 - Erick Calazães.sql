--1) Inserir uma transa��o contendo uma consulta, passando como par�metros c�digo do m�dico, c�digo do paciente, data e hora. 
-- A transa��o deve ser confirmada se n�o houver erros (marca��o duplicada, marca��o em hor�rio j� utilizado, o m�dico n�o trabalha neste dia), 
-- caso contr�rio deve ser desfeita, informando via PRINT o motivo.

/* Nome da transa��o (procedimento) � T1
Par�metros de teste � 
exec T1 (49, 1070, �2022/08/01�, �09:00�)
T1 (49, 1030, �2022/08/01�, �09:00�)
T1 (50, 1030, �2022/08/01�, �09:30�)
T1 (49, 1070, �2022/08/01�, �09:00�)
T1 (51, 1030, �2022/08/01�, �09:30�) */

create procedure T1 (@medico int, @paciente int, @data date, @hora time(7)) as
begin
    begin transaction;
		insert into consultas (codm, codp, data, hora)
        values (@medico, @paciente, @data, @hora);

    if (select count(*) from consultas where codm = @medico and codp = @paciente and data = @data and hora = @hora) > 1
    begin
        print ('Hor�rio Duplicado');
        rollback;
    end
    else if (select count(*) from consultas where codm = @medico and data = @data and hora = @hora) > 0
    begin
        print ('Hor�rio Utilizado');
        rollback;
    end
    else if (select count(*) from consultas where codm = @medico and data = @data) = 0
    begin
        print ('M�dico n�o trabalha neste dia');
        rollback;
    end
    else
    begin        
        print ('Consulta marcada!');
        commit;
    end
end;

--2)	Criar uma transa��o para associar um ambulat�rio a um m�dico rec�m-contratado, passando como par�metro o c�digo do m�dico e o n�mero do ambulat�rio. 
-- A transa��o deve ser confirmada se o m�dico n�o tiver aloca��o e o ambulat�rio escolhido tiver menos de 5 m�dicos j� alocados; 
-- caso contr�rio deve ser desfeita, informando via PRINT o motivo.

/* Nome da transa��o (procedimento) � T4
Par�metros de teste � 
T4 (44, 201)
T4 (89, 301) */

create procedure T4 (@medico INT, @nramb INT) as
begin
    begin transaction;

    declare @medicoAlocado int, @countMedicosAmbulatorio int;

    update medicos set nroa = @nramb where codm = @medico;

    select @medicoAlocado = count(*) from medicos where codm = @medico and nroa is not null;

    if @medicoAlocado > 0
    begin
        print('M�dico j� possui aloca��o');
        rollback;
    end

    select @countMedicosAmbulatorio = count(*) from medicos where nroa = @nramb;

    if @medicoAlocado = 0 and @countMedicosAmbulatorio >= 5
    begin
        print('Ambulat�rio j� possui 5 ou mais m�dicos alocados');
        rollback;
    end

    if @medicoAlocado = 0 and @countMedicosAmbulatorio < 5
    begin
        print('Aloca��o feita');
        commit;
    end 
end;	

--3) Crie um login/senha (adm_lg) e um usu�rio (adm1) na base HOSPITAL para um empregado do setor administrativo.  
create login adm_lg with password = '12345', check_policy = off
create user adm1 for login adm_lg

--4) Crie uma ROLE chamada R_ADM e forne�a acesso total (leitura, atualiza��o, inser��o e dele��o) a todas as tabelas da base HOSPITAL. 
-- Associe o usu�rio adm1 a esta ROLE.
create role R_ADM;
grant select, update, insert, delete on schema::dbo to R_ADM
alter role R_ADM add member adm1

--5) Uma nova m�dica Laura acaba de chegar ao hospital e precisa poder acessar as consultas m�dicas. Para isto, crie um login/senha e um usu�rio 
-- na base HOSPITAL acima e forne�a acesso de leitura a tabela CONSULTAS
create login laura_lg with password = '12345', check_policy = off
create user lauraMedica for login laura_lg
grant select on consultas to lauraMedica

--)6 Para melhorar a administra��o dos usu�rios m�dicos do hospital, os acessos dos m�dicos ser�o controlados via ROLES, e n�o individualmente. 
-- Assim, crie uma ROLE chamada R_MEDICOS e forne�a a esta ROLE acesso de leitura � tabela CONSULTAS. 
-- Retire em seguida o acesso direto do usu�rio da dr. Laura e o adicione esta ROLE.
create role R_MEDICOS
grant select on consultas to R_MEDICOS
deny select on consultas to lauraMedica
alter role R_MEDICOS add member lauraMedica

-- 7)Suponha que a base �Pacientes� � enorme, e a busca dos dados de um determinado paciente (utilizando o SQL a seguir) durante o processo de 
-- marca��o de consultas est� levando um tempo demasiadamente alto. Sugira, informando o devido comando SQL, 
-- uma indexa��o adequada para otimizar essa consulta. Considre que a chave primaria da tabela � o atributo �CodP�, 
-- e n�o existe outra restri��o na tabela.
-- SELECT * from Pacientes Where CPF = 12345678901
create clustered index CodpIdx on pacientes(codp)

--8) 
-- a.	Buscar dados dos funcion�rios pela codf
ALTER TABLE Funcionarios ADD CONSTRAINT PK_Funcionarios PRIMARY KEY (codf);
create clustered index CodfIdx on funcionarios(codf)

-- b.	Buscar dados dos funcion�rios pelo CPF
ALTER TABLE Funcionarios ADD CONSTRAINT PK_Funcionarios PRIMARY KEY (cpf);
create clustered index CpfIdx on funcionarios(cpf)


-- c.	Buscar dados dos funcion�rios de determinada cidade
create nonclustered index IdadeIdx on funcionarios(idade)