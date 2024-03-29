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
		//=================================================================================================================
		//=================================================================================================================
		
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
	        	departureDates.add(rs.getString(2));
	        	entryDates.add(rs.getString(3));
	        	id_Customer.add(rs.getString(4));
	        	Balance.add(rs.getString(6));
	        	status.add(rs.getString(7));
	        	
	        	
	        	Reservation reservation = new Reservation();
	        	reservation.setId_Reservation((Integer.parseInt(id_reservation_dates.get(i))));
	        	reservation.setDeparture_Date(departureDates.get(i));
	        	reservation.setEntry_Date(entryDates.get(i));
	        	reservation.setId_Customer((Integer.parseInt(id_Customer.get(i))));
	        	reservation.setBalance((Double.parseDouble(Balance.get(i))));
	        	reservation.setStatus(status.get(i));
	        	
	        	reservationList.add(reservation);
	        }
	        
	        request.setAttribute("reservationList", reservationList);
	        request.getRequestDispatcher("/11_Pending_Reservations_01.jsp").forward(request, response);      
	        	
		}
		catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("ERROR in Catch");
	        	ex.printStackTrace();
	    }
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
		//=================================================================================================================
		//=================================================================================================================
		
		try {
			List<String> id_Customer = new ArrayList<String>();
			List<String> id_reservation_dates = new ArrayList<String>();
			List<String> entryDates = new ArrayList<String>();
			List<String> departureDates = new ArrayList<String>();
			List<String> status = new ArrayList<String>();
			List<String> Balance = new ArrayList<String>();
//			StringBuilder strBuilder = new StringBuilder();
//			String reservation_string = "";
	
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
//	        PreparedStatement pst = conn.prepareStatement("Select * from reservation_dates");
	        PreparedStatement pst = conn.prepareStatement("Select * from reservation where status=?");
	        pst.setString(1, stat);
	        ResultSet rs = pst.executeQuery();
	        System.out.println("1111111111111111111111111111111111");
	        int i = 0;
	        System.out.println("i = " + i);
//	        Reservation reservation = new Reservation();
	        ArrayList<Reservation> reservationList = new ArrayList<>();
	        while (rs.next()) {
	        	System.out.println("2222222222222222222222222222222222");
	        	id_reservation_dates.add(rs.getString(1));
	        	departureDates.add(rs.getString(2));
	        	entryDates.add(rs.getString(3));
	        	id_Customer.add(rs.getString(4));
	        	Balance.add(rs.getString(6));
	        	status.add(rs.getString(7));
	        	
	        	
	        	Reservation reservation = new Reservation();
	        	reservation.setId_Reservation((Integer.parseInt(id_reservation_dates.get(i))));
	        	reservation.setDeparture_Date(departureDates.get(i));
	        	reservation.setEntry_Date(entryDates.get(i));
	        	reservation.setId_Customer((Integer.parseInt(id_Customer.get(i))));
	        	reservation.setBalance((Double.parseDouble(Balance.get(i))));
	        	reservation.setStatus(status.get(i));
	        	
//	        	Reservation reservation = new Reservation(	Long.parseLong(rs.getString(1)), 
//	        												rs.getInt(4),
//	        												rs.getString(3),
//	        												rs.getString(2),
//	        												rs.getDouble(6),
//	        												rs.getString(7)
//	        											);
	        	reservationList.add(reservation);
	        	
	        	
	        	
	        	
	        	System.out.println("Id: " + reservation.getId_Reservation() + " Customer: " + reservation.getId_Customer() + " Entry: " + reservation.getEntry_Date() + " Departure: "
	        			+ reservation.getDeparture_Date() + " Balance: " + reservation.getBalance() + " Status: " + reservation.getStatus());
	        	System.out.println("*******************************************************");
	        	
	        	System.out.println("Id: " +  reservationList.get(i).getId_Reservation()  + " Customer: " + reservationList.get(i).getId_Customer() + " Entry: " + reservationList.get(i).getEntry_Date() + " Departure: "
	        			+ reservationList.get(i).getDeparture_Date() + " Balance: " + reservationList.get(i).getBalance() + " Status: " + reservationList.get(i).getStatus());
	        	System.out.println("*******************************************************");
	        	
	        	
//	        	strBuilder.append(reservation.getId_Reservation() + "</td><td>" + reservation.getEntry_Date()  + "</td><td>" + reservation.getDeparture_Date()   + "</td><td>" +
//	        	reservation.getStatus() + "</td><td>" + reservation.getBalance() + "</td> <td>");
	        	
	        	
	        	
//	        	strBuilder.append(id_Customer.get(i) + "</td><td>" + id_reservation_dates.get(i) + "</td><td>" + entryDates.get(i) + " </td><td>" + departureDates.get(i) + "</td> <td>" 
//		        		+ status.get(i) + "</td> <td>" 
//		        		+ "<input class=\"btn btn-primary\" type=\"submit\" name=\"submit\" value=\"Approve\"> "
//		        		+ "<input class=\"btn btn-danger\" type=\"submit\" name=\"submit\" value=\"Deny\">"
//		        		+ "</td></tr>" + "<tr><td>");
	        	
//	        	+ status.get(i) + "</td> <td>" 
//    			+"<form action=\"Servlet_Approve\" method=\"post\">"
//        		+ "<input class=\"btn btn-primary\" type=\"submit\" name=\"" + id_reservation_dates.get(i) + "\" id=\"submit\" value=\"Approve\"> "
//    			+"</form></td>"
//    			+"<td><form action=\"Servlet_Deny\" method=\"post\">"
//        		+ "<input class=\"btn btn-danger\" type=\"submit\" name=\"" + id_reservation_dates.get(i) + "\" id=\"submit\" value=\"Deny\">"
//        		+"</form></td>"
//        		+ "</td></tr>" + "<tr><td>");
	        			
//	        			+ status.get(i) + "</td> <td>" + Balance.get(i) + "</td> <td>"
//	        			+"<form action=\"Servlet_Approve\" method=\"post\">"
//	            		+ "<input class=\"btn btn-primary\" type=\"submit\" name=\"submit \" id=\"submit\" value=\"Approve\"> "
//	        			+"</form></td>"
//	        			+"<td><form action=\"Servlet_Deny\" method=\"post\">"
//	            		+ "<input class=\"btn btn-danger\" type=\"submit\" name=\"submit\" id=\"submit\" value=\"Deny\">"
//	            		+"</form></td>"
//	            		+ "</td></tr>" + "<tr><td>");
	        	i++;
	        	System.out.println("3333333333333333333333333333333333333");
//	        	System.out.println("i = " + i + " --- " + strBuilder.toString());
	        	
	        	
//	        	request.setAttribute("reservation", reservation);
//	    		this.getServletContext().getRequestDispatcher("/11_Pending_Reservations_01.jsp").forward(request, response);
	        
//	        	 request.getSession().setAttribute("reservation", reservation);
//	        	 request.getRequestDispatcher("/11_Pending_Reservations_01.jsp").forward(request, response);
//	        	 response.sendRedirect("11_Pending_Reservations_01.jsp");
	        }
	        
	        request.setAttribute("reservationList", reservationList);
	        request.getRequestDispatcher("/11_Pending_Reservations_01.jsp").forward(request, response);
//	        reservation_string = strBuilder.toString();
//	        request.getSession().setAttribute("reservation", reservation);
//	        
//	        response.sendRedirect("11_Pending_Reservations.jsp");
	        	
		}
		catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("ERROR in Catch");
	        	ex.printStackTrace();
	    }
		
		//=================================================================================================================
		//=================================================================================================================
		
	}

}
