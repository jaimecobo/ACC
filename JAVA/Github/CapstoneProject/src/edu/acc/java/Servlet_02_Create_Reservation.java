package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Create_Reservation
 */
@WebServlet("/Create_Reservation")
public class Servlet_02_Create_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_02_Create_Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }
    String id_Customer = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());try{  
		try {
	        response.setContentType("text/html");  
//	        PrintWriter out = response.getWriter();  
	          
//	        HttpSession session=request.getSession(false);  
//	        id_Customer = (String)session.getAttribute("id_Customer01");
//	        System.out.println("the id_Customer is " + id_Customer + "at doGet method in Create_Reservation Servlet.");
	        
//        out.print("Hello "+n);  
//        out.close();  
		
		}catch(Exception e){System.out.println(e);} 
		
		request.getRequestDispatcher("02_reservation_Form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		PrintWriter out  = response.getWriter();	
		response.setContentType()
		
	}

}