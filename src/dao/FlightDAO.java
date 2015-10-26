package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.FlightTO;
import model.Flight;
import factory.TOFactory;

public abstract class FlightDAO {

	public abstract Connection conectar() throws SQLException;

	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	public FlightTO cadastrarVoo(int airplaneID, String boardingFlight,
			String landingFligh, String dateFlight, String timeFlight,
			double priceFlight) {
		String sqlCadastrar = "exec airplaneID, boardingFlight, landingFlight, timeFlight, priceFlight ?,?,?,?,?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		FlightTO to = TOFactory.getFlightTO();

		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlCadastrar);
			rs = pst.executeQuery();

			pst.setInt(1, airplaneID);
			pst.setString(2, boardingFlight);
			pst.setString(3, landingFligh);
			pst.setString(4, dateFlight);
			pst.setString(5, timeFlight);
			pst.setDouble(6, priceFlight);
			pst.executeQuery();
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

	public FlightTO excluirVoo(int flightID) {
		String sqlDeletar = "exec airplaneID ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		FlightTO to = TOFactory.getFlightTO();

		try {
			pst = conn.prepareStatement(sqlDeletar);
			pst.setInt(1, flightID);
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

	public FlightTO alterarVoo(int flightIDSearch, String boardingFlight,
			String landingFlight, String dateFlight, String timeFlight,
			double priceFlight, String flight_St, int AirplaneID) {

		String sqlAlterar = "Update Flight set airplaneID = ?,boardingFlight = ?, landingFlight = ?,timeFlight = ?, priceFlight = ? where idVoo = ?  ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		FlightTO to = TOFactory.getFlightTO();
		try {
			pst = conn.prepareStatement(sqlAlterar);
			pst.setString(1, boardingFlight);
			pst.setString(2, landingFlight);
			pst.setString(3, dateFlight);
			pst.setString(4, timeFlight);
			pst.setDouble(5, priceFlight);
			pst.setString(6, flight_St);
			pst.setInt(7, AirplaneID);

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

	public FlightTO consultarVoo(String boardingFlight, String landingFlight, String dateFlight, String timeFlight) {
		String sqlConsultar = "exec  SP_ConsultFlight ?, ?, ?, ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Flight voo = new Flight();
		FlightTO to = TOFactory.getFlightTO();

		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlConsultar);
			pst.setString(1, boardingFlight);
			pst.setString(2, landingFlight);
			pst.setString(3, dateFlight);
			pst.setString(4, timeFlight);
			
			rs = pst.executeQuery();

			voo.setFlightID(rs.getInt(5));
			voo.setBoardingFlight(rs.getString(6));
			voo.setLandingFlight(rs.getString(7));
			voo.setDateFlight(rs.getString(8));
			voo.setTimeFlight(rs.getString(9));
			voo.setPriceFlight(rs.getDouble(10));
			voo.setFlight_St(rs.getString(11));
			voo.setAirplaneID(rs.getInt(12));
			to.add(voo);

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

	public ArrayList<Flight> consultBoardingsRest() {

		String sqlConsult = "select distinct boardingFlight from Flight";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Flight> listBoardings = new ArrayList<Flight>();

		try {
			stm = conn.prepareStatement(sqlConsult);
			rs = stm.executeQuery();

			while (rs.next()) {
				Flight flight = new Flight();
				flight.setBoardingFlight(rs.getString(1));

				listBoardings.add(flight);
			}

			if (listBoardings.isEmpty()) {
				listBoardings = null;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.out.print(e2.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return listBoardings;
	}

	public ArrayList<Flight> consultLandingsRest(Flight voo) {
		String sqlConsult = "select landingFlight from Flight where boardingFlight = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Flight> listLandings = new ArrayList<Flight>();

		try {
			stm = conn.prepareStatement(sqlConsult);
			stm.setString(1, voo.getBoardingFlight());
			rs = stm.executeQuery();

			while (rs.next()) {
				Flight flight = new Flight();
				flight.setLandingFlight(rs.getString(1));

				listLandings.add(flight);
			}

			if (listLandings.isEmpty()) {
				listLandings = null;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.out.print(e2.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return listLandings;
	}

	public ArrayList<Flight> consultFlightsRest(Flight voo) {
		String sqlConsult = "exec SP_ConsultFlights  ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Flight> listFlights = new ArrayList<Flight>();

		try {
			stm = conn.prepareStatement(sqlConsult);
			stm.setString(1, voo.getBoardingFlight());
			stm.setString(2, voo.getLandingFlight());
			rs = stm.executeQuery();

			while (rs.next()) {
				Flight flight = new Flight();

				flight.setFlightID(rs.getInt(1));
				flight.setBoardingFlight(rs.getString(2));
				flight.setLandingFlight(rs.getString(3));
				flight.setDateFlight(rs.getString(4));
				flight.setTimeFlight(rs.getString(5));
				flight.setPriceFlight(rs.getDouble(6));
				flight.setFlight_St(rs.getString(7));
				flight.setAirplaneID(rs.getInt(8));

				listFlights.add(voo);
			}

			if (listFlights.isEmpty()) {
				listFlights = null;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.out.print(e2.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return listFlights;
	}

}
