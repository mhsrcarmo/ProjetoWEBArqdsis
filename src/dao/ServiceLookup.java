package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import factory.DAOFactory;

public class ServiceLookup {
	
	public static void setupDB(){
		
		try {
			// Pega o contexto do JNDI
			Context env = (Context)new InitialContext().lookup("java:comp/env");

			//pega qual o banco de dados a utilizar
			//SQL Server e o default
			//a configuracao esta no web.xml no WebContent/WEB-INF do projeto
			String banco = (String)env.lookup("banco-de-dados");
			if(banco.equals("sqlserver")){
				DAOFactory.banco = DAOFactory.SQL_SERVER;
			} else if(banco.equals("mysql")){
				DAOFactory.banco = DAOFactory.MY_SQL;
			} else if(banco.equals("postgresql")){
				DAOFactory.banco = DAOFactory.POSTGRE;			
			}else{
				DAOFactory.banco = DAOFactory.SQL_SERVER;
			}	
		} catch (NamingException e1) {
			//SQL Server e o default
			DAOFactory.banco = DAOFactory.SQL_SERVER;
			e1.printStackTrace();
		}		
	}
}
