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
import model.Flight;
import model.Specialist;

/**
 * Servlet implementation class RegisterFlight
 */
@WebServlet("/RegisterFlight.do")
public class RegisterFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		
		int airplaneID = Integer.parseInt(request.getParameter("airplaneID"));
		String boardingFlight = request.getParameter("boardingFlight");
		String landingFligh = request.getParameter("landingFligh");
		String dateFlight = request.getParameter("dateFlight");
		String timeFlight = request.getParameter("timeFlight");
		double priceFlight = Double.parseDouble(request.getParameter("priceFlight"));
		
		
		Specialist spe = new Specialist();
		try {
			spe.adicionarVoo(airplaneID, boardingFlight,landingFligh,dateFlight,timeFlight,priceFlight);
			String sucesso = "Voo cadastrado!";

		} catch (Exception e) {
			String erro = "Erro ao cadastrar Voo!";

			e.printStackTrace();
		}

		RequestDispatcher view = request
				.getRequestDispatcher("registerFlight.jsp");
		view.forward(request, response);
	}
	
	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
