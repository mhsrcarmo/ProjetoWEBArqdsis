package factory;


import dao.SeatsDAO;
import dao.SeatsDAOMySQL;
import dao.SeatsDAOPOSTGRE;
import dao.SeatsDAOSqlServer;

public class SeatsDAOFactory {
	public static SeatsDAO getSeatsDAO() {
		switch (DAOFactory.banco) {

		case DAOFactory.MY_SQL:
			return new SeatsDAOMySQL();
		case DAOFactory.POSTGRE:
			return new SeatsDAOPOSTGRE();
		case DAOFactory.SQL_SERVER:
			return new SeatsDAOSqlServer();

		}
		return null;
	}

}
