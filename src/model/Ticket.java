package model;

public class Ticket {
	private int ticketID, clientID, flightID;
	private String seatName, ticketType, clientCPF;

	public Ticket() {}

	public Ticket(int ticketID, int clientID, int flightID, String seatName,
			String ticketType, String clientCPF) {
		super();
		this.ticketID = ticketID;
		this.clientID = clientID;
		this.flightID = flightID;
		this.seatName = seatName;
		this.ticketType = ticketType;
		this.clientCPF = clientCPF;
	}

	public String getClientCPF() {
		return clientCPF;
	}

	public void setClientCPF(String clientCPF) {
		this.clientCPF = clientCPF;
	}

	public int getTicketID() {
		return ticketID;
	}

	public int getClientID() {
		return clientID;
	}

	public int getFlightID() {
		return flightID;
	}

	public String getSeatName() {
		return seatName;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	@Override
	public String toString() {
		return "Ticket [ticketID=" + ticketID + ", clientID=" + clientID
				+ ", flightID=" + flightID + ", seatName=" + seatName
				+ ", ticketType=" + ticketType + ", clientCPF=" + clientCPF
				+ "]";
	}

}