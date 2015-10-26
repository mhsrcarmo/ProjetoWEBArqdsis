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
 * Servlet implementation class ChangePassenger
 */
@WebServlet("/ChangePassenger.do")
public class ChangePassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String CPFSearch = request.getParameter("CPFSearch");
		String nameClientSearch = request.getParameter("nameClientSearch");
		String CPF = (request.getParameter("CPF"));
		String treatmentClient = request.getParameter("treatmentClient");
		String nameClient = (request.getParameter("nameClient"));
		String lastNameClient = request.getParameter("lastNameClient");
		String emailClient = request.getParameter("emailClient");
		String birthDate = request.getParameter("birthDate");
		String telephoneClient = (request.getParameter("telephoneClient"));

		Specialist spe = new Specialist();
		try {
			spe.alterarPassageiro(CPFSearch, nameClientSearch, CPF,
					treatmentClient, nameClient, lastNameClient,
					emailClient, birthDate, telephoneClient);
			String sucesso = "Alteração feita com sucesso!";
		} catch (Exception e) {
			String erro = "erro na alteração!";
			e.printStackTrace();
		}

		RequestDispatcher view = request
				.getRequestDispatcher("changePassenger.jsp");
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
