--1) Inserir uma transação contendo uma consulta, passando como parâmetros código do médico, código do paciente, data e hora. 
-- A transação deve ser confirmada se não houver erros (marcação duplicada, marcação em horário já utilizado, o médico não trabalha neste dia), 
-- caso contrário deve ser desfeita, informando via PRINT o motivo.

/* Nome da transação (procedimento) – T1
Parâmetros de teste – 
exec T1 (49, 1070, “2022/08/01”, “09:00”)
T1 (49, 1030, “2022/08/01”, “09:00”)
T1 (50, 1030, “2022/08/01”, “09:30”)
T1 (49, 1070, “2022/08/01”, “09:00”)
T1 (51, 1030, “2022/08/01”, “09:30”) */

create procedure T1 (@medico int, @paciente int, @data date, @hora time(7)) as
begin
    begin transaction;
		insert into consultas (codm, codp, data, hora)
        values (@medico, @paciente, @data, @hora);

    if (select count(*) from consultas where codm = @medico and codp = @paciente and data = @data and hora = @hora) > 1
    begin
        print ('Horário Duplicado');
        rollback;
    end
    else if (select count(*) from consultas where codm = @medico and data = @data and hora = @hora) > 0
    begin
        print ('Horário Utilizado');
        rollback;
    end
    else if (select count(*) from consultas where codm = @medico and data = @data) = 0
    begin
        print ('Médico não trabalha neste dia');
        rollback;
    end
    else
    begin        
        print ('Consulta marcada!');
        commit;
    end
end;

--2)	Criar uma transação para associar um ambulatório a um médico recém-contratado, passando como parâmetro o código do médico e o número do ambulatório. 
-- A transação deve ser confirmada se o médico não tiver alocação e o ambulatório escolhido tiver menos de 5 médicos já alocados; 
-- caso contrário deve ser desfeita, informando via PRINT o motivo.

/* Nome da transação (procedimento) – T4
Parâmetros de teste – 
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
        print('Médico já possui alocação');
        rollback;
    end

    select @countMedicosAmbulatorio = count(*) from medicos where nroa = @nramb;

    if @medicoAlocado = 0 and @countMedicosAmbulatorio >= 5
    begin
        print('Ambulatório já possui 5 ou mais médicos alocados');
        rollback;
    end

    if @medicoAlocado = 0 and @countMedicosAmbulatorio < 5
    begin
        print('Alocação feita');
        commit;
    end 
end;	

--3) Crie um login/senha (adm_lg) e um usuário (adm1) na base HOSPITAL para um empregado do setor administrativo.  
create login adm_lg with password = '12345', check_policy = off
create user adm1 for login adm_lg

--4) Crie uma ROLE chamada R_ADM e forneça acesso total (leitura, atualização, inserção e deleção) a todas as tabelas da base HOSPITAL. 
-- Associe o usuário adm1 a esta ROLE.
create role R_ADM;
grant select, update, insert, delete on schema::dbo to R_ADM
alter role R_ADM add member adm1

--5) Uma nova médica Laura acaba de chegar ao hospital e precisa poder acessar as consultas médicas. Para isto, crie um login/senha e um usuário 
-- na base HOSPITAL acima e forneça acesso de leitura a tabela CONSULTAS
create login laura_lg with password = '12345', check_policy = off
create user lauraMedica for login laura_lg
grant select on consultas to lauraMedica

--)6 Para melhorar a administração dos usuários médicos do hospital, os acessos dos médicos serão controlados via ROLES, e não individualmente. 
-- Assim, crie uma ROLE chamada R_MEDICOS e forneça a esta ROLE acesso de leitura à tabela CONSULTAS. 
-- Retire em seguida o acesso direto do usuário da dr. Laura e o adicione esta ROLE.
create role R_MEDICOS
grant select on consultas to R_MEDICOS
deny select on consultas to lauraMedica
alter role R_MEDICOS add member lauraMedica

-- 7)Suponha que a base “Pacientes” é enorme, e a busca dos dados de um determinado paciente (utilizando o SQL a seguir) durante o processo de 
-- marcação de consultas está levando um tempo demasiadamente alto. Sugira, informando o devido comando SQL, 
-- uma indexação adequada para otimizar essa consulta. Considre que a chave primaria da tabela é o atributo “CodP”, 
-- e não existe outra restrição na tabela.
-- SELECT * from Pacientes Where CPF = 12345678901
create clustered index CodpIdx on pacientes(codp)

--8) 
-- a.	Buscar dados dos funcionários pela codf
ALTER TABLE Funcionarios ADD CONSTRAINT PK_Funcionarios PRIMARY KEY (codf);
create clustered index CodfIdx on funcionarios(codf)

-- b.	Buscar dados dos funcionários pelo CPF
ALTER TABLE Funcionarios ADD CONSTRAINT PK_Funcionarios PRIMARY KEY (cpf);
create clustered index CpfIdx on funcionarios(cpf)


-- c.	Buscar dados dos funcionários de determinada cidade
create nonclustered index IdadeIdx on funcionarios(idade)