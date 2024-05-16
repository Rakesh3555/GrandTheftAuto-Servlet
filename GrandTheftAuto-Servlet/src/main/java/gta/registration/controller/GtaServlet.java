package gta.registration.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gta.registration.dao.GtaDataBaseManager;
import gta.registration.model.GtaPojo;

/**
 * Servlet implementation class GtaServlet
 */
@WebServlet("/register")
public class GtaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       GtaDataBaseManager gdb = new GtaDataBaseManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GtaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessFullLog.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String Date_of_birth = request.getParameter("Date_of_birth");
		String mail = request.getParameter("mail");
		
		GtaPojo gp = new GtaPojo();
		gp.setUsername(username);
		gp.setDate_of_birth(Date_of_birth);
		gp.setMail(mail);
		
		GtaDataBaseManager gtb = new GtaDataBaseManager();
		try {
			gtb.GtaPreBooks(gp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("");
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
	}

}
