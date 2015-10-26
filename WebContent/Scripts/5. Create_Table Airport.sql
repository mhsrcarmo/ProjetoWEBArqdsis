Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'Airport') drop table Project_Airport_2015.dbo.Airport
go
CREATE TABLE Airport
(
airportName			VARCHAR(100),
cityAirport			VARCHAR(100),
stateAirport		CHAR(2)			NOT NULL,
countryAirport		VARCHAR(100)	NOT NULL,
airport_St			CHAR(1)			NOT NULL

PRIMARY KEY CLUSTERED(airportName,cityAirport)
);