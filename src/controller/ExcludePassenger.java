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
 * Servlet implementation class ExcludePassenger
 */
@WebServlet("/ExcludePassenger.do")
public class ExcludePassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Passenger passageiro =  new Passenger();	
		String CPFSearch = request.getParameter("CPFSearch");
		String nameClientSearch = request.getParameter("nameClientSearch");
				
		
		Specialist spe = new Specialist();
		try {
			spe.excluirPassageiro(CPFSearch, nameClientSearch);
			String sucesso = "Passageiro Excluido com sucesso!";
		} catch (Exception e) {
			String erro = "Erro ao excluir Passageiro!";

			e.printStackTrace();
		}

		RequestDispatcher view = request
				.getRequestDispatcher("excludePassenger.jsp");
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
