/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class FlightDAO {
   
    public ConnectionSQLServer connection;
    public Connection conn;

    public FlightDAO() {
		connection = new ConnectionSQLServer();
		try {
			conn = connection.openConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    
    public ArrayList<Flight> consultBoardingsRest(){
		String sqlConsult = "select distinct boardingFlight from Flight";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Flight> listBoardings = new ArrayList<Flight>();
		
		try{
			stm = conn.prepareStatement(sqlConsult);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Flight flight = new Flight();
				flight.setBoardingFlight(rs.getString(1));

				
				listBoardings.add(flight);
			}
			
			if(listBoardings.isEmpty()){
				listBoardings = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		return listBoardings;
	}
    
    public ArrayList<Flight> consultLandingsRest(String boardingFlight){
		String sqlConsult = "select landingFlight from Flight where boardingFlight = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Flight> listLandings = new ArrayList<Flight>();
		
		try{
			stm = conn.prepareStatement(sqlConsult);
                        stm.setString(1, boardingFlight);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Flight flight = new Flight();
				flight.setLandingFlight(rs.getString(1));

				
				listLandings.add(flight);
			}
			
			if(listLandings.isEmpty()){
				listLandings = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		return listLandings;
	}
    
    public ArrayList<Flight> consultFlightsRest(String boardingFlight, String landingFlight){
		String sqlConsult = "exec SP_ConsultFlights ?, ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Flight> listFlights = new ArrayList<Flight>();
		
		try{
			stm = conn.prepareStatement(sqlConsult);
                        stm.setString(1, boardingFlight);
                        stm.setString(2, landingFlight);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Flight flight = new Flight();
				flight.setFlightID(rs.getInt(1));
                                flight.setAirplaneID(rs.getInt(2));
                                flight.setBoardingFlight(rs.getString(3));
                                flight.setLandingFlight(rs.getString(4));
                                flight.setTimeFlight(rs.getString(5));
                                flight.setPriceFlight(rs.getBigDecimal(6));
				flight.setQtySeatsAvailable(rs.getInt(7));
                                
				listFlights.add(flight);
			}
			
			if(listFlights.isEmpty()){
				listFlights = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		return listFlights;
	}
}