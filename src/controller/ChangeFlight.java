package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServiceLookup;
import to.FlightTO;
import model.Flight;
import model.Specialist;

/**
 * Servlet implementation class ChangeFlight
 */
@WebServlet("/ChangeFlight.do")
public class ChangeFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int flightIDSearch = Integer.parseInt(request
				.getParameter("flightIDSearch"));
		String boardingFlight = request.getParameter("boardingFlight");
		String landingFlight = request.getParameter("landingFlight");
		String dateFlight = request.getParameter("dateFlight");
		String timeFlight = request.getParameter("timeFlight");
		double priceFlight = Double.parseDouble(request
				.getParameter("priceFlight"));
		String flight_St = request.getParameter("flight_St");
		int AirplaneID = Integer.parseInt(request.getParameter("AirplaneID"));

		Specialist spe = new Specialist();
		try {

			spe.alterarVoo(flightIDSearch, boardingFlight, landingFlight,
					dateFlight, timeFlight, priceFlight, flight_St, AirplaneID);
			String sucesso = "Alteração feita com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			String erro = "erro na alteração!";
		}

		RequestDispatcher view = request
				.getRequestDispatcher("changeFlight.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
