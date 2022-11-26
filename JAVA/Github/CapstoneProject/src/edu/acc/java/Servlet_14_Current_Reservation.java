	package edu.acc.java;

	import java.io.IOException;
//	import java.io.PrintWriter;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

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
			
			try {
//		        PreparedStatement pst = conn.prepareStatement("SELECT * FROM reservation WHERE departure_Date < '" + current_Date + "'");
//		        PreparedStatement pst = conn.prepareStatement("Select * from reservation_dates where status is null");
//		        pst.setString(1, stat);
		        
			}
			catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch");
		        	ex.printStackTrace();
		    }
			
		}

	}