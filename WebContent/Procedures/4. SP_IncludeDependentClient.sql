Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_IncludeDependentClient') drop procedure SP_IncludeDependentClient
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Rodrigo Dias
-- Create date: 2015-10-03
-- Description:	Include Client.
-- =============================================
CREATE PROCEDURE SP_IncludeDependentClient
	
	@clientCPF				CHAR(11)
	,@nameDependent			VARCHAR(MAX)
	,@lastNameDependent		VARCHAR(MAX)
	,@birthDateDependent	DATETIME

AS
BEGIN
	
	insert into Project_Airport_2015.dbo.DependentClient (clientCPF, nameDependent, lastNameDependent, birthDateDependent) 
		values (@clientCPF,@nameDependent,@lastNameDependent,@birthDateDependent)

END
GO