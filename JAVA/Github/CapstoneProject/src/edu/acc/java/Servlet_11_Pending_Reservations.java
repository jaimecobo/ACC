package edu.acc.java;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Management
 */
@WebServlet("/Pending_Reservations")
public class Servlet_11_Pending_Reservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_11_Pending_Reservations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("05_management_Options.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
//		PrintWriter out  = response.getWriter();	
		response.setContentType("text/html");

		String stat = "Pending";

		try {
			List<String> id_Customer = new ArrayList<String>();
			List<String> id_reservation_dates = new ArrayList<String>();
			List<String> entryDates = new ArrayList<String>();
			List<String> departureDates = new ArrayList<String>();
			List<String> status = new ArrayList<String>();
			List<String> Balance = new ArrayList<String>();
			StringBuilder strBuilder = new StringBuilder();
			String reservation_string = "";
	
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
//	        PreparedStatement pst = conn.prepareStatement("Select * from reservation_dates");
	        PreparedStatement pst = conn.prepareStatement("Select * from reservation where status=?");
	        pst.setString(1, stat);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	
	        }
	        	
		}
		catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("ERROR in Catch");
	        	ex.printStackTrace();
	    }
		
	}

}


