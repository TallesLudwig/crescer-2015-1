--1)Faça uma consulta (query) que retorne apenas o primeiro nome do Associado (tabela associado).

select  SUBSTRING(nome,1 ,charindex( ' ', nome,1) ) NOME from Associado

--2)Faça uma consulta que retorne o nome dos associados e a idade de cada um (em anos, exibir um número inteiro).

select nome, FLOOR(DATEDIFF(DAY, DataNascimento, GETDATE()) / 365.25)
from Associado


--3)Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. Exibir também o total de 
--meses de trabalho até a data de 31/12/2000.




select NomeEmpregado, FLOOR(DATEDIFF(MONTH, DataAdmissao, ('2000-12-31')))
from empregado
where DataAdmissao between CONVERT(datetime, '01/05/1980', 103) and CONVERT(datetime, '20/01/1982' , 103)




--4)Qual o cargo (tabela empregado) possuir mais empregados?

select top 1 cargo, count(IDEmpregado) as numero_EMpregados
from empregado
group by cargo
order by count(IDEmpregado) desc;




--5)Qual é o associado de maior nome (número de caracteres) ?

select nome
from Associado
where len(nome) = (select max(len(nome)) from Associado );


--6)Faça uma consulta que retorne o nome do associado e a data de quando cada completará (ou completou) 50 anos,
-- liste também o dia da semana.


select nome, year(DataNascimento)+50 as aniversario_50, datename(dw,(year(DataNascimento)+50)) as DiaAniversario_50
from Associado



--7)Liste a quantidade de cidades agrupando por UF.

select count(nome), uf
from cidade
group by UF



--8)Liste as cidades que possuem o mesmo nome e UF.

select nome
from cidade
GROUP by nome, uf
HAVING count(1)>1



--9)Identifique qual deve ser o próximo ID para a criação de um novo registro na tabela Associado (maior + 1).

select (COUNT(IDAssociado) +1) 
from associado

--10)Limpe a tabela CidadeAux, e insira somente as cidades com nomes e UF’s distintos, considere somente o
-- menor código ID das cidades duplicadas.

Truncate table CidadeAux;

INSERT into CidadeAux 


SELECT *
from cidade
where nome  in (select Nome
				from cidade
				GROUP by Nome
				having count(UF)=1)


or			
--apartir daqui travei

select idcidade,  nome from cidade 
where nome in(
				select  Nome
				from cidade
				GROUP by  Nome
				having count( UF)!=1
				)

order by nome


--11)Altere todas cidades duplicadas (nome e uf iguais), acrescente no ínicio do nome um asterisco (*).

--12)Faça uma consulta que liste o nome do Associado e a descrição da coluna Sexo, informando: Masculino ou Feminino.

--13)Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de Renda, 
--considerando a tabela abaixo:
--Até R$ 1.164,00 = 0%De R$ 1.164,00 a R$ 2.326,00 = 15%
--Acima de R$ 2.326,00 = 27,5%.

--14)Elimine as cidades duplicadas (mantendo 1 registro para cada).

--15)Adicione uma regra que impeça exista mais de uma cidade com o mesmo nome em um estado.
