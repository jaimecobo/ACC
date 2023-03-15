package edu.acc.java;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Login
 */
@WebServlet("/Login01")
public class Servlet_04_Login_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_04_Login_Customer() {
        super();
        // TODO Auto-generated constructor stub
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("01_index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
//		PrintWriter out  = response.getWriter();	
		response.setContentType("text/html");
		DataManager dt = new DataManager();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id_Customer = "";
		//REMOVE SESSION.REMOVE.ATTIBUITE(SELF_RESERVATION) 
		//REMOVE SESSION.REMOVE.ATTIBUITE(USERNAME) 
		
//		out.println("Username = " + username);
//		out.print("<br>");
//		out.println("Password = " + password);
//		out.print("<br>");
		
		
		try {
			Class.forName();

	    } 
		catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("ERROR in Catch");
	        	ex.printStackTrace();
				
	    }finally {

		}
		
	}

}