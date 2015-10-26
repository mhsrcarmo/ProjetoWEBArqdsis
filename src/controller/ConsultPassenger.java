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
import to.PassengerTO;
import model.Passenger;
import model.Specialist;

/**
 * Servlet implementation class ConsultPassenger
 */
@WebServlet("/ConsultPassenger.do")
public class ConsultPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Passenger passageiro = new Passenger();
		Passenger consult =  new Passenger();
		
		passageiro.setCPF(request.getParameter("CPFSearch"));
		String CPFSearch = request.getParameter("CPFSearch");
		consult.setCPF(CPFSearch);
		
		passageiro.setNameClient(request.getParameter("nameClientSearch"));
		String nameClientSearch = request.getParameter("nameClientSearch");
		consult.setNameClient(nameClientSearch);
		
		PassengerTO passageiroTO =  null;	
		Specialist spe = new Specialist();
		try {
			
			passageiroTO = spe.consultarPassageiro(CPFSearch, nameClientSearch);
			String erro = "erro na consulta!";

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("lista", passageiroTO.getLista());
		
		RequestDispatcher view = request
				.getRequestDispatcher("consultPassenger.jsp");
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
