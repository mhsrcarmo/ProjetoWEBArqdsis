package to;

import java.io.Serializable;
import java.util.ArrayList;

import model.Flight;

public class FlightTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Flight> listarVoos;
	
	public FlightTO() {
		listarVoos = new ArrayList<Flight>();
	}
	
	public void add(Flight voo) {
		listarVoos.add(voo);
	}

	public boolean remove(Flight voo) {
		return (listarVoos.remove(voo));

	}

	public ArrayList<Flight> getLista() {
		return listarVoos;
	}

}
