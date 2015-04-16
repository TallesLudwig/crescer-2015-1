
/*
	Criar Tabelas 

*/
	Create table Cidade( 
		IDCidade	int not null,
		Nome		varchar(30) NOT NULL,
		UF			varchar(2) not null
		
	);
	
	drop table Cidade; --deletar tabela, não foi mostrado como alterar ainda
	
	Create table Cidade(
		IDCidade	int not null,
		Nome		varchar(30) NOT NULL,
		UF			varchar(2) not null,
		constraint PK_Cidade Primary Key (IDCidade),
		constraint UK_Cidade_Nome Unique (Nome)
	);






	Create table Cliente
	(
		IDCliente	int IDENTITY not null,
		Nome		varchar(30) NOT NULL,
		Endereco	varchar(35),
		Bairro		varchar(35),
		IDCidade	int
	);








	Create table Empregado
	(
	IDEmpregado int NOT NULL,
	Nome varchar(50)NOT NULL,
	Sexo char(1)NOT NULL,
	constraint PK_Empregado Primary Key (IDEmpregado),
	constraint CC_Empregado_Sexo Check (Sexo in('F','M'))
	);

	drop table Empregado;
	
	Create table Empregado
	(
	IDEmpregado int NOT NULL,
	Nome varchar(50)NOT NULL,
	Sexo char(1)NOT NULL,
	IDCidade int NOT NULL,
	constraint PK_Empregado Primary Key (IDEmpregado),
	constraint CC_Empregado_Sexo Check (Sexo in('F','M')),
	constraint FK_Empregado_Cidade Foreign Key (IDCidade)
	References Cidade (IDCidade)
	);




/**
	Insere valores nas tabelas
*/
		INSERT INTO Cidade Values (1,'Novo Hamburgo', 'RS');


		INSERT INTO Cliente
			(Nome, 
			Endereco, 
			Bairro)
		Values 
			('Maria',
			 'Rua Bento Gonçalves, 123',
			 'Centro' );

/**
	Busca os valores das tabelas
*/
select * from Cidade;
select * from Cliente;