package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Seats;
import to.SeatsTO;
import factory.TOFactory;

public abstract class SeatsDAO {

	public abstract Connection conectar() throws SQLException;

	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	public SeatsTO listarAssentos(int flightIDSearch) throws Exception {
		String sqlConsultar = "exec  SP_IncludeSeats  ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Seats assento = new Seats();
		SeatsTO to = TOFactory.getSeatsTO();

		try {

			pst = conn.prepareStatement(sqlConsultar);
			pst.setInt(1, flightIDSearch);
			rs = pst.executeQuery();
			while (rs.next()) {

				assento.setSeatName(rs.getString(2));

				to.add(assento);
			}
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					desconectar(conn);
				} catch (SQLException sqe) {
					sqe.printStackTrace();
				}
			}
		}
		return to;
	}

}
