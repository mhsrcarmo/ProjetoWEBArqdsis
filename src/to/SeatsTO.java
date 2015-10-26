package to;

import java.util.ArrayList;
import model.Seats;

public class SeatsTO {
	private ArrayList<Seats> lista;
	private ArrayList<String> seatName;
	
	
	public ArrayList<String> getSeatName() {
		return seatName;
	}

	public void setSeatName(ArrayList<String> seatName) {
		this.seatName = seatName;
	}

	public SeatsTO(){
		lista = new ArrayList<Seats>();
	}
	
	public void add(Seats assento) {
		lista.add(assento);
	}

	public boolean remove(Seats assento) {
		return (lista.remove(assento));
	}

	public ArrayList<Seats> getLista() {
		return lista;
	}
	
}
