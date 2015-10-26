package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.LoginTO;
import model.Login;

public abstract class LoginDAO {
	
	public abstract Connection conectar() throws SQLException;

	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
	public LoginTO validarLogin(String userLogin, String passwordLogin){
		
		String sqlConsultar = "SELECT * from airplane where aeronaveID = ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Login login =new Login();
		LoginTO to = new LoginTO();
		
		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlConsultar);
			pst.setString(1, userLogin);
			pst.setString(2, passwordLogin);
			
			rs = pst.executeQuery();
			while(rs.next()){
				login.setUserLogin (rs.getString(4));
				login.setPasswordLogin(rs.getString(5));
				login.setTypeAccess(rs.getString(6));
				to.add(login);	
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
