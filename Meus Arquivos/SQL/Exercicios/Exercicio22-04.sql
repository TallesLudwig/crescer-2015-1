
--1)Selecione o nome do empregado e nome do departamento que cada um está associado.


select e.NomeEmpregado, d.NomeDepartamento
from Empregado as e
inner join Departamento as d on d.IDDepartamento = e.IDDepartamento


--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--2)Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
select a.Nome, c.Nome
from Associado as a
left join Cidade as c on c.IDCidade = a.IDCidade


begin transaction
go
update Cidade
set Nome = replace(nome, '*', '') -- SUBSTRING(nome,2, len(nome))
where nome like '*%'
commit



--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--3)Lista os estados (UF) e total de cidades que não possuem associados relacionados (dica: pode ser 
--utilizado count + group by + exists).

select c.UF, count(c.Nome) as Cidades_sem_assoc
from cidade as c
left join  Associado as a on a.IDCidade = c.IDCidade
where c.Nome not in( 
					select c.Nome
				   	from Associado as a
					inner join Cidade as c on c.IDCidade = a.IDCidade )
group by c.UF



----OU resposta do andre---


select c.UF, count(1) as Cidades_sem_assoc
from cidade as c
left join  Associado as a on a.IDCidade = c.IDCidade
where not exists( 
					select 1
				   	from Associado as a
					where c.IDCidade = a.IDCidade )
group by c.UF


--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--4)Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a
-- cidade é da região SUL (RS, SC, PR), se for imprimir *** (3 asteriscos)


select a.Nome, c.Nome, 
	CASE 
	when c.UF in('RS', 'SC', 'PR') then '***'
	else null
	end as aqui
from Associado as a
left join Cidade as c on c.IDCidade = a.IDCidade


--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.

Select e.NomeEmpregado as NomeEmpregado, d.NomeDepartamento,
g.NomeEmpregado as NomeGerente, dg.NomeDepartamento
From Empregado as e
left join Departamento as d on d.IDDepartamento = e.IDDepartamento
left JOIN Empregado as g ON e.IDGerente = g.IDEmpregado
left join Departamento as dg on dg.IDDepartamento = g.IDDepartamento


--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--6)Faça uma cópia da tabela Empregado e altere o salário de todos os empregados que o departamento fique na localidade de
-- SAO PAULO, faça um reajuste de 14,5%


select * into copiaEmpregados from Empregado

update copiaEmpregados 
set Salario= Salario*1.145
 where IDEmpregado in (
select e.IDEmpregado
from Empregado as e
left join Departamento as d on d.IDDepartamento =e.IDDepartamento
where d.Localizacao = 'SAO PAULO'
 )


 select * from Empregado
  select * from copiaEmpregados



--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ 
--7)Liste a diferença que representará o reajuste aplicado no item anterior no somatório dos salários de todos os empregados.

select  e.Salario, (e.Salario*0.145) as reajuste ,(e.Salario*1.145) as valorReajustado,  ((e.Salario*1.145) -e.Salario )
from Empregado as e
left join Departamento as d on d.IDDepartamento =e.IDDepartamento
where d.Localizacao = 'SAO PAULO'


select  sum((e.Salario*1.145) -e.Salario )
from Empregado as e
left join Departamento as d on d.IDDepartamento =e.IDDepartamento
where d.Localizacao = 'SAO PAULO'




--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--8)Liste o departamento que possui o empregado de maior salário.



select d.NomeDepartamento
from Departamento as d
left join Empregado as e on  e.Salario in (select MAX(ee.Salario) from Empregado as ee where ee.IDEmpregado !=7839 ) 
where d.IDDepartamento = e.IDDepartamento
group by d.NomeDepartamento




--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--9)Faça uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados
--(nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta.

select a.Nome as Nome_Associado, c.Nome as Cidade_Associado 
from Associado as a
left join Cidade as c on c.IDCidade = a.IDCidade
union
select e.NomeEmpregado as Nome_Empregado, cc.Nome as Cidade_Empregado
from Empregado as e
left join Departamento as d  on d.IDDepartamento = e.IDDepartamento
left join Cidade as cc on cc.Nome = d.Localizacao 




--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
--10)Lista as cidades que tenham associado relacionado.

select c.nome
from Cidade as c
inner join Associado as a on a.IDCidade= c.IDCidade
