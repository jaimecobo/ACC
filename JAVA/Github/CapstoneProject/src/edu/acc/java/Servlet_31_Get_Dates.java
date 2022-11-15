package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * THIS SERVLET GETS DATE_FROM AND DATE_TO FROM A HTML FORM AND CALCULATES THE NUMBER OF NIGHTS
 */
@WebServlet("/Servlet_Get_Dates")
public class Servlet_31_Get_Dates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_31_Get_Dates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out  = response.getWriter();	
		response.setContentType("text/html");
		
		String dateFrom = request.getParameter("from");
		String dateTo = request.getParameter("to");
		
		out.println("dateFrom = " + dateFrom);
		out.print("<br>");
		out.println("dateTo = " + dateTo);
		out.print("<br>");

		try {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date dateStr = formatter.parse(dateFrom);
		String formattedDate = formatter.format(dateStr);
		out.println("<br> MM/dd/yyyy date is ==> " + formattedDate);
		Date date1 = formatter.parse(formattedDate);
		formatter = new SimpleDateFormat("dd-MMM-yyyy");
		formattedDate = formatter.format(date1);
		out.println("<br> dd-MMM-yyyy date is ==> " + formattedDate);
		
		formatter = new SimpleDateFormat("MM/dd/yyyy");
		dateStr = formatter.parse(dateTo);
		formattedDate = formatter.format(dateStr);
		Date date2 = formatter.parse(formattedDate);
		
		
		/* Subtract dates */
		long diff = Math.abs(date1.getTime() - date2.getTime());\
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
