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
 * Servlet implementation class ExcludeFlight
 */
@WebServlet("/ExcludeFlight.do")
public class ExcludeFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int idVoo = Integer.parseInt(request.getParameter("idVoo"));		
		Specialist spe = new Specialist();
		try {
			spe.excluirVoo(idVoo);
			String sucesso = "Voo Excluido com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			String erro = "Erro ao excluir voo!";
		}

		RequestDispatcher view = request
				.getRequestDispatcher("excludeFlight.jsp");
		view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
