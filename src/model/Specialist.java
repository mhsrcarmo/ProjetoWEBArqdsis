package model;

import to.AirplaneTO;
import to.FlightTO;
import to.LoginTO;
import to.PassengerTO;
import to.SeatsTO;
import to.TicketTO;
import factory.DAOFactory;

public class Specialist {

	public Specialist() {
	}

	public void adicionarAeronave(int airCompanyID, int qtySeats,
			String modelAirplane) throws Exception {
		DAOFactory.getAirplaneDAO().cadastrarAeronave(airCompanyID, qtySeats,
				modelAirplane);
	}

	public void excluirAeronave(int airplaneID) throws Exception {
		DAOFactory.getAirplaneDAO().excluirAeronave(airplaneID);
	}

	public AirplaneTO consultarAeronave(int airplaneID) throws Exception {
		return DAOFactory.getAirplaneDAO().consultarAeronave(airplaneID);
	}

	public void alterarAeronave(int airplaneID, int airCompanyID, int qtySeats,
			String modelAirplane) throws Exception {
		DAOFactory.getAirplaneDAO().alterarAeronave(airplaneID, airCompanyID,
				qtySeats, modelAirplane);
	}

	public void cadastrarPassageiro(String CPF, String treatmentClient,
			String nameClient, String lastNameClient, String emailClient,
			String birthDate, String telephoneClient) throws Exception {

		DAOFactory.getPassengerDAO().cadastrarPassageiro(CPF, treatmentClient,
				nameClient, lastNameClient, emailClient, birthDate,
				telephoneClient);
	}

	public void alterarPassageiro(String CPFSearch, String nameClientSearch,
			String CPF, String treatmentClient, String nameClient,
			String lastNameClient, String emailClient, String birthDate,
			String telephoneClient) throws Exception {

		DAOFactory.getPassengerDAO().alterarPassageiro(CPFSearch,
				nameClientSearch, CPF, treatmentClient, nameClient,
				lastNameClient, emailClient, birthDate, telephoneClient);
	}

	public void excluirPassageiro(String CPF, String nameClient)
			throws Exception {

		DAOFactory.getPassengerDAO().excluirPassageiro(CPF, nameClient);

	}

	public PassengerTO consultarPassageiro(String CPF, String nameClient)
			throws Exception {
		return DAOFactory.getPassengerDAO()
				.consultarPassageiro(CPF, nameClient);

	}

	public void adicionarVoo(int airplaneID, String boardingFlight,
			String landingFligh, String dateFlight, String timeFlight,
			double priceFlight) throws Exception {
		DAOFactory.getFlightDAO().cadastrarVoo(airplaneID, boardingFlight,
				landingFligh, dateFlight, timeFlight, priceFlight);

	}

	public void alterarVoo(int flightIDSearch, String boardingFlight,
			String landingFlight, String dateFlight, String timeFlight,
			double priceFlight, String flight_St, int airplaneID)
			throws Exception {

		DAOFactory.getFlightDAO().alterarVoo(flightIDSearch, boardingFlight,
				landingFlight, dateFlight, timeFlight, priceFlight, flight_St,
				airplaneID);
	}

	public FlightTO consultarVoo(String boardingFlight, String landingFlight, String dateFlight, String timeFlight) {

		return DAOFactory.getFlightDAO().consultarVoo(boardingFlight,
				landingFlight, dateFlight, timeFlight);
	}

	public void excluirVoo(int flightIDSearch) throws Exception {

		DAOFactory.getFlightDAO().excluirVoo(flightIDSearch);

	}

	public void comprarPassagem(int clientID, int flightID, String seatName)
			throws Exception {
		DAOFactory.getTicketDAO().cadastrarPassagem(clientID, flightID,
				seatName);
	}

	public void alterarPassagem(int flightIDSearch, String clientCPFSearch,
			String seatNameSearch) throws Exception {
		DAOFactory.getTicketDAO().alterarPassagem(flightIDSearch,
				clientCPFSearch, seatNameSearch);

	}

	public TicketTO consultarPassagem(int flightID, String clientCPF,
			String seatName) throws Exception {
		return DAOFactory.getTicketDAO().consultarPassagem(flightID, clientCPF,
				seatName);
	}

	public void cancelarPassagem(int flightID, String clientCPF, String seatName)
			throws Exception {
		DAOFactory.getTicketDAO()
				.excluirPassagem(flightID, clientCPF, seatName);

	}

	public TicketTO listarPassagem() throws Exception {
		return DAOFactory.getTicketDAO().listarTodasPassagem();

	}

	public LoginTO validarLogin(String userLogin, String passwordLogin)
			throws Exception {
		return DAOFactory.getLoginDAO().validarLogin(userLogin, passwordLogin);
	}

	public SeatsTO listarAssentos(int flightIDSearch) throws Exception {
		return DAOFactory.getSeatsDAO().listarAssentos(flightIDSearch);
	}
}
