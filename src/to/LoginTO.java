package to;

import java.util.ArrayList;

import model.Login;

public class LoginTO {
	private ArrayList<Login> lista;

	public LoginTO() {
		lista = new ArrayList<Login>();
	}

	public void add(Login login) {
		lista.add(login);
	}

	public boolean remove(Login login) {
		return (lista.remove(login));
	}

	public ArrayList<Login> getLista() {
		return lista;
	}

}


