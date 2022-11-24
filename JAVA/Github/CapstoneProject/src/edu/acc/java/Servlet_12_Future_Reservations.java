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
	@WebServlet("/Future_Reservations")
	public class Servlet_12_Future_Reservations extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Servlet_12_Future_Reservations() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			request.getRequestDispatcher("05_management_Options.jsp").forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			doGet(request, response);
			
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
				String future_Reservations_String = "";
		
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
		        
		        PreparedStatement pst = conn.prepareStatement("Select * from reservation");
		        PreparedStatement pst = conn.prepareStatement("SELECT * FROM reservation WHERE departure_Date > '" + current_Date + "'");
		        PreparedStatement pst = conn.prepareStatement("Select * from reservation_dates where status is null");
		        pst.setString(1, stat);
		        ResultSet rs = pst.executeQuery();
		        System.out.println("1111111111111111111111111111111111");
		        int i = 0;
		        System.out.println("i = " + i);
		        while (rs.next()) {
		        	System.out.println("2222222222222222222222222222222222");
		        	id_reservation_dates.add(rs.getString(1));
		        	departureDates.add(rs.getString(2));
		        	entryDates.add(rs.getString(3));
		        	status.add(rs.getString(7));
		        	strBuilder.append(id_reservation_dates.get(i) + "</td><td>" + entryDates.get(i) + " </td><td>" + departureDates.get(i) + "</td> <td>" + status.get(i) + "</td> <td>" 
		            		+ "</td></tr>" + "<tr><td>");
		        	i++;
		        	System.out.println("3333333333333333333333333333333333333");
		        	System.out.println("i = " + i + " --- " + strBuilder.toString());
		        }
		        future_Reservations_String = strBuilder.toString();
		        request.getSession().setAttribute("future_Reservations_String", future_Reservations_String);
		        response.sendRedirect("12_future_Reservations.jsp");
		        System.out.println("-*-*-*-*-* " + current_Date + " -*-*-*-*-* " + "IN FUTURE RESERVATIONS");
		        	
			}
			catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch");
		        	ex.printStackTrace();
		    }
			
			//=================================================================================================================
			//=================================================================================================================
			
		}

	}