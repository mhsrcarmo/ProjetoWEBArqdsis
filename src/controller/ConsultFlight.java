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
 * Servlet implementation class ConsultFlight
 */
@WebServlet("/ConsultFlight.do")
public class ConsultFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		Flight voo = new Flight();
		Flight consult = new Flight();
		
		voo.setBoardingFlight(request.getParameter("boardingFlight"));
		String boardingFlight = request.getParameter("boardingFlight");
		consult.setBoardingFlight(boardingFlight);
		
		voo.setLandingFlight(request.getParameter("landingFlight"));
		String landingFlight = request.getParameter("landingFlight");
		consult.setLandingFlight(landingFlight);
		
		voo.setDateFlight(request.getParameter("dateFlight"));
		String dateFlight = request.getParameter("dateFlight");
		consult.setDateFlight(dateFlight);
		
		voo.setTimeFlight(request.getParameter("timeFlight"));
		String timeFlight = request.getParameter("timeFlight");
		consult.setTimeFlight(timeFlight);
		
		FlightTO vooTO = null;
		Specialist spe = new Specialist();
		try {
			vooTO = spe.consultarVoo(boardingFlight,landingFlight,dateFlight,timeFlight);
		} catch (Exception e) {
			String erro = "erro na consulta!";
			e.printStackTrace();
		}
		request.setAttribute("lista", vooTO.getLista());
		
		RequestDispatcher view = request
				.getRequestDispatcher("consultFlight.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);

	}
	
	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
