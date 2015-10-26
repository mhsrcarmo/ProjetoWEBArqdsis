package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TicketDAOSqlServer extends TicketDAO{

			//se não for acessar localmente mude localhost pelo nome do servidor
			private static String URL ="jdbc:sqlserver://localhost;" +"databaseName=AccountsManager;";  
			private static String usuario = "sa";
			//esse usuário é um sysadmin ele tem todos os poderes, é bom que se crie um login e usuário a parte  
			private static String password = "admin123";
			//Esse é o nome do driver, que na internet você vai encontrar de varias maneiras, mas só esse resolveu meus problemas  
			private static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
		
		public Connection conectar() throws SQLException{  
			try {  

				Class.forName(driver);  
				Connection con = DriverManager.getConnection(URL,usuario,password);  
				return con;  

			} catch (ClassNotFoundException e) {  
				throw new SQLException(e.getMessage());  
			}   
		}
}
