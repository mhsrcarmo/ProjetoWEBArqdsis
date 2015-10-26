Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_IncludeAirplane') drop procedure SP_IncludeAirplane
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Rodrigo Dias
-- Create date: 2015-10-03
-- Description:	Include Airplane.
-- =============================================
CREATE PROCEDURE SP_IncludeAirplane
	
	@airCompanyID		INT
	,@qtySeats			INT
	,@modelAirplane		VARCHAR(MAX)
AS
BEGIN
	
	insert into Project_Airport_2015.dbo.Airplane (airCompanyID, qtySeats, modelAirplane, airplane_St) 
		values (@airCompanyID,@qtySeats,@modelAirplane,'A')

END
GO

