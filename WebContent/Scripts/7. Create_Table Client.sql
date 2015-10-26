Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'Client') drop table Project_Airport_2015.dbo.Client
go
CREATE TABLE Client
(
clientID		INT				IDENTITY(1,1),
CPF				CHAR(11)		NOT NULL,
treatmentClient	VARCHAR(100)	NOT NULL,	
nameClient		VARCHAR(100)	NOT NULL,
lastNameClient	VARCHAR(100)	NOT NULL,
emailClient		VARCHAR(100),
birthDate		DATETIME		NOT NULL,
telephoneClient	VARCHAR(100),
registerTime DATETIME DEFAULT GETDATE()

PRIMARY KEY (clientID)
);