--1-
Select  NomeEmpregado
From Empregado
order by DataAdmissao;

--2-
Select  NomeEmpregado, salario
From Empregado
where Cargo= 'Atendente'
or (salario*12) < 18.500


--3-
Select  IDCidade
From Cidade
where Nome='Uberlândia'



--4-
Select  IDCidade, Nome
From Cidade
where UF= 'RS'

