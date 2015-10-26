Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'Flight') drop table Project_Airport_2015.dbo.Flight
go
CREATE TABLE Flight
(
flightID			INT				IDENTITY(1,1),
airplaneID			INT				NOT NULL,
boardingFlight		VARCHAR(100)	NOT NULL,
landingFlight		VARCHAR(100)	NOT NULL,
timeFlight			DATETIME		NOT NULL,
priceFlight			DECIMAL(6,2)	NOT NULL,
flight_St			CHAR(1)			NOT NULL,
registerTime		DATETIME DEFAULT GETDATE()

PRIMARY KEY (flightID)
FOREIGN KEY (airplaneID) REFERENCES Airplane(airplaneID)
);