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
import model.Specialist;

/**
 * Servlet implementation class BuyTicket
 */
@WebServlet("/BuyTicket.do")
public class BuyTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int clientID = Integer.parseInt(request.getParameter("clientID"));
		int flightID = Integer.parseInt(request.getParameter("flightID"));
		String seatName = (request.getParameter("seatName"));

		Specialist spe = new Specialist();
		try {
			spe.comprarPassagem(clientID, flightID, seatName);
			String sucesso = "Passagem comprada!";
		} catch (Exception e) {
			String erro = "Erro ao comprar passagem!";

			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher("buyTicket.jsp");
		view.forward(request, response);
	}
	
	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
