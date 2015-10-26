package to;

import java.io.Serializable;
import java.util.ArrayList;
import model.Passenger;

public class PassengerTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Passenger> lista;

	public PassengerTO() {
		lista = new ArrayList<Passenger>();
	}

	public void add(Passenger passenger) {
		lista.add(passenger);
	}

	public boolean remove(Passenger passenger) {
		return (lista.remove(passenger));
	}

	public ArrayList<Passenger> getLista() {
		return lista;
	}

}
