package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDAOMySQL extends LoginDAO{
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public  Connection conectar() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/cervejaria?user=aluno&password=alunos");
	}

}
