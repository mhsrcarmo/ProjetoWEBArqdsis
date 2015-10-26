use master
go
if exists(select * from sys.databases where name = 'Project_Airport_2015') drop database Project_Airport_2015
go
CREATE DATABASE Project_Airport_2015