Use Project_Airport_2015
GO
if exists (select * from sys.objects where name = 'SP_IncludeSeats') drop procedure SP_IncludeSeats
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Rodrigo Dias
-- Create date: 2015-10-03
-- Description:	Include Seats.
-- =============================================
CREATE PROCEDURE SP_IncludeSeats
	
	@flightID		INT

AS
BEGIN

	declare @qtySeats int, @count int
	select @count = 1
	select @qtySeats = 
		(
			select b.qtySeats from Project_Airport_2015.dbo.Flight a
				inner join Project_Airport_2015.dbo.Airplane b
				on a.airplaneID = b.airplaneID
				where a.flightID = @flightID
		)

	declare @nameWindow int, @nameCenter int, @nameCorridor int, @seatName varchar(7)
	select @nameWindow = 1, @nameCenter = 1, @nameCorridor = 1, @seatName = ''
	loop:
		if @count <= @qtySeats
		begin
			if @nameWindow < 10
			begin
				select @seatName = 'A0' + convert(varchar(5),@nameWindow)
			end
			if @nameWindow >= 10
			begin
				select @seatName = 'A' + convert(varchar(5),@nameWindow)
			end
			insert into Project_Airport_2015.dbo.Seats (flightID,seatName,seatType,seat_St)
				values (@flightID,@seatName,'Window','A')
			select @nameWindow = @nameWindow + 1
			select @count = @count + 1
		end
		if @count <= @qtySeats
		begin
			if @nameCenter < 10
			begin
				select @seatName = 'B0' + convert(varchar(5),@nameCenter)
			end
			if @nameCenter >= 10
			begin
				select @seatName = 'B' + convert(varchar(5),@nameCenter)
			end
			insert into Project_Airport_2015.dbo.Seats (flightID,seatName,seatType,seat_St)
				values (@flightID,@seatName,'Center','A')
			select @nameCenter = @nameCenter + 1
			select @count = @count + 1
		end
		if @count <= @qtySeats
		begin
			if @nameCorridor < 10
			begin
				select @seatName = 'C0' + convert(varchar(5),@nameCorridor)
			end
			if @nameCorridor >= 10
			begin
				select @seatName = 'C' + convert(varchar(5),@nameCorridor)
			end
			insert into Project_Airport_2015.dbo.Seats (flightID,seatName,seatType,seat_St)
				values (@flightID,@seatName,'Corridor','A')
			select @nameCorridor = @nameCorridor + 1
			select @count = @count + 1
			goto	loop
		end

END
GO