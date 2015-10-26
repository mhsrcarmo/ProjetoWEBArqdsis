Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'Airplane') drop table Project_Airport_2015.dbo.Airplane
go
CREATE TABLE Airplane
(
airplaneID		INT				IDENTITY(1,1),
airCompanyID	INT				NOT NULL,
qtySeats		INT				NOT NULL,
modelAirplane	VARCHAR(100)	NOT NULL,
airplane_St		CHAR(1)			NOT NULL,
registerTime	DATETIME		DEFAULT GETDATE()

PRIMARY KEY (airplaneID)
FOREIGN KEY (airCompanyID) REFERENCES AirCompany(airCompanyID)
);