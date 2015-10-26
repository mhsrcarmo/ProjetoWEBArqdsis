package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.TOFactory;
import to.AirplaneTO;
import model.Airplane;

public abstract class AirplaneDAO {
	
	public abstract Connection conectar() throws SQLException;

	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	public AirplaneTO cadastrarAeronave(int airCompanyID, int qtySeats, String modelAirplane) throws Exception  {	
		String sqlCadastrar = "exec SP_RegisterAirplane ?, ?, ?, ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		AirplaneTO to = TOFactory.getAirplaneTO();
		
		try{
			conn = conectar();
			pst = conn.prepareStatement(sqlCadastrar); 
				
			pst.setInt(1, airCompanyID);
			pst.setInt(2, qtySeats);
			pst.setString(3, modelAirplane);
			pst.executeUpdate();  			
			
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		} finally {
			if(rs != null){
				try{
					rs.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(pst != null){
				try{
					pst.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(conn != null){
				try{
					desconectar(conn);
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
		}
		
		return to;
	}

	public AirplaneTO excluirAeronave(int airplaneID ) throws Exception{	
		String sqlDeletar = "exec SP_DeleteAirplane ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		AirplaneTO to = TOFactory.getAirplaneTO();
			
		try{
			pst = conn.prepareStatement(sqlDeletar);
			pst.setInt(1, airplaneID);
			pst.executeUpdate();  			
			
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		} finally {
			if(rs != null){
				try{
					rs.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(pst != null){
				try{
					pst.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(conn != null){
				try{
					desconectar(conn);
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
		}
		
		return to;
	}


	public AirplaneTO alterarAeronave(int airplaneID, int airCompanyID, int qtySeats, String modelAirplane) throws Exception{	
		String sqlAlterar = "exec SP_ChangeAirplane?,?,?,?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		AirplaneTO to = TOFactory.getAirplaneTO();
			
		try{
			pst = conn.prepareStatement(sqlAlterar);
			pst.setInt(1, airCompanyID);
			pst.setInt(2, qtySeats);
			pst.setString(3, modelAirplane);
			pst.executeUpdate();  			
		
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		} finally {
			if(rs != null){
				try{
					rs.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(pst != null){
				try{
					pst.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(conn != null){
				try{
					desconectar(conn);
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
		}
		
		return to;
	}

	public AirplaneTO consultarAeronave(int airplaneID) {
		String sqlConsultar = "exec SP_ConsultAirplane ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Airplane aeronave = new Airplane();
		AirplaneTO to = TOFactory.getAirplaneTO();
		
		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlConsultar);
			pst.setInt(1, airplaneID);
			rs = pst.executeQuery();
			while(rs.next()){
				aeronave.setAirplaneID (rs.getInt(2));
				aeronave.setAirCompanyID(rs.getInt(3));
				aeronave.setQtySeats(rs.getInt(4));
				aeronave.setModelAirplane(rs.getString(5));	
				to.add(aeronave);	
			}
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		} finally {
			if(rs != null){
				try{
					rs.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(pst != null){
				try{
					pst.close();
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
			if(conn != null){
				try{
					desconectar(conn);
				} catch(SQLException sqe){
					sqe.printStackTrace();
				}
			}
		}
		return to;
	}
}
