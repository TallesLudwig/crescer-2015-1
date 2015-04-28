--2)Liste as cidades com nome e UF duplicados que tenham clientes relacionados.

BEGIN
	DECLARE ListaCidadeDupli CURSOR
		Local
		Fast_Forward
		FOR Select c.Nome, c.Uf
			From Cidade as c
			inner join Cliente as cl on c.IDCidade= cl.IDCidade 
			Group by c.Nome, c.Uf
			Having COUNT(1) > 1;

	DECLARE @vNome varchar(50),
			@vUF varchar(2)

	OPEN ListaCidadeDupli;
	FETCH NEXT FROM ListaCidadeDupli INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN
			Print @vNome + '/'+@vUF;
			FETCH NEXT FROM ListaCidadeDupli INTO @vNome, @vUF
		END


	CLOSE ListaCidadeDupli;
	DEALLOCATE ListaCidadeDupli;-- liberar a memoria 
END




--3)Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados, 
--com produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.


select top 1 pm.IDMaterial
from ProdutoMaterial as PM
inner join Material as m on m.IDMaterial = PM.IDMaterial
inner join Produto as p on p.IDProduto = pm.IDProduto
group by pm.IDMaterial
order by count(pm.IDMaterial) desc

select count(p.IDPedido)
from Pedido as p
inner join PedidoItem as pi on pi.IDPedido = p.IDPedido
inner join Produto as pr on pr.IDProduto= pi.IDProduto
where  pr.IDProduto=18344;









BEGIN
	DECLARE ListaMatarialUsado CURSOR
		Local
		Fast_Forward
		FOR select top 1 pm.IDMaterial
			from ProdutoMaterial as PM
			inner join Material as m on m.IDMaterial = PM.IDMaterial
			group by pm.IDMaterial, m.Descricao
			order by count(pm.IDMaterial) desc

	DECLARE @vIDmateriar int


	OPEN ListaMatarialUsado;
	FETCH NEXT FROM ListaMatarialUsado INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN
			Print @vNome + '/'+@vUF;
			FETCH NEXT FROM ListaMatarialUsado INTO @vNome, @vUF
		END


	CLOSE ListaMatarialUsado;
	DEALLOCATE ListaMatarialUsado;-- liberar a memoria 
END
