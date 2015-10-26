Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'LoginAccess') drop table Project_Airport_2015.dbo.LoginAccess
go
CREATE TABLE LoginAccess
(
userLogin			VARCHAR(100)		NOT NULL,
passwordLogin		VARCHAR(100)		NOT NULL,
typeAccess			VARCHAR(100)		NOT NULL,
registerTime		DATETIME			DEFAULT GETDATE()

PRIMARY KEY (userLogin)
);