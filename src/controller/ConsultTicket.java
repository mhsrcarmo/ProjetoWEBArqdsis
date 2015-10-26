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
import to.TicketTO;
import model.Flight;
import model.Specialist;
import model.Ticket;

/**
 * Servlet implementation class ConsultTicket
 */
@WebServlet("/ConsultTicket.do")
public class ConsultTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Ticket passagem = new Ticket();
		Ticket consult = new Ticket();
		
		passagem.setFlightID(Integer.parseInt(request.getParameter("flightID")));
		int flightID = Integer.parseInt(request.getParameter("flightID"));
		consult.setFlightID(flightID);
		
		passagem.setClientCPF(request.getParameter("clientCPF"));
		String clientCPF = request.getParameter("clientCPF");
		consult.setClientCPF(clientCPF);
		
		passagem.setSeatName(request.getParameter("seatName"));
		String seatName = request.getParameter("seatName");
		consult.setSeatName(request.getParameter(seatName));
		
		TicketTO passagemTO = null;
		Specialist spe = new Specialist();
		try {
			passagemTO = spe.consultarPassagem(flightID,clientCPF,seatName );
		} catch (Exception e) {
			String erro = "erro na consulta!";
			e.printStackTrace();
		}
		request.setAttribute("lista", passagemTO.getLista());
		
		RequestDispatcher view = request
				.getRequestDispatcher("consultFlight.jsp");
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
