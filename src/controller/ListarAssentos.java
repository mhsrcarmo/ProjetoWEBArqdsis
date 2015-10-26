package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServiceLookup;
import to.SeatsTO;
import model.Seats;
import model.Specialist;
import factory.DAOFactory;

/**
 * Servlet implementation class ListarAssentos
 */
@WebServlet("/ListarAssentos")
public class ListarAssentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Seats assento = new Seats();
		Seats consult = new Seats();
		
		assento.setFlightID(Integer.parseInt(request.getParameter("flightIDSearch")));
		int flightIDSearch = Integer.parseInt(request.getParameter("flightIDSearch"));
		consult.setFlightID(flightIDSearch);

		SeatsTO listaAssento = null;
		Specialist spe = new Specialist();
		try {
			listaAssento = spe.listarAssentos(flightIDSearch);
		} catch (Exception e) {
			String erro = "erro na consulta!";
			e.printStackTrace();
		}
		request.setAttribute("listSeat", listaAssento);
		
		RequestDispatcher view = request
				.getRequestDispatcher("consultFlight.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void init(ServletConfig config) {
		// todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
}
