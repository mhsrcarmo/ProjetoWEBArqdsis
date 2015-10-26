Use Project_Airport_2015
go
if exists (select * from sys.objects where name = 'AirCompany') drop table Project_Airport_2015.dbo.AirCompany
go
CREATE TABLE AirCompany
(
airCompanyID INT IDENTITY(1,1),
nameCompany VARCHAR(100) NOT NULL,
originCountry VARCHAR(100) NOT NULL

PRIMARY KEY (airCompanyID)
)