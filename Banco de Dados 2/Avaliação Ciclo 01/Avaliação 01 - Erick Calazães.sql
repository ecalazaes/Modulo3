-- 1)	Criar a View “FilmesporIdiona” contendo as colunas “Idioma” e “QuantidadeFilmes”, que lista a quantidade de filmes lançados por idioma.
create view FilmesporIdiona
as 
select  language as Idioma, count(*) as QuantidadeFilmes
from facts_movie
group by language

select * from FilmesporIdiona

-- 2)	Criar a View “FilmescomLucro” contendo as colunas “Filme”, “ano” e “Lucro” (gross-budget), que lista apenas os filmes que obtiveram lucro.
create view FilmescomLucro
as
	select movie_title as Filme, title_year as Ano, (gross-budget) as Lucro
	from facts_movie
	where (gross-budget) > 0

select * from FilmescomLucro

-- 3)	Criar uma View “Filmes2k” contendo as colunas “tituloFilme”, “Ano”, “Ator” dos filmes do produzidos após o ano 2.010 (inclusive) do ator ‘Vin Diesel’.
create view Filmes2k
as 
	select f.movie_title as TituloFilme, f.title_year as Ano, a.actor as Ator
	from facts_movie f inner join dim_atuam x on f.id_title = x.id_title
	inner join dim_names a on a.id_names = x.id_names
	where a.actor = 'Vin Diesel' and f.title_year >= '2010'

select * from Filmes2k

-- 4) Criar o procedimento “sp_FilmesPais” que recebe um parâmetro 'Pais' e  liste os títulos deste pais
create procedure sp_FilmesPais (@p1 as char(20))
as
	begin
		select movie_title as TituloFilme,  country as País
		from facts_movie
		where country = @p1
	end

exec sp_FilmesPais 'UK'

-- 5) Criar o procedimento “sp_scoresBonsFilmes” que retorna o título do filme e IMDB dos filmes com IMDB maiores que 7 (inclusive)
create procedure sp_scoresBonsFilmes
as
	begin
		select movie_title as TituloFilme, imdb_score as IMDB
		from facts_movie f inner join facts_score s on f.id_title = s.id_title
		where imdb_score >= 7
	end

exec sp_scoresBonsFilmes

-- 6)	Criar um procedimento “sp_AtoresdeFilmes” que recebe um parâmetro nome parcial (ou completo) de um filme e retorna todos os filmes com esta palavra no nome e os respectivos atores deste(s) filme(s), 
-- ordenados por ordem alfabética (dica: como os nomes de filmes da base de dados não tem qualidade, isto é, possuem espaços diversos no início e fim, use a expressão LIKE ‘%..%’) 
create procedure sp_AtoresdeFilmes (@p1 as nvarchar(100))    
as
	begin
		select f.movie_title as TituloFilme, a.actor As Ator
		from facts_movie f inner join dim_atuam x ON f.Id_title = x.Id_title    
		inner join dim_names a ON x.id_names = a.id_names
		where f.movie_title LIKE '%' + @p1 + '%'
		ORDER BY a.actor;
	end

exec sp_AtoresdeFilmes 'Escape'

-- 7)	Crie a função escalar 'POPULARIDADE' que recebe 'id_Title' como parâmetro e retorna ‘ALTA' -- se o filme tiver mais de 1.000.000 de votos, -- 'MEDIA' se tiver entre 500.000 e -- 1.000.000, 
-- ‘BAIXA' se tiver entre 100.00 e 500.000 -- e 'IMPOPULAR' se tiver abaixo de 100.000. Testar a saída função com o seguinte comando SQL:
create function popularidade (@id_Title INT)
returns nvarchar(20)
as
begin
    declare @popularidade NVARCHAR(20);
    declare @Votos INT;

    select @Votos = num_voted_users
    from facts_score
    where Id_title = @id_Title;

    if @Votos > 1000000
        set @popularidade = 'ALTA';
    else if @Votos BETWEEN 500000 AND 1000000
        set @popularidade = 'MEDIA';
    else if @Votos BETWEEN 100000 AND 500000
        set @popularidade = 'BAIXA';
    else
        set @popularidade = 'IMPOPULAR';

    return @popularidade;
end

SELECT TOP (100) m.movie_title as TituloFIlme, dbo.POPULARIDADE(m.id_title) AS Popularidade 
FROM facts_movie m


-- 8)	Criar um login “imdb_lg”, escolher uma senha adequada e apontar como Database default “IMDB”
create login imdb_lg with password = 'csmixz'
use IMDB
alter login imdb_lg with default_database = IMDB

-- 9)	Criar um usuário no database IMDB chamado “imdbuser” e associá-lo ao login “imdb_lg”,
use IMDB
create user imdbUser for login imdb_lg

-- 10)	A respeito do conceito de normalização de databases, considere a tabela abaixo e responda, considerando:

a) Tabela na 1FN (Primeira Forma Normal):
Criar uma nova tabela "Cores" para armazenar as cores de cada item, ID_Cor ( PK ).
Remover a coluna "Cor" da tabela original e adicionar uma coluna "ID_Cor" para referenciar a nova tabela "Cores".
Código(PK)	Item	Preço	Imposto	ID_Cor(FK)
001	Lápis	R$2,00	R$0,20	1
002	Escala	R$3,00	R$0,30	2
003	Caneta	R$5,00	R$0,50	1, 3
004	Mochila	R$150,00	R$7,80	4, 5

ID_Cor(PK)	Cor
1	Vermelho
2	Amarelo
3	Azul
4	Preto
5	Azul

b) Segunda Forma Normal (2FN):
Mover a coluna "Imposto" para a tabela "Item", pois depende apenas do "Preço" (que está na chave primária da tabela "Item").
Código(PK)	Item	Preço	Imposto
001	Lápis	R$2,00	R$0,20
002	Escala	R$3,00	R$0,30
003	Caneta	R$5,00	R$0,50
004	Mochila	R$150,00	R$7,80

c) Terceira Forma Normal (3FN):
A tabela "Item" já está na 3FN, pois não há dependências transitivas indiretas.







	


