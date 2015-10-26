Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_ConsultFlights') drop procedure SP_ConsultFlights
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE SP_ConsultFlightsJSon
	@boardingFlight	varchar(max)
	,@landingFlight	varchar(max)
AS
BEGIN
	select 
		a.flightID
		,a.airplaneID
		,a.boardingFlight
		,a.landingFlight
		,a.timeFlight
		,a.priceFlight
		,count(seatName) as QtySeats
	from Project_Airport_2015.dbo.Flight a
	inner join Project_Airport_2015.dbo.Seats b
	on a.flightID = b.flightID
	where b.seat_St = 'A'
	and a.boardingFlight = @boardingFlight and a.landingFlight = @landingFlight
	group by a.flightID,a.airplaneID,a.boardingFlight,a.landingFlight,a.timeFlight,a.priceFlight
	order by a.flightID
END
GO
