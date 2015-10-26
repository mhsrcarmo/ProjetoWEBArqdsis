package model;

public class Seats {

	private int flightID;
	private String seatName, seatType, seat_St;
	
	public Seats(){
		
	}

	public Seats(int flightID, String seatName, String seatType, String seat_St) {
		super();
		this.flightID = flightID;
		this.seatName = seatName;
		this.seatType = seatType;
		this.seat_St = seat_St;
	}

	public int getFlightID() {
		return flightID;
	}

	public String getSeatName() {
		return seatName;
	}

	public String getSeatType() {
		return seatType;
	}

	public String getSeat_St() {
		return seat_St;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public void setSeat_St(String seat_St) {
		this.seat_St = seat_St;
	}

	@Override
	public String toString() {
		return "Seats [flightID=" + flightID + ", seatName=" + seatName
				+ ", seatType=" + seatType + ", seat_St=" + seat_St + "]";
	}
	
	
	
	
}
