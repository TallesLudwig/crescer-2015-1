select IDCliente , Nome
from Cliente
--1) Identifique e liste quantos valores diferentes estão definidos para a coluna Situacao da tabela Produto 
--(somente os distintos valores).

select p.Situacao, count(p.situacao)
from Produto as p
group by p.Situacao

--2) Liste todos os clientes que tenham o LTDA no nome ou razao social.

select c.Nome
from Cliente as c
where c.Nome like '%Ltda%'
or c.RazaoSocial like '%Ltda%'



--3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
--Nome: Galocha Maragato
--Preço de custo: 35.67
--Preço de venda: 77.95
--Situação: A


begin transaction
go

insert into Produto 
      (Nome, 
       PrecoCusto, 
       PrecoVenda,
	   Situacao)
  values 
      ('Galocha Maragato', 
		  35.67, 
		77.95,
	   'A' );

commit

select * from Produto where Nome='Galocha Maragato'


--4) Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, 
--pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente deverá ser listado.

select p.Nome
from Produto as p
where p.Nome not in (select p.Nome
						from Produto as p
						inner join PedidoItem as ip on ip.IDProduto=p.IDProduto
						inner join Pedido as pe on pe.IDPedido= ip.IDProduto
)



--5) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente),
-- liste também qual o Estado possuí o menor número de clientes.
--Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION.

select c.UF
from Cidade as c
left join Cliente as cl on cl.IDCidade= c.IDCidade
group by c.UF
union


select max( select count(1) 
		from Cidade as c
		left join Cliente as cl on cl.IDCidade= c.IDCidade
		group by c.UF) as sdasdsa
from Cidade as c
left join Cliente as cl on cl.IDCidade= c.IDCidade

select max(count(1)) as sdasdsa
from Cidade as c
inner join Cliente as cl on cl.IDCidade= c.IDCidade
group by c.UF

--6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
--Dica: será preciso relacionar Cidade com Cliente, e Cliente com Pedido.