package model;

public class Login {
	String userLogin, passwordLogin, typeAccess;

	public Login() {}

	public Login(String userLogin, String passwordLogin, String typeAccess) {
		super();
		this.userLogin = userLogin;
		this.passwordLogin = passwordLogin;
		this.typeAccess = typeAccess;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public String getTypeAccess() {
		return typeAccess;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public void setTypeAccess(String typeAccess) {
		this.typeAccess = typeAccess;
	}

	@Override
	public String toString() {
		return "Login [userLogin=" + userLogin + ", passwordLogin="
				+ passwordLogin + ", typeAccess=" + typeAccess + "]";
	}

}
