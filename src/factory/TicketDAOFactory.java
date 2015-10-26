package factory;

import dao.TicketDAO;
import dao.TicketDAOMySQL;
import dao.TicketDAOPOSTGRE;
import dao.TicketDAOSqlServer;

public class TicketDAOFactory {
	public static TicketDAO getTicketDAO() {
		switch (DAOFactory.banco) {

		case DAOFactory.MY_SQL:
			return new TicketDAOMySQL();
		case DAOFactory.POSTGRE:
			return new TicketDAOPOSTGRE();
		case DAOFactory.SQL_SERVER:
			return new TicketDAOSqlServer();

		}
		return null;
	}
}
