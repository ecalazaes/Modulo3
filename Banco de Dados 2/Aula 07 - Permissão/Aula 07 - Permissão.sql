-- Criando usu�rio
create login aluno2_lg with password = 'qwerty'
create user alunoUser2 for login aluno2_lg

-- Criando role para o aluno
create role UsuariosAlunos
alter role usuariosALunos add member alunoUser2

-- Dando permiss�o para o select e insert
grant select on medicos to UsuariosAlunos
grant insert on medicos to UsuariosAlunos

-- Retirando a permiss�o para o select 
revoke select on medicos to UsuariosAlunos
revoke insert on medicos to UsuariosAlunos

-- Dando permiss�o para select no schema
grant select on schema::teste to UsuariosAlunos

-- Dando permiss�o para o select mas bloqueando a coluna salario
grant select on funcionarios to UsuariosAlunos
deny select on funcionarios(salario) to UsuariosAlunos

