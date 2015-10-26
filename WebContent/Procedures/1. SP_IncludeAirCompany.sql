Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_IncludeAirCompany') drop procedure SP_IncludeAirCompany
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Rodrigo Dias
-- Create date: 2015-10-03
-- Description:	Include AirCompany.
-- =============================================
CREATE PROCEDURE SP_IncludeAirCompany
	
	@nameCompany		VARCHAR(MAX)
	,@originCountry		VARCHAR(MAX)
AS
BEGIN
	
	insert into Project_Airport_2015.dbo.AirCompany (nameCompany, originCountry) 
		values (@nameCompany,@originCountry)

END
GO

