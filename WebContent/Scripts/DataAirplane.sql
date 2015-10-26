Use Project_Airport_2015
go
exec SP_IncludeAirCompany 'Gol Linhas Aéreas','Brasil'
exec SP_IncludeAirCompany 'TAM Linhas Aéreas','Brasil'
exec SP_IncludeAirCompany 'Varig Linhas Aéreas','Brasil'

--insert into Project_Airport_2015.dbo.Airport (airportName,cityAirport,stateAirport,countryAirport,airport_St) values ('Aeroporto Internacional de Minas - Tancredo Neves','Confins','BH','Brasil','A')
--insert into Project_Airport_2015.dbo.Airport (airportName,cityAirport,stateAirport,countryAirport,airport_St) values ('Aeroporto Internacional de Belem - Val de Cans','Belem','PA','Brasil','A')
--insert into Project_Airport_2015.dbo.Airport (airportName,cityAirport,stateAirport,countryAirport,airport_St) values ('Aeroporto Internacional do RJ - Galeao','Rio de Janeiro','RJ','Brasil','A')
--insert into Project_Airport_2015.dbo.Airport (airportName,cityAirport,stateAirport,countryAirport,airport_St) values ('Aeroporto Internacional de Guarulhos','Guarulhos','SP','Brasil','A')
--insert into Project_Airport_2015.dbo.Airport (airportName,cityAirport,stateAirport,countryAirport,airport_St) values ('Aeroporto Internacional Salgado Filho','Porto Alegre','RS','Brasil','A')



declare @count int, @max int, @name varchar(100)
	select 
		@count = 1
		,@max  = 10


loop:
if @count <= @max
begin
	exec SP_IncludeAirplane 1,180,'Boing'
	exec SP_IncludeAirplane 2,180,'Boing'
	exec SP_IncludeAirplane 3,180,'Boing'
	select @count = @count + 1
	goto loop
end

select * from Project_Airport_2015.dbo.Airplane order by airCompanyID, airplaneID


exec SP_IncludeFlight 1,'Belém, Aeroporto Internacional de Belém - Val de Cans', 'Guarulhos, Aeroporto Internacional de Guarulhos', '20151025 21:00', '350'
exec SP_IncludeFlight 2,'Guarulhos, Aeroporto Internacional de Guarulhos', 'Belém, Aeroporto Internacional de Belém - Val de Cans', '20151025 21:00', '350'
exec SP_IncludeFlight 5,'Confins, Aeroporto Internacional de Minas - Tancredo Neves', 'Guarulhos, Aeroporto Internacional de Guarulhos', '20151025 21:00', '350'
exec SP_IncludeFlight 15,'Rio de Janeiro, Aeroporto Internacional do RJ - Galeão', 'Guarulhos, Aeroporto Internacional de Guarulhos', '20151025 21:00', '350'
exec SP_IncludeFlight 21,'Guarulhos, Aeroporto Internacional de Guarulhos', 'Porto Alegre, Aeroporto Internacional Salgado Filho', '20151025 21:00', '350'



