Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_IncludeFlight') drop procedure SP_IncludeFlight
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Rodrigo Dias
-- Create date: 2015-10-03
-- Description:	Include Flight.
-- =============================================
CREATE PROCEDURE SP_IncludeFlight
	
	@airplaneID			INT
	,@boardingFlight	VARCHAR(MAX)
	,@landingFlight		VARCHAR(MAX)
	,@timeFlight		DATETIME
	,@priceFlight		DECIMAL

AS
BEGIN

	-- Verificar se o avião já não está ocupado com outro vôo neste mesmo dia e horário.
	if not exists (select * from Project_Airport_2015.dbo.FlightDetail where @airplaneID = airplaneID and @timeFlight = timeBoarding)
	begin

		insert into Project_Airport_2015.dbo.Flight (airplaneID,boardingFlight,landingFlight,timeFlight,priceFlight,flight_St)
			values (@airplaneID,@boardingFlight,@landingFlight,@timeFlight,@priceFlight,'A')

		declare @flightID int
		select @flightID = (select top 1 flightID from Project_Airport_2015.dbo.Flight order by registerTime desc)
		
		exec SP_IncludeSeats @flightID

	end
END
GO