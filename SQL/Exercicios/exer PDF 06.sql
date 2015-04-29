--1)

begin
declare
	 @Idproduto		integer,
	 @nome			Varchar(100),
	@total_itens	integer
	
	
	select top 1
	@Idproduto= pit.idproduto,
	@nome= p.Nome, 
	@total_itens=sum(quantidade) 
	 
	 from PedidoItem as pit
	 inner join Produto as p on p.IDProduto=pit.IDProduto
	group by pit.idproduto, p.Nome
	order by  sum(quantidade)  desc

	print 'Produto: ' + @nome + ' Total Vendas '  +cast(@total_itens as varchar(10))

	end;

--2)Liste as cidades com nome e UF duplicados que tenham clientes relacionados.



BEGIN
	DECLARE ListaCidadeDupli CURSOR	Local Fast_Forward


	FOR Select	c.Nome, 
				c.Uf
			From Cidade as c
			Group by c.Nome, c.Uf
			Having COUNT(1) > 1;


	DECLARE @vNome varchar(50),
			@vUF varchar(2),
			@total integer

	OPEN ListaCidadeDupli;
	FETCH NEXT FROM ListaCidadeDupli INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN
		
		select @total = count(1)
		from Cliente cli
		where exists (select 1
						from cidade as c 
						where c.IDCidade= cli.IDCidade
						and c.Nome = @vNome
						and c.UF = @vUF )
		if @total >0
			Print @vNome + '/'+@vUF+' Total de clientes '+cast(@total as varchar(10));


			FETCH NEXT FROM ListaCidadeDupli INTO @vNome, @vUF
	END


	CLOSE ListaCidadeDupli;
	DEALLOCATE ListaCidadeDupli;-- liberar a memoria 
END







--3)Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados, 
--com produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.


select COUNT(distinct ped.IDPedido) as total_pedidos,
		count(1) as  total_itens
from Pedido as ped
	inner join PedidoItem as pit on pit.IDPedido = ped.IDPedido
where  exists (select 1 
				from ProdutoMaterial as pm
				where pm.IDProduto=pit.IDProduto	
				and		pm.IDMaterial in (select IDMaterial from vwMaterial_Mais_Usado ));






select pro.IDProduto, pro.Nome
from Produto as pro
where exists(	select 1 
				from ProdutoMaterial as pm
				where pm.IDProduto = pro.IDProduto
				and pm.IDMaterial in (select IDMaterial from vwMaterial_Mais_Usado)
				);





create view vwMaterial_Mais_Usado as 
select top 1 with ties 
		ma.IDMaterial,
		ma.Descricao, 
		count(distinct pm.IDProduto) as total
from Material as ma
	inner join ProdutoMaterial as pm on pm.IDMaterial = ma.IDMaterial
	inner join Produto as pr on pr.IDProduto= pm.IDProduto
group by ma.IDMaterial, ma.Descricao
order by total desc






select	p.IDPedido, 
		pit.IDPedidoItem, 
		pro.IDProduto, pro.Nome, 
		pit.Quantidade
from pedido as p
	inner join PedidoItem as pit on pit.IDPedido = p.IDPedido
	inner join Produto as pro on pro.IDProduto=pit.IDProduto
	--inner join ProdutoMaterial as pm on pm.IDProduto=pro.IDProduto
where p.DataPedido between DATEADD(day,-60, getdate()) and getdate();


create index IX_Pedido_DataPedido on pedido(DataPedido);








