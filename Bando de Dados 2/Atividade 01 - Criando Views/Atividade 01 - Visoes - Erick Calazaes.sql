-- Ativadade 01 - Visões - Erick Calazães

-- 1) Carros_Novos (Código, Fabricante, Modelo, Ano, País, Preço_tabela), com os automóveis de origem argentina fabricados no ano de 2020 
create view Carros_Novos as
select * from automoveis
where Pais = 'Argentina' and Ano = '2020'

select * from Carros_Novos

-- 2) Auto_disponiveis (Revendedora, Fabricante, Modelo, quantidade), com os carros disponíveis para venda em cada revendedora (nome) 
create view Auto_disponiveis as 
select r.nome as Revendedora, a.Fabricante , a.Modelo, g.Quantidade
from revendedora r inner join garagens g on r.cnpj = g.cnpj 
inner join automoveis a on a.codigo = g.codigo

select * from Auto_disponiveis

-- 3) Consumidores_Cariocas (Nome, CPF) com os consumidores que moram na cidade do rio de Janeiro
create view Consumidores_Cariocas as
select Nome, CPF
from consumidores
where cidade = 'Rio de Janeiro'

select * from Consumidores_Cariocas

--

-- 4) Neg_ok (Comprador, Revenda, Código, Ano, Data, Preço), registrando negócios com Lucro superior a 10% 
-- (dica: use como critério preco venda > preco de tabela * 1.1)
create view Neg_ok as
select c.Nome as Comprador, r.Nome as Revendedora, a.Codigo, a.Ano, n.DataC, n.Preco
from negocios n inner join consumidores c on n.cpf = c.cpf 
inner join revendedora r on n.cnpj = n.cnpj 
inner join automoveis a on n.codigo = a.codigo
where n.preco > a.preco_tabela * 1.1

select * from Neg_ok

--

-- 5) Fabricantes_Estoque (Fabricante, quantidade), contendo fabricante e a quantidade total de automóveis 
-- fornecidos por ele nas garagens das revendedoras (dica: usar Group by na view)
create view Fabricantes_Estoque as
select a.Fabricante, count(*) as 'Qtd no Estoque'
from automoveis a inner join garagens g on a.codigo = g.codigo
group by a.fabricante

select * from Fabricantes_Estoque






