select IDCliente , Nome
from Cliente
--1) Identifique e liste quantos valores diferentes est�o definidos para a coluna Situacao da tabela Produto 
--(somente os distintos valores).

select p.Situacao, count(p.situacao)
from Produto as p
group by p.Situacao

--2) Liste todos os clientes que tenham o LTDA no nome ou razao social.

select c.Nome
from Cliente as c
where c.Nome like '%Ltda%'
or c.RazaoSocial like '%Ltda%'



--3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
--Nome: Galocha Maragato
--Pre�o de custo: 35.67
--Pre�o de venda: 77.95
--Situa��o: A


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


--4) Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, 
--pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente dever� ser listado.

select p.Nome
from Produto as p
where p.Nome not in (select p.Nome
						from Produto as p
						inner join PedidoItem as ip on ip.IDProduto=p.IDProduto
						inner join Pedido as pe on pe.IDPedido= ip.IDProduto
)



--5) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente),
-- liste tamb�m qual o Estado possu� o menor n�mero de clientes.
--Dica: pode (n�o � obrigat�rio) ser utilizado subquery, e tamb�m UNION.

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
--Dica: ser� preciso relacionar Cidade com Cliente, e Cliente com Pedido.