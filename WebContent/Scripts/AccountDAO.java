package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Account;
import Model.Person;

public class AccountDAO {

	public ConnectionDB connection;
	public Connection conn;

	public AccountDAO() {
		connection = new ConnectionDB();
		try {
			conn = connection.openConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Account account) {
		String insertSQL = "insert into Accounts(description, userLogin, password, email, url, cpf, telephone, emailAlternativo, secretQuestion, answerQuestion, personID) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(insertSQL);
			stm.setString(1, account.getDescription());
			stm.setString(2, account.getUserLogin());
			stm.setString(3, account.getPassword());
			stm.setString(4, account.getEmail());
			stm.setString(5, account.getURL());
			stm.setString(6, account.getCPF());
			stm.setString(7, account.getTelephone());
			stm.setString(8, account.getEmailAlternativo());
			stm.setString(9, account.getSecretQuestion());
			stm.setString(10, account.getAnswerQuestion());
			stm.setInt(11, account.getPersonID());
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

	public void removeAccount(Account account) {
		String deleteSQL = "delete from Accounts where accountID = ?";
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(deleteSQL);
			stm.setInt(1, account.getAccountID());
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

	public void changePasswordAccount(Account account) {
		String updateSQL = "update Accounts set password = ? where accountID = ?";
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(updateSQL);
			stm.setString(1, account.getPassword());
			stm.setInt(2, account.getAccountID());
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

	public void updateAccount(Account account) {
		String updateSQL = "update Accounts set description = ?, userLogin = ?, password = ?, email = ?, url = ?, cpf = ?, telephone = ?, emailAlternativo = ?, secretQuestion = ?, answerQuestion = ?, personID = ? where accountID = ?";
		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(updateSQL);
			stm.setString(1, account.getDescription());
			stm.setString(2, account.getUserLogin());
			stm.setString(3, account.getPassword());
			stm.setString(4, account.getEmail());
			stm.setString(5, account.getURL());
			stm.setString(6, account.getCPF());
			stm.setString(7, account.getTelephone());
			stm.setString(8, account.getEmailAlternativo());
			stm.setString(9, account.getSecretQuestion());
			stm.setString(10, account.getAnswerQuestion());
			stm.setInt(11, account.getPersonID());
			stm.setInt(12, account.getAccountID());
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
	
	public ArrayList<Account> consultAccountsShort(int personID){
		String selectSQL = "select a. * from dbo.Persons p inner join dbo.Accounts a on p.personID = a.personID where a.personID = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			stm.setInt(1, personID);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setUpdateTime(rs.getTimestamp(12));
				
				listAccounts.add(account);
			}
			
			if(listAccounts.isEmpty()){
				listAccounts = null;
			}
		} catch(Exception e1){
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
		return listAccounts;
	}
	
	public ArrayList<Account> consultAccountsShortAdmin(){
		String selectSQL = "select a. * from dbo.Persons p inner join dbo.Accounts a on p.personID = a.personID";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setUpdateTime(rs.getTimestamp(12));
				
				listAccounts.add(account);
			}
			
			if(listAccounts.isEmpty()){
				listAccounts = null;
			}
		} catch(Exception e1){
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
		return listAccounts;
	}
	
	public ArrayList<Account> consultAccountsComplete(int personID){
		String selectSQL = "select a. * from dbo.Persons p inner join dbo.Accounts a on p.personID = a.personID where a.personID = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			stm.setInt(1, personID);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setCPF(rs.getString(7));
				account.setTelephone(rs.getString(8));
				account.setEmailAlternativo(rs.getString(9));
				account.setSecretQuestion(rs.getString(10));
				account.setAnswerQuestion(rs.getString(11));
				account.setUpdateTime(rs.getTimestamp(12));
				
				listAccounts.add(account);
			}
			
			if(listAccounts.isEmpty()){
				listAccounts = null;
			}
		} catch(Exception e1){
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
		return listAccounts;
	}
	
	public ArrayList<Account> consultAccountsCompleteAdmin(){
		String selectSQL = "select a. * from dbo.Persons p inner join dbo.Accounts a on p.personID = a.personID";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setCPF(rs.getString(7));
				account.setTelephone(rs.getString(8));
				account.setEmailAlternativo(rs.getString(9));
				account.setSecretQuestion(rs.getString(10));
				account.setAnswerQuestion(rs.getString(11));
				account.setUpdateTime(rs.getTimestamp(12));
				
				listAccounts.add(account);
			}
			
			if(listAccounts.isEmpty()){
				listAccounts = null;
			}
		} catch(Exception e1){
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
		return listAccounts;
	}
	
	public ArrayList<Account> consultAccountsByDescription(int personID, String description){
		String selectSQL = "select a. * from dbo.Persons p inner join dbo.Accounts a on p.personID = a.personID where a.personID = ? and a.description like '%?%'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			stm.setInt(1, personID);
			stm.setString(2, description);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setCPF(rs.getString(7));
				account.setTelephone(rs.getString(8));
				account.setEmailAlternativo(rs.getString(9));
				account.setSecretQuestion(rs.getString(10));
				account.setAnswerQuestion(rs.getString(11));
				account.setUpdateTime(rs.getTimestamp(12));
				
				listAccounts.add(account);
			}
			
			if(listAccounts.isEmpty()){
				listAccounts = null;
			}
		} catch(Exception e1){
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
		return listAccounts;
	}
	
