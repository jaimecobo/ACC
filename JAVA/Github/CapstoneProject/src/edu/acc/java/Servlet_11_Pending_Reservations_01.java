package edu.acc.java;

import java.io.IOException;
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
 * Servlet implementation class Servlet_Management
 */
@WebServlet("/Pending_Reservations_01")
public class Servlet_11_Pending_Reservations_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_11_Pending_Reservations_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String stat = "Pending";
		
		try {
			List<String> id_Customer = new ArrayList<String>();
			List<String> id_reservation_dates = new ArrayList<String>();
			List<String> entryDates = new ArrayList<String>();
			List<String> departureDates = new ArrayList<String>();
			List<String> status = new ArrayList<String>();
			List<String> Balance = new ArrayList<String>();

	
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
	        PreparedStatement pst = conn.prepareStatement("Select * from reservation where status=?");
	        pst.setString(1, stat);
	        ResultSet rs = pst.executeQuery();
	        int i = 0;
	        ArrayList<Reservation> reservationList = new ArrayList<>();
	        while (rs.next()) {
	        	id_reservation_dates.add(rs.getString(1));
	        		        	
	        }   
	        	
		}
		catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("ERROR in Catch");
	        	ex.printStackTrace();
	    }
	}

}
