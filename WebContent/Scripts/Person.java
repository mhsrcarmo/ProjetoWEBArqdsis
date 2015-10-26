package Model;

import java.util.ArrayList;

import DAO.PersonDAO;

public class Person {

	private int ID;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String userType;
	private java.sql.Timestamp updateTime;

	public Person() {
		ID = 0;
		firstName = null;
		lastName = null;
		login = null;
		password = null;
		userType = null;
		updateTime = null;
	}
	
	public Person(String firstName, String lastName, String login,
			String password, String userType) {
		setFirstName(firstName);
		setLastName(lastName);
		setLogin(login);
		setPassword(password);
		setUserType(userType);
		
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public void setUpdateTime(java.sql.Timestamp timestamp){
		this.updateTime = timestamp;
	}

	public int getID(){
		return ID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getUserType() {
		return userType;
	}
	
	public java.sql.Timestamp getUpdateTime(){
		return updateTime;
	}

	public Person consultPersonByLogin(String login){
		PersonDAO pDAO = new PersonDAO();
		Person p = pDAO.consultPersonByLogin(login);
		return p;
	}

}
