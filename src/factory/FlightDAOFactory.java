package factory;

import dao.FlightDAO;
import dao.FlightDAOMySQL;
import dao.FlightDAOPOSTGRE;
import dao.FlightDAOSqlServer;

public class FlightDAOFactory {

	public static FlightDAO getFlightDAO() {
		switch (DAOFactory.banco) {

		case DAOFactory.MY_SQL:
			return new FlightDAOMySQL();
		case DAOFactory.POSTGRE:
			return new FlightDAOPOSTGRE();
		case DAOFactory.SQL_SERVER:
			return new FlightDAOSqlServer();

		}
		return null;
	}

}
