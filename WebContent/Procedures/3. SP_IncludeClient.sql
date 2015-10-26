Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_IncludeClient') drop procedure SP_IncludeClient
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Rodrigo Dias
-- Create date: 2015-10-03
-- Description:	Include Client.
-- =============================================
CREATE PROCEDURE SP_IncludeClient
	
	@CPF				CHAR(11)
	,@treatmentClient	VARCHAR(5)
	,@nameClient		VARCHAR(MAX)
	,@lastNameClient	VARCHAR(MAX)
	,@emailClient		VARCHAR(MAX)
	,@birthDate			DATETIME
	,@telephoneClient	VARCHAR(MAX)

AS
BEGIN
	
	insert into Project_Airport_2015.dbo.Client (CPF, treatmentClient, nameClient, lastNameClient, emailClient, birthDate, telephoneClient) 
		values (@CPF,@treatmentClient,@nameClient,@lastNameClient,@emailClient,@birthDate,@telephoneClient)
END
GO