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
 * Servlet implementation class RegisterPassenger
 */
@WebServlet("/registerPassenger.do")
public class RegisterPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterPassenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String CPF = (request.getParameter("CPF"));
		String treatmentClient = request.getParameter("treatmentClient");
		String nameClient = (request.getParameter("nameClient"));
		String lastNameClient = request.getParameter("lastNameClient");
		String emailClient = request.getParameter("emailClient");
		String birthDate = request.getParameter("birthDate");
		String telephoneClient = (request.getParameter("telephoneClient"));
		
		Passenger passageiro = new Passenger();
		Specialist spe = new Specialist();

		try {
			spe.cadastrarPassageiro(CPF,treatmentClient, nameClient, lastNameClient, emailClient, birthDate, telephoneClient );
			String sucesso = "Voo cadastrado!";

		} catch (Exception e) {
			String erro = "Erro ao cadastrar Voo!";

			e.printStackTrace();
		}

		RequestDispatcher view = request
				.getRequestDispatcher("registerPassenger.jsp");
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
