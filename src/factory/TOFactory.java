package factory;

import to.AirplaneTO;
import to.FlightTO;
import to.LoginTO;
import to.PassengerTO;
import to.SeatsTO;
import to.TicketTO;

public class TOFactory {

	public static AirplaneTO getAirplaneTO() {
		return new AirplaneTO();
	}

	public static PassengerTO getPassengerTO() {
		return new PassengerTO();
	}

	public static FlightTO getFlightTO() {
		return new FlightTO();
	}

	public static TicketTO getTicketTO() {
		return new TicketTO();
	}

	public static SeatsTO getSeatsTO() {
		return new SeatsTO();
	}
	
	public static LoginTO getLoginTO(){
		return new LoginTO();
	}

}