package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Passenger;
import to.PassengerTO;
import factory.TOFactory;

public abstract class PassengerDAO {

	public abstract Connection conectar() throws SQLException;

	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	public PassengerTO cadastrarPassageiro(String CPF, String treatmentClient,
			String nameClient, String lastNameClient, String emailClient,
			String birthDate, String telephoneClient) throws Exception {

		String sqlCadastrar = "exec SP_IncludeClient ?,?,?,?,?,?,?";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		PassengerTO to = TOFactory.getPassengerTO();

		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlCadastrar);
			rs = pst.executeQuery();

			pst.setString(1, CPF);
			pst.setString(2, treatmentClient);
			pst.setString(3, nameClient);
			pst.setString(4, lastNameClient);
			pst.setString(5, emailClient);
			pst.setString(6, birthDate);
			pst.setString(7, telephoneClient);
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

	public PassengerTO excluirPassageiro(String CPF, String nameClient)
			throws Exception {

		String sqlDeletar = "exec SP_DeleteClient ?,?";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		PassengerTO to = TOFactory.getPassengerTO();

		try {
			pst = conn.prepareStatement(sqlDeletar);
			pst.setString(1, CPF);
			pst.setString(2, nameClient);
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

	public PassengerTO alterarPassageiro(String CPFSearch,
			String nameClientSearch, String CPF, String treatmentClient,
			String nameClient, String lastNameClient, String emailClient,
			String birthDate, String telephoneClient) throws Exception {

		String sqlAlterar = "exec SP_UpdateClient ?,?,?,?,?,?,?,?,?";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		PassengerTO to = TOFactory.getPassengerTO();

		try {
			pst = conn.prepareStatement(sqlAlterar);

			pst.setString(1, CPF);
			pst.setString(2, treatmentClient);
			pst.setString(3, nameClient);
			pst.setString(4, lastNameClient);
			pst.setString(5, emailClient);
			pst.setString(6, birthDate);
			pst.setString(7, telephoneClient);

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

	public PassengerTO consultarPassageiro(String CPFSearch,
			String nameClientSearch) throws Exception {

		String sqlConsultarPassageiro = "exec SP_ConsultClient ?,?";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Passenger passageiro = new Passenger();
		PassengerTO to = TOFactory.getPassengerTO();

		try {
			conn = conectar();
			pst = conn.prepareStatement(sqlConsultarPassageiro);
			pst.setString(1, CPFSearch);
			pst.setString(2, nameClientSearch);
			rs = pst.executeQuery();
			while (rs.next()) {

				passageiro.setCPF(rs.getString(3));
				passageiro.setTreatmentClient(rs.getString(4));
				passageiro.setNameClient(rs.getString(5));
				passageiro.setLastNameClient(rs.getString(6));
				passageiro.setEmailClient(rs.getString(7));
				passageiro.setBirthDate(rs.getString(8));
				passageiro.setTelephoneClient(rs.getString(9));
				to.add(passageiro);
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
