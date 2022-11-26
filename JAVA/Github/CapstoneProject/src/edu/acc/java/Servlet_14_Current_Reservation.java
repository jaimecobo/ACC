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

//	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	/**
	 * Servlet implementation class Servlet_Management
	 */
	@WebServlet("/Current_Reservation")
	public class Servlet_14_Current_Reservation extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Servlet_14_Current_Reservation() {
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

			/* GETS THE RETURN VALUE FROM SERVLET SPECIFIED IN STATEMENT AND ASSIGN ITS VALUE TO "DISPACHER"*/
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Servlet_ArrayOfBlockingDates");dispatcher.include(request, response);
//			Object attributeValue = request.getAttribute("result");
//			System.out.println("Array[String] Dates toString() = " + attributeValue.toString());

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
				String current_Reservation_String = "";
		
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
		        PreparedStatement pst = conn.prepareStatement("Select * from reservation");
//		        PreparedStatement pst = conn.prepareStatement("SELECT * FROM reservation WHERE departure_Date < '" + current_Date + "'");
//		        PreparedStatement pst = conn.prepareStatement("Select * from reservation_dates where status is null");
//		        pst.setString(1, stat);
		        ResultSet rs = pst.executeQuery();
		        int i = 0;
		        System.out.println("-*-*-*-*-* " + current_Date + " -*-*-*-*-* " + "IN CURRENT RESERVATIONS BEFORE WHILE LOOP");
		        while (rs.next()) {
		        	id_reservation_dates.add(rs.getString(1));
		        	departureDates.add(rs.getString(2));
		        	entryDates.add(rs.getString(3));
		        	status.add(rs.getString(7));
		        	strBuilder.append(id_reservation_dates.get(i) + "</td><td>" + entryDates.get(i) + " </td><td>" + departureDates.get(i) + "</td> <td>" + status.get(i) + "</td> <td>" 
		            		+ "</td></tr>" + "<tr><td>");
		        	i++;
		        	System.out.println("-*-*-*-*-* " + current_Date + " -*-*-*-*-* " + "IN CURRENT RESERVATIONS INSIDE WHILE LOOP -- i = " + i + " --");
		        }
		        
		        current_Reservation_String = strBuilder.toString();
		        request.getSession().setAttribute("current_Reservation_String", current_Reservation_String);
		        response.sendRedirect("14_Current_Reservation.jsp");
		        System.out.println("-*-*-*-*-* " + current_Date + " -*-*-*-*-* " + "IN CURRENT RESERVATIONS AFTER WHILE LOOP");
			}
			catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch");
		        	ex.printStackTrace();
		    }
			
			//=================================================================================================================
			//=================================================================================================================
			
		}

	}