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
import model.Passenger;
import model.Specialist;

/**
 * Servlet implementation class CancelTicket
 */
@WebServlet("/CancelTicket,do")
public class CancelTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int flightID = Integer.parseInt(request.getParameter("flightID"));
		String clientCPF = request.getParameter("clientCPF");
		String seatName = request.getParameter("seatName");

		Specialist spe = new Specialist();
		try {
			spe.cancelarPassagem(flightID, clientCPF, seatName);
			String sucesso = "Passagem cancelada!";
		} catch (Exception e) {
			String erro = "Erro ao Cancelar a passagem!";

			e.printStackTrace();
		}

		RequestDispatcher view = request
				.getRequestDispatcher("cancelTicket.jsp");
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
