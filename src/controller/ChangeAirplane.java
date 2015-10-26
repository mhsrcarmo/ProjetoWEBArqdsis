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
import to.AirplaneTO;
import model.Airplane;
import model.Specialist;

/**
 * Servlet implementation class ChangeAirplane
 */
@WebServlet("/ChangeAirplane.do")
public class ChangeAirplane extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		
		int airplaneID = Integer.parseInt(request.getParameter("airplaneID"));
		int airCompanyID = Integer.parseInt(request.getParameter("airCompanyID"));
		int qtySeats = Integer.parseInt(request.getParameter("qtySeats"));
		String modelAirplane = request.getParameter("modelAirplane");
		
		
		Specialist spe = new Specialist();
		try {
			spe.alterarAeronave(airplaneID, airCompanyID, qtySeats, modelAirplane);
			String sucesso = "Alteração feita com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			String erro = "erro na alteração!";
		}

		RequestDispatcher view = request
				.getRequestDispatcher("changeAirplane.jsp");
		view.forward(request, response);
	}

	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
