   	package edu.acc.java;

	import java.io.IOException;
//	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	/**
	 * Servlet implementation class Servlet_Management
	 */
	@WebServlet("/Past_Reservations")
	public class Servlet_13_Past_Reservations extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Servlet_13_Past_Reservations() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.getRequestDispatcher("05_management_Options.jsp").forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
//			PrintWriter out  = response.getWriter();	
			response.setContentType("text/html");

//			String stat = "null";
			//=================================================================================================================
			//=================================================================================================================
			
			try {
				String current_Date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
				List<String> id_reservation_dates = new ArrayList<String>();
				List<String> entryDates = new ArrayList<String>();
				List<String> departureDates = new ArrayList<String>();
				List<String> status = new ArrayList<String>();
				StringBuilder strBuilder = new StringBuilder();
				String past_Reservations_String = "";
		
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
//		        PreparedStatement pst = conn.prepareStatement("Select * from reservation");
		        PreparedStatement pst = conn.prepareStatement("SELECT * FROM reservation WHERE departure_Date < '" + current_Date + "'");
//		        PreparedStatement pst = conn.prepareStatement("Select * from reservation_dates where status is null");
//		        pst.setString(1, stat);
		        ResultSet rs = pst.executeQuery();
		        int i = 0;
		        System.out.println("-*-*-*-*-* " + current_Date + " -*-*-*-*-* " + "IN PAST RESERVATIONS BEFORE WHILE LOOP");
		        while (rs.next()) {
		        	id_reservation_dates.add(rs.getString(1));
		        	departureDates.add(rs.getString(2));
		        	entryDates.add(rs.getString(3));
		        	status.add(rs.getString(7));
		        	strBuilder.append(id_reservation_dates.get(i) + "</td><td>" + entryDates.get(i) + " </td><td>" + departureDates.get(i) + "</td> <td>" + status.get(i) + "</td> <td>" 
		            		+ "</td></tr>" + "<tr><td>");
		        	i++;
		        	System.out.println("-*-*-*-*-* " + current_Date + " -*-*-*-*-* " + "IN PAST RESERVATIONS INSIDE WHILE LOOP -- i = " + i + " --");
		        }
		        
		        past_Reservations_String = strBuilder.toString();
		        request.getSession().setAttribute("past_Reservations_String", past_Reservations_String);
		        response.sendRedirect("13_Past_Reservations.jsp");
		        System.out.println("-*-*-*-*-* " + current_Date + " -*-*-*-*-* " + "IN PAST RESERVATIONS AFTER WHILE LOOP");
			}
			catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch");
		        	ex.printStackTrace();
		    }
			
			//=================================================================================================================
			//=================================================================================================================
			
		}

	}
