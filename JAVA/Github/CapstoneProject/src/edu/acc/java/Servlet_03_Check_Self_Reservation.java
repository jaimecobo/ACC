	package edu.acc.java;

	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;

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
		protected void doGet(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}

	}