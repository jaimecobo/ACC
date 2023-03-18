package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		PrintWriter out  = response.getWriter();	
		response.setContentType("text/html");
		DataManager dt = new DataManager();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id_Customer = "";
		//REMOVE SESSION.REMOVE.ATTIBUITE(SELF_RESERVATION) 
		//REMOVE SESSION.REMOVE.ATTIBUITE(USERNAME) 
		
		out.println("Username = " + username);
		out.print("<br>");
		out.println("Password = " + password);
		out.print("<br>");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
	        PreparedStatement pst = conn.prepareStatement("Select id_Customer, username, password from customer where username=? and password=?");
	        pst.setString(1, username);
	        pst.setString(2, password);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	           out.println("Correct login credentials");
	        	id_Customer = rs.getString(1);
	        	request.getSession().setAttribute("username", username);
	        	
	        	session.setAttribute("id_Customer01", id_Customer);
	        	out.print("<a href='Create_Reservation'>visit</a>");
	        	

	        	session.setAttribute("id_Customer02", id_Customer);
	        	out.print("<a href='Check_Self_Reservation'>visit</a>");
	        	
	        	
	        	String id_Customer02 = (String)session.getAttribute("id_Customer02");

	        	System.out.println("id_Customer02 *** " + id_Customer02 + " *** as a Sess_Attrib in Login_Customer_Servlet.");
				
	        } 
	   
	    }
		catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("ERROR in Catch");
	        	ex.printStackTrace();
				
	    }finally {
			dt.close(rs);
			dt.close(pst);
			dt.close(conn);

		}
		
	}

}