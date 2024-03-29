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

/**
 * Servlet implementation class Servlet_16_Query_Reservations
 */
@WebServlet("/Servlet_16_Query_Reservations")
public class Servlet_16_Query_Reservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_16_Query_Reservations() {
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
		
		String id_reservation = request.getParameter("resrvNum");
		
		try {
			
			List<String> entryDates = new ArrayList<String>();
			List<String> departureDates = new ArrayList<String>();
			List<String> status = new ArrayList<String>();
			String query_Reservations_String;

	
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
	        PreparedStatement pst = conn.prepareStatement("Select departure_date, entry_date, status from reservation where id_reservation=?");
	        pst.setString(1, id_reservation);
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	        	departureDates.add(rs.getString(1));
	        	entryDates.add(rs.getString(2));
	        	status.add(rs.getString(3));
	        	
	        	if((status.get(0).equals("Approved"))) {
	        		query_Reservations_String = "Reservation N� : \"" + id_reservation + "\"  From: " + entryDates.get(0) + "  To: " + departureDates.get(0) + " is approved.";
		        	request.getSession().setAttribute("query_Reservations_String", query_Reservations_String);
			        response.sendRedirect("16_Query_Reservations.jsp");
	        	}
	        	else if ((status.get(0).equals("Denied"))) {
	        		query_Reservations_String = "Reservation N� : \"" + id_reservation + "\"  From: " + entryDates.get(0) + "  To: " + departureDates.get(0) + " has been denied.";
		        	request.getSession().setAttribute("query_Reservations_String", query_Reservations_String);
			        response.sendRedirect("16_Query_Reservations.jsp");
	        	}
	        	else if ((status.get(0).equals("Pending")) | (status.get(0).equals("null"))) {
	        		query_Reservations_String = "Reservation N� : \" " + id_reservation + " \"  From: " + entryDates.get(0) + "  To: " + departureDates.get(0) + " is pending.";
		        	request.getSession().setAttribute("query_Reservations_String", query_Reservations_String);
			        response.sendRedirect("16_Query_Reservations.jsp");
			        
	        	}
	        }
		    else {
				query_Reservations_String = "Reservation N�: \"" + id_reservation + "\"  doesn't exist.";
				request.setAttribute("query_Reservations_String", query_Reservations_String);
				request.getRequestDispatcher("16_Query_Reservations.jsp").forward(request, response);
			}
	        
	     
		}
		catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("ERROR in Catch");
	        	ex.printStackTrace();
	    }
		
	}

}



