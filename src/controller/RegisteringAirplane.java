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
import model.Airplane;
import model.Specialist;

/**
 * Servlet implementation class RegisteringAirplane
 */
@WebServlet("/registeringAirplane.do")
public class RegisteringAirplane extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int airCompanyID = Integer.parseInt(request.getParameter("airCompanyID"));
		int qtySeats = Integer.parseInt(request.getParameter("qtySeats"));
		String modelAirplane = request.getParameter("modelAirplane");

		
		Specialist spe = new Specialist();
		try {
			spe.adicionarAeronave(airCompanyID, qtySeats, modelAirplane);
			String sucesso = "Aeronave cadastrada!";
		} catch (Exception e) {
			e.printStackTrace();
			String erro = "Erro ao cadastrar Aeronave!";
		}

		RequestDispatcher view = request
				.getRequestDispatcher("registeringAirplane.jsp");
		view.forward(request, response);
	}

	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
