--1)Fa�a uma consulta (query) que retorne apenas o primeiro nome do Associado (tabela associado).

select  SUBSTRING(nome,1 ,charindex( ' ', nome,1) ) NOME from Associado

--2)Fa�a uma consulta que retorne o nome dos associados e a idade de cada um (em anos, exibir um n�mero inteiro).

select nome, FLOOR(DATEDIFF(DAY, DataNascimento, GETDATE()) / 365.25)
from Associado


--3)Fa�a uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. Exibir tamb�m o total de 
--meses de trabalho at� a data de 31/12/2000.




select NomeEmpregado, FLOOR(DATEDIFF(MONTH, DataAdmissao, ('2000-12-31')))
from empregado
where DataAdmissao between '01/05/1980' and '20/01/1982' 

--4)Qual o cargo (tabela empregado) possuir mais empregados?

select top 1 cargo, count(IDEmpregado) as numero_EMpregados
from empregado
group by cargo
order by count(IDEmpregado) desc;




--5)Qual � o associado de maior nome (n�mero de caracteres) ?

select nome
from Associado
where len(nome) = (select max(len(nome)) from Associado );


--6)Fa�a uma consulta que retorne o nome do associado e a data de quando cada completar� (ou completou) 50 anos,
-- liste tamb�m o dia da semana.


select nome, year(DataNascimento)+50 as aniversario_50, datename(dw,(year(DataNascimento)+50)) as DiaAniversario_50
from Associado



--7)Liste a quantidade de cidades agrupando por UF.

select count(nome), uf
from cidade
group by UF



--8)Liste as cidades que possuem o mesmo nome e UF.

select nome, count(1)
from cidade
--having count(count(1)) >1
group by nome
order by count(1) desc


--9)Identifique qual deve ser o pr�ximo ID para a cria��o de um novo registro na tabela Associado (maior + 1).
--10)Limpe a tabela CidadeAux, e insira somente as cidades com nomes e UF�s distintos, considere somente o menor c�digo ID das cidades duplicadas.