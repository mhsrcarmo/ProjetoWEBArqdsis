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
import model.Specialist;

/**
 * Servlet implementation class ChangeTicket
 */
@WebServlet("/ChangeTicket.do")
public class ChangeTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int flightIDSearch = Integer.parseInt(request.getParameter("flightIDSearch"));
		String clientCPFSearch = request.getParameter("clientCPFSearch");
		String seatNameSearch = (request.getParameter("seatNameSearch"));
	

		Specialist spe = new Specialist();
		try {
			spe.alterarPassagem(flightIDSearch, clientCPFSearch, seatNameSearch);
			String sucesso = "Alteração feita com sucesso!";
		} catch (Exception e) {
			String erro = "erro na alteração!";
			e.printStackTrace();
		}

		RequestDispatcher view = request
				.getRequestDispatcher("changeTicket.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
