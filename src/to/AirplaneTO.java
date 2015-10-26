package to;

import java.io.Serializable;
import java.util.ArrayList;

import model.Airplane;

public class AirplaneTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Airplane> lista;

	public AirplaneTO() {
		lista = new ArrayList<Airplane>();
	}

	public void add(Airplane aeronave) {
		lista.add(aeronave);
	}

	public boolean remove(Airplane aeronave) {
		return (lista.remove(aeronave));
	}

	public ArrayList<Airplane> getLista() {
		return lista;
	}

}
