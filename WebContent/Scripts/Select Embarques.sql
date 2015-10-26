select
	cityAirport + ', ' + airportName 
from Project_Airport_2015.dbo.Airport

select distinct boardingFlight from Flight


-- CONSULTA PARA BUSCAR OS DESTINOS.
select landingFlight from Flight where boardingFlight = 'Confins, Aeroporto Internacional de Minas - Tancredo Neves'


select * from Flight where boardingFlight = 'Guarulhos, Aeroporto Internacional de Guarulhos' and landingFlight = 'Belém, Aeroporto Internacional de Belém - Val de Cans'


select * from Project_Airport_2015.dbo.flight



select * from seats


-- SELECT VOOS CONTENDO QUANTIDADES DE ASSENTOS DISPONIVEIS
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
	--where b.seat_St = 'A' and boardingFlight = @boardingFlight and landingFlight = @landingFlight
	group by a.flightID,a.airplaneID,a.boardingFlight,a.landingFlight,a.timeFlight,a.priceFlight
	order by a.flightID