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
import to.TicketTO;
//import to.AirplaneTO;
import model.Airplane;
import model.Specialist;

/**
 * Servlet implementation class ConsultAirplane
 */
@WebServlet("/ConsultAirplane.do")
public class ConsultAirplane extends HttpServlet {
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
		
		Airplane airplane = new Airplane();
		Airplane consult = new Airplane();
		
		airplane.setAirplaneID(Integer.parseInt(request.getParameter("airplaneID")));		
		int consulId = Integer.parseInt(request.getParameter("airplaneID"));
		consult.setAirplaneID(consulId);
		
		
		
		Specialist spe = new Specialist();
		AirplaneTO aeronaveTO = null;
		try {
			aeronaveTO = spe.consultarAeronave(consulId);
		} catch (Exception e) {
			String erro = "erro na consulta!";
			e.printStackTrace();
		}
		request.setAttribute("lista", aeronaveTO.getLista());
		
		RequestDispatcher view = request
				.getRequestDispatcher("consultAirplane.jsp");
		view.forward(request, response);
	}

	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
