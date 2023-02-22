	package edu.acc.java;

	import java.io.IOException;
//	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	/**
	 * Servlet implementation class Servlet_Check_Reservation
	 */
	@WebServlet("/Check_Self_Reservation")
	public class Servlet_03_Check_Self_Reservation extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Servlet_03_Check_Self_Reservation() {
	        super();
	        // TODO Auto-generated constructor stub
			
	    }
	    
	    String id_Customer02 = "";
	    
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			request.getRequestDispatcher("02_reservation_Form.jsp").forward(request, response);
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			doGet(request, response);
			
//			PrintWriter out  = response.getWriter();	
			response.setContentType("text/html");
			
			HttpSession session=request.getSession(false);  
	        id_Customer02 = (String)session.getAttribute("id_Customer01");
	        System.out.println("the id_Customer is " + id_Customer02 + " at doPost method in Check_Self_Reservation Servlet.");
	        
			
//			String id_reservation = request.getParameter("resrvNum");
												
		}

	}