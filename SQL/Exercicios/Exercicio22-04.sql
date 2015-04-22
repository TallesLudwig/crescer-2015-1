
--1)Selecione o nome do empregado e nome do departamento que cada um est� associado.


select e.NomeEmpregado, d.NomeDepartamento
from Empregado as e
inner join Departamento as d on d.IDDepartamento = e.IDDepartamento


--2)Exibir o nome do associado e sua cidade, exibir tamb�m associados sem Cidade relacionada.
select a.Nome, c.Nome
from Associado as a
left join Cidade as c on c.IDCidade = a.IDCidade

--3)Lista os estados (UF) e total de cidades que n�o possuem associados relacionados (dica: pode ser 
--utilizado count + group by + exists).

select c.UF, count(c.Nome) as Cidades_sem_assoc
from cidade as c
left join  Associado as a on a.IDCidade = c.IDCidade
where c.Nome not in( 
					select c.Nome
				   	from Associado as a
					inner join Cidade as c on c.IDCidade = a.IDCidade )
group by c.UF


--4)Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a
-- cidade � da regi�o SUL (RS, SC, PR), se for imprimir *** (3 asteriscos)


select a.Nome, c.Nome, 
	CASE 
	when c.UF in('RS', 'SC', 'PR') then '***'
	else null
	end as aqui
from Associado as a
left join Cidade as c on c.IDCidade = a.IDCidade


--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.

Select e.NomeEmpregado as NomeEmpregado, d.NomeDepartamento,
g.NomeEmpregado as NomeGerente, dg.NomeDepartamento
From Empregado as e
left join Departamento as d on d.IDDepartamento = e.IDDepartamento
left JOIN Empregado as g ON e.IDGerente = g.IDEmpregado
left join Departamento as dg on dg.IDDepartamento = g.IDDepartamento


--6)Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados que o departamento fique na localidade de
-- SAO PAULO, fa�a um reajuste de 14,5%


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

 
--7)Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio dos sal�rios de todos os empregados.

select  e.Salario, (e.Salario*0.145) as reajuste ,(e.Salario*1.145) as valorReajustado,  ((e.Salario*1.145) -e.Salario )
from Empregado as e
left join Departamento as d on d.IDDepartamento =e.IDDepartamento
where d.Localizacao = 'SAO PAULO'


select  sum((e.Salario*1.145) -e.Salario )
from Empregado as e
left join Departamento as d on d.IDDepartamento =e.IDDepartamento
where d.Localizacao = 'SAO PAULO'


--8)Liste o departamento que possui o empregado de maior sal�rio.
----PARAI AQUI _____


select d.NomeDepartamento
from Departamento as d
left join Empregado as e on e.IDDepartamento= d.IDDepartamento
group by d.NomeDepartamento,  e.Salario,e.NomeEmpregado
having  e.NomeEmpregado!= 'KING' and e.Salario= (select MAX(e.Salario) from Empregado as e ) 