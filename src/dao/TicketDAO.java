package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.TOFactory;
import model.Flight;
import model.Passenger;
import model.Ticket;
import to.FlightTO;
import to.TicketTO;

public abstract class TicketDAO {
	public abstract Connection conectar() throws SQLException;

	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	public TicketTO cadastrarPassagem(int clientID, int flightID,
			String seatName) throws Exception {
		String sqlCadastrar = "exec SP_IncludeTickets ?,?,?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		TicketTO to = TOFactory.getTicketTO();

		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlCadastrar);
			rs = pst.executeQuery();

			pst.setInt(1, clientID);
			pst.setInt(2, flightID);
			pst.setString(3, seatName);
			pst.executeUpdate();
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

	public TicketTO excluirPassagem(int flightID, String clientCPF,
			String seatName) throws Exception {
		String sqlDeletar = "exec SP_DeleteTickets ?,?,?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		TicketTO to = TOFactory.getTicketTO();

		try {
			pst = conn.prepareStatement(sqlDeletar);
			pst.setInt(1, flightID);
			pst.setString(1, clientCPF);
			pst.setString(1, seatName);
			pst.executeUpdate();
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

	public TicketTO alterarPassagem(int flightIDSearch, String clientCPFSearch,
			String seatNameSearch) throws Exception {
		String sqlAlterar = "exec SP_UpdateTickets ?,?,?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		TicketTO to = TOFactory.getTicketTO();

		try {
			pst = conn.prepareStatement(sqlAlterar);
			pst.setInt(1, flightIDSearch);
			pst.setString(1, clientCPFSearch);
			pst.setString(1, seatNameSearch);

			pst.executeUpdate();
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

	public TicketTO consultarPassagem(int flightID, String clientCPF,
			String seatName) throws Exception {

		String sqlConsultar = "Select from Ticket where flightID=?, cpf=?, seatName=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Ticket passagem = new Ticket();
		TicketTO to = TOFactory.getTicketTO();

		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlConsultar);
			pst.setInt(1, flightID);
			pst.setString(2, clientCPF);
			pst.setString(3, seatName);
			rs = pst.executeQuery();
			while (rs.next()) {
				passagem.setFlightID(rs.getInt(4));
				passagem.setClientCPF(rs.getString(5));
				passagem.setSeatName(rs.getString(6));

				to.add(passagem);
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

	public TicketTO listarTodasPassagem() throws Exception {
		String sqlListar = "Select * from ticket";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Ticket passagem = new Ticket();
		TicketTO to = TOFactory.getTicketTO();

		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlListar);
			rs = pst.executeQuery();
			while (rs.next()) {
				passagem.setFlightID(rs.getInt(1));
				passagem.setClientCPF(rs.getString(2));
				passagem.setSeatName(rs.getString(3));
				to.add(passagem);
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
