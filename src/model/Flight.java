package model;

public class Flight {

	private int airplaneID, flightID;
	private double priceFlight;
	private String boardingFlight, landingFlight, dateFlight, timeFlight,
			flight_St;

	public Flight() {

	}

	public Flight(int airplaneID, double priceFlight, String boardingFlight,
			String landingFlight, String dateFlight, String timeFlight,
			String flight_St) {
		super();
		this.airplaneID = airplaneID;
		this.priceFlight = priceFlight;
		this.boardingFlight = boardingFlight;
		this.landingFlight = landingFlight;
		this.dateFlight = dateFlight;
		this.timeFlight = timeFlight;
		this.flightID = flightID;
	}

	public String getFlight_St() {
		return flight_St;
	}

	public void setFlight_St(String flight_St) {
		this.flight_St = flight_St;
	}

	public int getAirplaneID() {
		return airplaneID;
	}

	public double getPriceFlight() {
		return priceFlight;
	}

	public String getBoardingFlight() {
		return boardingFlight;
	}

	public String getLandingFlight() {
		return landingFlight;
	}

	public String getDateFlight() {
		return dateFlight;
	}

	public String getTimeFlight() {
		return timeFlight;
	}

	public void setAirplaneID(int airplaneID) {
		this.airplaneID = airplaneID;
	}

	public void setPriceFlight(double priceFlight) {
		this.priceFlight = priceFlight;
	}

	public void setBoardingFlight(String boardingFlight) {
		this.boardingFlight = boardingFlight;
	}

	public void setLandingFlight(String landingFlight) {
		this.landingFlight = landingFlight;
	}

	public void setDateFlight(String dateFlight) {
		this.dateFlight = dateFlight;
	}

	public void setTimeFlight(String timeFlight) {
		this.timeFlight = timeFlight;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	@Override
	public String toString() {
		return "Flight [airplaneID=" + airplaneID + ", flightID=" + flightID
				+ ", priceFlight=" + priceFlight + ", boardingFlight="
				+ boardingFlight + ", landingFlight=" + landingFlight
				+ ", dateFlight=" + dateFlight + ", timeFlight=" + timeFlight
				+ ", flight_St=" + flight_St + "]";
	}

}
