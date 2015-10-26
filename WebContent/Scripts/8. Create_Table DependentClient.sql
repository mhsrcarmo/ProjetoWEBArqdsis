Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'DependentClient') drop table Project_Airport_2015.dbo.DependentClient
go
CREATE TABLE DependentClient
(
dependentID			INT				IDENTITY(1,1),
clientID			INT				NOT NULL,
nameDependent		VARCHAR(100)	NOT NULL,
lastNameDependent	VARCHAR(100)	NOT NULL,
birthDateDependent	DATETIME		NOT NULL,
registerTime		DATETIME		DEFAULT GETDATE()

PRIMARY KEY (dependentID)
FOREIGN KEY (clientID) REFERENCES Client(clientID)
);