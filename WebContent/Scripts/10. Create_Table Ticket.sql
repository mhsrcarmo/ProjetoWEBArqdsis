Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'Ticket') drop table Project_Airport_2015.dbo.Ticket
go
CREATE TABLE Ticket
(
ticketID		INT			IDENTITY(1,1),
clientID		INT			NOT NULL,
flightID		INT			NOT NULL,
seatName		VARCHAR(6)	NOT NULL,
ticketType		VARCHAR(7)	NOT NULL,
registerTime	DATETIME	DEFAULT GETDATE()

PRIMARY KEY (ticketID),
FOREIGN KEY (clientID) REFERENCES Client(clientID),
);