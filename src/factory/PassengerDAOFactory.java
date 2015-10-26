package factory;

import dao.PassengerDAO;
import dao.PassengerDAOMySQL;
import dao.PassengerDAOPOSTGRE;
import dao.PassengerDAOSqlServer;

public class PassengerDAOFactory {

	public static PassengerDAO getPassengerDAO() {
		switch (DAOFactory.banco) {

		case DAOFactory.MY_SQL:
			return new PassengerDAOMySQL();
		case DAOFactory.POSTGRE:
			return new PassengerDAOPOSTGRE();
		case DAOFactory.SQL_SERVER:
			return new PassengerDAOSqlServer();

		}
		return null;
	}

}
