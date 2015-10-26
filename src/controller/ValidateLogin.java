package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import model.Specialist;
import to.LoginTO;
import dao.ServiceLookup;

/**
 * Servlet implementation class ValidateLogin
 */
@WebServlet("/ValidateLogin")
public class ValidateLogin extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Login login = new Login();
		Login consult = new Login();
		
		login.setUserLogin(request.getParameter("userLogin"));
		String userLogin = request.getParameter("userLogin");
		consult.setUserLogin(userLogin);
		
		login.setPasswordLogin(request.getParameter("passwordLogin"));
		String passwordLogin = request.getParameter("passwordLogin");
		consult.setPasswordLogin(passwordLogin);
		
		
		LoginTO loginTO = null;
		Specialist spe = new Specialist();
		try {
			loginTO = spe.validarLogin(userLogin, passwordLogin);
		} catch (Exception e) {
			e.printStackTrace();
			String erro = "Erro ao encontrar Login!";
		}

		request.setAttribute("lista", loginTO.getLista());
		
		RequestDispatcher view = request.getRequestDispatcher("indexLogin.html");
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
