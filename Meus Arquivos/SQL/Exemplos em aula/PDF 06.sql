BEGIN
	DECLARE @Nome VarChar(30)
	SET @Nome = 'CWI Software'
	Print @Nome
END

BEGIN
	DECLARE @vIDCliente int

		Select @vIDCliente = IDCliente
		From Cliente
		Where Nome = 'Mariana Ventura Che'

	Print 'Mariana possui o código ' + Cast(@vIDCliente AS VarChar(10)) --convertendo o int para varchar, se não tentaria somar com a frase 
END


BEGIN
	SET NOCOUNT ON

	DECLARE @vTamanho int

	--Busca o maior nome (caracteres)

		Select @vTamanho = MAX(Len(Nome))
		From Cliente

	--Lista todos os clientes cfe tamanho do nome

		Select IDCliente, Nome
		From Cliente
		Where Len(Nome) = @vTamanho

	SET NOCOUNT OFF
END

BEGIN
	DECLARE @vCount int
		Select @vCount = COUNT(1)
		From Cliente

		IF (@vCount=0)
			Print 'Nenhum cliente cadastrado.'
		ELSE IF (@vCount=1)
			Print 'Um registro encontrado.'
		ELSE
			Print 'Muitos registros encontrados.' --  + Cast(@vCount AS VarChar(10))
END


BEGIN
	DECLARE @vCount int
		Select @vCount = COUNT(1)
		From Cliente

		IF(@vCount=0) BEGIN
			Print 'Nenhum cliente cadastrado.'
			Print 'Execute o procedimento de carga'
		END ELSE IF (@vCount=1)
			Print 'Um registro encontrado.'
		ELSE
			Print 'Muitos registros encontrados.'
END

BEGIN
	DECLARE @vCount int
	SET @vCount = 0

	WHILE(@vCount<10) BEGIN
		SET @vCount = @vCount + 1
		Print 'Executou loop: '+ Cast(@vCount as Varchar(10) )
	END
END

BEGIN
	BEGIN TRY
	Begin Transaction

	Set Identity_Insert Cidade ON;

	Insert into Cidade (IDCidade, Nome, UF)
		 Values (1, 'Morro da Pedra', 'RS');
		
	Commit
	END TRY

	BEGIN CATCH
		If @@TRANCOUNT > 0 Rollback; --Se existir alguma transacao
		Print ERROR_MESSAGE()
	END CATCH
END


BEGIN
	BEGIN TRY
	Declare		@vRazaoSocial VarChar(50),
				@vNome VarChar(50)
				Set @vRazaoSocial = 'CWI Software Ltda'

		Select @vNome = Nome
		From Cliente
		Where RazaoSocial = @vRazaoSocial
		
		If @@ROWCOUNT= 0 --Numero de linhas do Select anterior
			RAISERROR('Registro "%s" nao foi encontrado!', 16, 1, @vRazaoSocial)
		
		Print 'Nome encontrado! ['+ @vNome + ']'
	END TRY
	BEGIN CATCH
		Print 'Error Code: '+ CAST(ERROR_NUMBER() AS VARCHAR(100))
		Print 'Error Text: '+ ERROR_MESSAGE()
	END CATCH
END


BEGIN
	DECLARE @vID int
		Select @vID = COUNT(1)
		From Cliente
		Where IDCliente in (1,2,3)
	Print @vID
END




BEGIN
	DECLARE ListaCidade CURSOR
		Local
		Fast_Forward
		FOR Select Nome, Uf
			From Cidade
			Group by Nome, Uf
			Having COUNT(1) > 1;

	DECLARE @vNome varchar(50),
			@vUF varchar(2)

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN
			Print @vNome + '/'+@vUF;
			FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
		END


	CLOSE ListaCidade;

	DEALLOCATE ListaCidade;-- liberar a memoria 
END





























