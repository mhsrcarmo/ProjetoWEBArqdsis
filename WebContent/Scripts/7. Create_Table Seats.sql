Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'Seats') drop table Project_Airport_2015.dbo.Seats
go
CREATE TABLE Seats
(
flightID		INT,
seatName		VARCHAR(6)	NOT NULL,
seatType		VARCHAR(20) NOT NULL,
seat_St			CHAR(1)		NOT NULL,
registerTime	DATETIME	DEFAULT GETDATE()

PRIMARY KEY (flightID,seatName),
FOREIGN KEY (flightID) REFERENCES Flight(flightID)
);