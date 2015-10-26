Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_IncludeLogin') drop procedure SP_IncludeLogin
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Rodrigo Dias
-- Create date: 2015-10-03
-- Description:	Include LoginAccess.
-- =============================================
CREATE PROCEDURE SP_IncludeLogin
	
	@userLogin			VARCHAR(MAX)
	,@passwordLogin		VARCHAR(MAX)
	,@typeAccess		VARCHAR(MAX)

AS
BEGIN
	
	insert into Project_Airport_2015.dbo.LoginAccess (userLogin, passwordLogin, typeAccess)
		values (@userLogin,@passwordLogin,@typeAccess)

END
GO