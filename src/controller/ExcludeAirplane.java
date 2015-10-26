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
 * Servlet implementation class ExcludingAirplane
 */
@WebServlet("/ExcludeAirplane.do")
public class ExcludeAirplane extends HttpServlet {
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
		
		
		int airplaneID  = Integer.parseInt(request.getParameter("airplaneID "));
		
		Specialist spe = new Specialist();
		try {
			spe.excluirAeronave(airplaneID );
			String sucesso = "Aeronave Excluida com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			String erro = "Erro ao excluir aeronave!";
		}

		RequestDispatcher view = request
				.getRequestDispatcher("excludeAirplane.jsp");
		view.forward(request, response);
	}

	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
