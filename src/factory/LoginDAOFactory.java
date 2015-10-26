package factory;

import dao.LoginDAO;
import dao.LoginDAOMySQL;
import dao.LoginDAOPOSTGRE;
import dao.LoginDAOSqlServer;



public class LoginDAOFactory {
	public static LoginDAO getLoginDAO() {
		switch (DAOFactory.banco) {

		case DAOFactory.SQL_SERVER:
			return new LoginDAOSqlServer();
		case DAOFactory.MY_SQL:
			return new LoginDAOMySQL();
		case DAOFactory.POSTGRE:
			return new LoginDAOPOSTGRE();

		}
		return null;
	}

}