	public ArrayList<Account> consultAccountsByUserLogin(int personID, String userLogin){
		String selectSQL = "select a. * from dbo.Persons p inner join dbo.Accounts a on p.personID = a.personID where a.personID = ? and a.userLogin like '%?%'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			stm.setInt(1, personID);
			stm.setString(2, userLogin);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setCPF(rs.getString(7));
				account.setTelephone(rs.getString(8));
				account.setEmailAlternativo(rs.getString(9));
				account.setSecretQuestion(rs.getString(10));
				account.setAnswerQuestion(rs.getString(11));
				account.setUpdateTime(rs.getTimestamp(12));
				
				listAccounts.add(account);
			}
			
			if(listAccounts.isEmpty()){
				listAccounts = null;
			}
		} catch(Exception e1){
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
		return listAccounts;
	}
	
	public ArrayList<Account> consultAccountsByEmail(int personID, String email){
		String selectSQL = "select a. * from dbo.Persons p inner join dbo.Accounts a on p.personID = a.personID where a.personID = ? and a.email = '?'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Account> listAccounts = new ArrayList<Account>();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			stm.setInt(1, personID);
			stm.setString(2, email);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setCPF(rs.getString(7));
				account.setTelephone(rs.getString(8));
				account.setEmailAlternativo(rs.getString(9));
				account.setSecretQuestion(rs.getString(10));
				account.setAnswerQuestion(rs.getString(11));
				account.setUpdateTime(rs.getTimestamp(12));
				
				listAccounts.add(account);
			}
			
			if(listAccounts.isEmpty()){
				listAccounts = null;
			}
		} catch(Exception e1){
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
		return listAccounts;
	}
	
	public Account consultAccountByAccountID(int accountID){
		String selectSQL = "select * from Accounts where accountID = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		Account account = new Account();
		
		try{
			stm = conn.prepareStatement(selectSQL);
			stm.setInt(1, accountID);
			rs = stm.executeQuery();
			if( rs.next() )
			{
				account.setAccountID(rs.getInt(1));
				account.setDescription(rs.getString(2));
				account.setUserLogin(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setEmail(rs.getString(5));
				account.setURL(rs.getString(6));
				account.setCPF(rs.getString(7));
				account.setTelephone(rs.getString(8));
				account.setEmailAlternativo(rs.getString(9));
				account.setSecretQuestion(rs.getString(10));
				account.setAnswerQuestion(rs.getString(11));
				account.setUpdateTime(rs.getTimestamp(12));
			}
			else
			{
				account = null;
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
		
		return account;
	}
}
