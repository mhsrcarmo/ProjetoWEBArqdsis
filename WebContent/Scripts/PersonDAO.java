package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Person;

public class PersonDAO {

	/**
	 * Declaração de variáveis.
	 */
	public ConnectionDB connection;
	public Connection conn;

	/**
	 * Método construtor instanciando a conexão com o banco.
	 */
	public PersonDAO() {
		connection = new ConnectionDB();
		try {
			conn = connection.openConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para realizar a inserção de dados de Person.
	 * 
	 * @param person
	 */
	public void insert(Person person) {
		String sqlInsert = "insert into Persons(firstName, lastName, login, password, userType) values ( ?, ?, ?, ?, ?)";

		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sqlInsert);

			stm.setString(1, person.getFirstName());
			stm.setString(2, person.getLastName());
			stm.setString(3, person.getLogin());
			stm.setString(4, person.getPassword());
			stm.setString(5, person.getUserType());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	/**
	 * Método para realizar consulta no banco de dados pelo ID da Pessoa.
	 * @param ID
	 * @return
	 */
	public Person consultPersonByID(int ID){
		String sqlConsult = "select * from Persons where personID = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		Person person = new Person();
		
		try{
			stm = conn.prepareStatement(sqlConsult);
			stm.setInt(1, ID);
			rs = stm.executeQuery();
			if( rs.next() )
			{
				person.setID(rs.getInt(1));
				person.setLogin(rs.getString(2));
				person.setPassword(rs.getString(3));
				person.setFirstName(rs.getString(4));
				person.setLastName(rs.getString(5));
				person.setUserType(rs.getString(6));
				person.setUpdateTime(rs.getTimestamp(7));
			}
			else
			{
				person = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		
		return person;
	}
	
	/**
	 * Método para realizar consulta no banco de dados pelo login da Pessoa.
	 * @param login
	 * @return
	 */
	public Person consultPersonByLogin(String login){
		String sqlConsult = "select * from Persons where login = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		Person person = new Person();
		
		try{
			stm = conn.prepareStatement(sqlConsult);
			stm.setString(1, login);
			rs = stm.executeQuery();
			if( rs.next() )
			{
				person.setID(rs.getInt(1));
				person.setLogin(rs.getString(2));
				person.setPassword(rs.getString(3));
				person.setFirstName(rs.getString(4));
				person.setLastName(rs.getString(5));
				person.setUserType(rs.getString(6));
				person.setUpdateTime(rs.getTimestamp(7));
			}
			else
			{
				person = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		
		return person;
	}
	
	/**
	 * Método que realizar consulta no banco de dados pelo firstName.
	 * @param firstName
	 * @return
	 */
	public ArrayList<Person> consultPersonByFirstName(String firstName){
		String sqlConsult = "select * from Persons where firstName = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Person> listPersons = new ArrayList<Person>();
		
		try{
			stm = conn.prepareStatement(sqlConsult);
			stm.setString(1, firstName);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Person person = new Person();
				person.setID(rs.getInt(1));
				person.setLogin(rs.getString(2));
				person.setPassword(rs.getString(3));
				person.setFirstName(rs.getString(4));
				person.setLastName(rs.getString(5));
				person.setUserType(rs.getString(6));
				person.setUpdateTime(rs.getTimestamp(7));
				
				listPersons.add(person);
			}
			
			if(listPersons.isEmpty()){
				listPersons = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		return listPersons;
	}
	
	/**
	 * Método que realizar consulta no banco de dados pelo userType.
	 * @param userType
	 * @return
	 */
	public ArrayList<Person> consultPersonByUserType(String userType){
		String sqlConsult = "select * from Persons where userType = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Person> listPersons = new ArrayList<Person>();
		
		try{
			stm = conn.prepareStatement(sqlConsult);
			stm.setString(1, userType);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Person person = new Person();
				person.setID(rs.getInt(1));
				person.setLogin(rs.getString(2));
				person.setPassword(rs.getString(3));
				person.setFirstName(rs.getString(4));
				person.setLastName(rs.getString(5));
				person.setUserType(rs.getString(6));
				person.setUpdateTime(rs.getTimestamp(7));
				
				listPersons.add(person);
			}
			
			if(listPersons.isEmpty()){
				listPersons = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		return listPersons;
	}
	
	/**
	 * Método para realizar consulta de todas as Pessoas na tabela.
	 * @return
	 */
	public ArrayList<Person> consultAllPersons(){
		String sqlConsultAll = "select * from Persons";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Person> listPersons = new ArrayList<Person>();
		
		try{
			stm = conn.prepareStatement(sqlConsultAll);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Person person = new Person();
				person.setID(rs.getInt(1));
				person.setLogin(rs.getString(2));
				person.setPassword(rs.getString(3));
				person.setFirstName(rs.getString(4));
				person.setLastName(rs.getString(5));
				person.setUserType(rs.getString(6));
				person.setUpdateTime(rs.getTimestamp(7));
				
				listPersons.add(person);
			}
			
			if(listPersons.isEmpty()){
				listPersons = null;
			}
		}
		catch(Exception e1){
			e1.printStackTrace();
			try
			{
				conn.rollback();
			}
			catch ( SQLException e2 )
			{
				System.out.print( e2.getStackTrace() );
			}
		}
		finally
		{
			if ( stm != null )
			{
				try
				{
					stm.close();
				}
				catch( SQLException e1 )
				{
					System.out.print( e1.getStackTrace() );
				}
			}
		}
		return listPersons;
	}
	
	public void changePasswordByID(Person person){
		String sqlUpdate = "update Persons set password = ? where personID = ?";
		PreparedStatement stm = null;
		
		try {
			stm = conn.prepareStatement(sqlUpdate);
			
			stm.setString(1, person.getPassword());
			stm.setInt(2, person.getID());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	public void changePasswordByLogin(Person person){
		String sqlUpdate = "update Persons set password = ? where login = ?";
		PreparedStatement stm = null;
		
		try {
			stm = conn.prepareStatement(sqlUpdate);
			
			stm.setString(1, person.getPassword());
			stm.setString(2, person.getLogin());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	public void changeUserTypeByID(Person person){
		String sqlUpdate = "update Persons set userType = ? where personID = ?";
		PreparedStatement stm = null;
		
		try {
			stm = conn.prepareStatement(sqlUpdate);
			
			stm.setString(1, person.getUserType());
			stm.setInt(2, person.getID());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	public void changeUserTypeByLogin(Person person){
		String sqlUpdate = "update Persons set userType = ? where login = ?";
		PreparedStatement stm = null;
		
		try {
			stm = conn.prepareStatement(sqlUpdate);
			
			stm.setString(1, person.getUserType());
			stm.setString(2, person.getLogin());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	public void removePersonByID(Person person){
		String sqlDelete = "delete from Persons where personID = ?";
		PreparedStatement stm = null;
		
		try {
			stm = conn.prepareStatement(sqlDelete);
			
			stm.setInt(1, person.getID());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	public void removePersonByLogin(Person person){
		String sqlDelete = "delete from Persons where login = ?";
		PreparedStatement stm = null;
		
		try {
			stm = conn.prepareStatement(sqlDelete);
			
			stm.setString(1, person.getLogin());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
}
