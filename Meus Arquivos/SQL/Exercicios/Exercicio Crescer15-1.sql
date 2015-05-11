--1) Identifique e liste quantos valores diferentes est�o definidos para a coluna Situacao da tabela Produto 
--(somente os distintos valores).

select count(distinct p.Situacao)
from Produto as p

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
					)

--2

select p.IDProduto, p.Nome
from Produto as p
where not exists (select 1
						from PedidoItem
						where PedidoItem.IDProduto = p.IDProduto
						);
			
			
			--IDEX--
create index IX_PedidoItem_Produto on PedidoItem(IDProduto)
drop index PedidoItem.IX_PedidoItem_Produto


--5) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente),
-- liste tamb�m qual o Estado possu� o menor n�mero de clientes.
--Dica: pode (n�o � obrigat�rio) ser utilizado subquery, e tamb�m UNION.




select c.UF, count(1) as Numero_clientes
from Cidade as c
left join Cliente as cl on cl.IDCidade= c.IDCidade
group by c.UF
HAVING count(1)=  (select top 1 count(1) as Numero_clientes
					from Cidade as c
					left join Cliente as cl on cl.IDCidade= c.IDCidade
					group by c.UF
					order by count(1) desc)

UNION
select c.UF, count(1) as Numero_clientes
from Cidade as c
left join Cliente as cl on cl.IDCidade= c.IDCidade
group by c.UF
HAVING count(1)=  (select top 1 count(1) as Numero_clientes
					from Cidade as c
					left join Cliente as cl on cl.IDCidade= c.IDCidade
					group by c.UF
					order by count(1))

----2------
create view vwEstados as 
select c.UF, count(1) as Numero_clientes
from Cidade as c
left join Cliente as cl on cl.IDCidade= c.IDCidade
group by c.UF;


select *
from vwEstados 
where Numero_clientes = (select max(vwEstados.Numero_clientes) from vwEstados)
or Numero_clientes = (select Min(vwEstados.Numero_clientes) from vwEstados)




--6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
--Dica: ser� preciso relacionar Cidade com Cliente, e Cliente com Pedido.

select count(c.IDCidade)
from Cidade as c
where c.IDCidade in ( select distinct c.IDCidade
					from Cidade as c
					inner join Cliente as cl on cl.IDCidade= c.IDCidade
					inner join Pedido as p on p.IDCliente=cl.IDCliente)


		--------2---------


select count(c.IDCidade)
from Cidade as c
where exists ( select 1
					from Cliente as cl
					inner join Pedido as p on p.IDCliente=cl.IDCliente
					where cl.IDCidade = c.IDCidade)



--7) Dentro da atual estrutura, cada produto � composto por 1 ou v�rios materiais (tabela ProdutoMaterial).
-- Identifique se existe algum produto sem material relacionado.
--Obs.: o produto criado anteriormente dever� ser listado.

select p.Nome
from Produto as p
left join ProdutoMaterial as pm on pm.IDProduto=p.IDProduto
where  pm.IDProduto is null
-----2-----

select p.Nome
from Produto as p
where not exists ( select 1
					from ProdutoMaterial pm
					where pm.IDProduto = p.IDProduto
					)




--8) Liste os produtos, com seu pre�o de custo, e relacione com seus os materiais (ProdutoMaterial),
-- e liste tamb�m o somat�rio do PrecoCusto de todos seus materiais.
--------------------Rever----------------------

select p.IDProduto, p.Nome, p.PrecoCusto, sum(m.PrecoCusto * isnull(pm.Quantidade,1)) Preco_materiais 
from Produto as p
left join ProdutoMaterial as pm on pm.IDProduto = p.IDProduto
left join Material as m on m.IDMaterial = pm.IDMaterial

group by p.IDProduto, p.Nome, p.PrecoCusto
having p.PrecoCusto< sum(m.PrecoCusto * pm.Quantidade)

--9) Ap�s identificar o pre�o de custo dos produtos e seus materiais ser� preciso acertar os produtos 
--que est�o com o valor de custo inferior ao custo dos materiais. Pra isso fa�a uma altera��o (update)
-- na tabela de Produtos, definindo o PrecoCusto, para que fique igual ao custo dos seus materiais.

begin transaction
go

rollback
commit
select * from Produto

update Produto
SET Produto.PrecoCusto  = ( select sum(m.PrecoCusto * pm.Quantidade) 
						from Produto as p
						left join ProdutoMaterial as pm on pm.IDProduto = p.IDProduto
						left join Material as m on m.IDMaterial = pm.IDMaterial
						group by p.IDProduto, p.Nome, p.PrecoCusto)
where Produto.PrecoCusto  < ( select sum(m.PrecoCusto * pm.Quantidade) 
						from Produto as p
						left join ProdutoMaterial as pm on pm.IDProduto = p.IDProduto
						left join Material as m on m.IDMaterial = pm.IDMaterial
						group by p.IDProduto, p.Nome, p.PrecoCusto)
and Produto.IDProduto = ( select p.IDProduto
						from Produto as p
						left join ProdutoMaterial as pm on pm.IDProduto = p.IDProduto
						left join Material as m on m.IDMaterial = pm.IDMaterial
						group by p.IDProduto, p.Nome, p.PrecoCusto)

--------------------ATE AQUI----------------------


--10) Liste os clientes que tenham o mesmo nome (Tabela Cliente, registros com o nome (apenas) duplicado).

select c.Nome, count(c.Nome)
from Cliente as c
group by c.nome
having count(c.Nome) >1


--11) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.

select  top 1 SUBSTRING(c.nome,1 ,charindex( ' ', c.nome,1) ) as nome, count(1) Frequencia_do_nome
from Cliente as c
group by SUBSTRING(c.nome,1 ,charindex( ' ', c.nome,1) )
order by count(1) desc





--12) Liste qual o produto � mais vendido (considere a informa��o da quantidade).


select top 1 p.nome
from Produto as p
left join  PedidoItem as pi on pi.IDProduto = p.IDProduto
order by pi.Quantidade desc