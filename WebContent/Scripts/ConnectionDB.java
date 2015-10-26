package DAO;

import java.sql.*;  
	public class ConnectionDB {  
	  
	  // 192.168.10.48:1433 - IP/Nome Servidor
	   private static String URL ="jdbc:sqlserver://192.168.10.48:1433;" +  
	"databaseName=AccountsManager;";//se não for acessar localmente mude localhost pelo nome do servidor  
	    private static String usuario = "rgdias17";//esse usuário é um sysadmin ele tem todos os poderes, é bom que se crie um login e usuário a parte  
	    private static String password = "#Rgdias.prtd17'";  
	   private static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver" ;//Esse é o nome do driver, que na internet você vai encontrar de varias maneiras, mas só esse resolveu meus problemas  
	  
	  
	   public Connection openConnection() throws SQLException{  
	      try {  
	  
	        Class.forName(driver );  
	        Connection con = DriverManager.getConnection(URL,usuario,password);  
	        return con;  
	  
	      } catch (ClassNotFoundException e) {  
	               throw new SQLException(e.getMessage());  
	      }   
	   }
	}

