package Model;

import java.util.ArrayList;

import DAO.AccountDAO;

public class Account {

	private int accountID;
	private String description;
	private String userLogin;
	private String password;
	private String email;
	private String URL;
	private String CPF;
	private String telephone;
	private String emailAlternativo;
	private String secretQuestion;
	private String answerQuestion;
	private java.sql.Timestamp updateTime;
	private int personID;

	public Account() {
		this.accountID = 0;
		this.description = null;
		this.userLogin = null;
		this.password = null;
		this.email = null;
		this.URL = null;
		this.CPF = null;
		this.telephone = null;
		this.emailAlternativo = null;
		this.secretQuestion = null;
		this.answerQuestion = null;
		this.updateTime = null;
		this.personID = 0;
	}

	public Account(String description, String userLogin, String password,
			String email, String URL, String CPF, String telephone, String emailAlternativo,
			String secretQuestion, String answerQuestion, int personID) {
		setDescription(description);
		setUserLogin(userLogin);
		setPassword(password);
		setEmail(email);
		setURL(URL);
		setCPF(CPF);
		setTelephone(telephone);
		setEmailAlternativo(emailAlternativo);
		setSecretQuestion(secretQuestion);
		setAnswerQuestion(answerQuestion);
		setPersonID(personID);
	}
	
	public void setAccountID(int accountID){
		this.accountID = accountID;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setUserLogin(String userLogin){
		this.userLogin = userLogin;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setURL(String URL){
		this.URL = URL;
	}
	
	public void setCPF(String CPF){
		this.CPF = CPF;
	}
	
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	
	public void setEmailAlternativo(String emailAlternativo){
		this.emailAlternativo = emailAlternativo;
	}
	
	public void setSecretQuestion(String secretQuestion){
		this.secretQuestion = secretQuestion;
	}
	
	public void setAnswerQuestion(String answerQuestion){
		this.answerQuestion = answerQuestion;
	}
	
	public void setPersonID(int personID){
		this.personID = personID;
	}
	
	public void setUpdateTime(java.sql.Timestamp timestamp){
		this.updateTime = timestamp;
	}
	
	public int getAccountID(){
		return accountID;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getUserLogin(){
		return userLogin;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getURL(){
		return URL;
	}
	
	public String getCPF(){
		return CPF;
	}
	
	public String getTelephone(){
		return telephone;
	}
	
	public String getEmailAlternativo(){
		return emailAlternativo;
	}
	
	public String getSecretQuestion(){
		return secretQuestion;
	}
	
	public String getAnswerQuestion(){
		return answerQuestion;
	}
	
	public java.sql.Timestamp getUpdateTime(){
		return updateTime;
	}
	
	public int getPersonID(){
		return personID;
	}
	
}
