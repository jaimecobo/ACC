package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		response.setContentType("text/html");
		/*
		String[] festDates = {"12/24/2017", "12/25/2017", "12/31/2017", "01/01/2018","01/15/2018","02/08/2018", "02/19/2018", "03/04/2018", "03/09/2018", "03/10/2018", "03/11/2018", 
				"03/12/2018", "03/13/2018", "03/14/2018", "03/15/2018", "03/16/2018", "03/17/2018", "03/18/2018", "04/08/2018", "04/28/2018", "05/18/2018", "06/07/2018", "06/08/2018", 
				"06/09/2018", "06/10/2018", "06/23/2018", "07/04/2018", "08/18/2018", "09/03/2018", "09/29/2018", "10/05/2018", "10/06/2018", "10/07/2018", "10/12/2018", "10/13/2018", 
				"10/14/2018", "10/25/2018", "10/26/2018", "10/27/2018", "10/28/2018", "10/29/2018","10/30/2018", "10/31/2018", "11/01/2018", "11/12/2018",	"11/22/2018",	"11/23/2018", 
				"12/24/2018","12/25/2018", "12/31/2017", "01/01/2019", };
		*/
		HttpSession session=request.getSession(false);  
        id_Customer = (String)session.getAttribute("id_Customer01");
        
        if(id_Customer != null) {
        System.out.println("The id_Customer is " + id_Customer + " at doPost method in Create_Reservation Servlet.");
		
		LocalMySQLCP localDB = new LocalMySQLCP();
		
		String departure_Date = request.getParameter("to");
		String entry_Date = request.getParameter("from");
//		String departure_Date = request.getParameter("end_date");
//		String entry_Date = request.getParameter("start_date");
		String status = "Pending";
//		String id_Customer = request.getParameter("idCustomer");
//		String initial_Paymet = request.getParameter("initialPaymet");
//		String room_Number = request.getParameter("roomNumber");
	
//		id_Customer = "1";
//		initial_Paymet = "0.0";
//		room_Number = "1";
		
		String sql;
		String[] parms;
		
		
//		out.println("<br>" + "entry_Date 	: " + entry_Date);
//		out.println("<br>" + "departure_Date 		: " + departure_Date);
//		out.println("<br>");
//		out.println("<br>" + "address 		: " + address);
//		out.println("<br>" + "email 		: " + email);
//		out.println("<br>" + "doc_Type 		: " + doc_Type);
//		out.println("<br>" + "doc_Number	: " + doc_Number);
//		out.println("<br>" + "phone			: " + phone);
//		out.println("<br>" + "birthday		: " + birthday);
//		out.println("<br>" + "company		: " + company);
//		out.println("<br>" + "origin		: " + origin);
//		out.println("<br>" + "occupation	: " + occupation);
//		out.println("<br>" + "dateCreated	: " + dateCreated);
//		out.println("<br>" + "userName		: " + userName);
//		out.println("<br>" + "password		: " + password);
		
		//=================================================================================================================
		//=================================================================================================================
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("{ ");
//		List<Date> dates = new ArrayList<Date>();
		int festDaysCount = 0;
		String daysAmount = "";
		double total = 0.0;
		/* GETS DATE_FROM AND DATE_TO AND CALCULATES THE NUMBER OF NIGHTS*/
		try {
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	//this format is to test running it with blockedDates_part0123.js
			SimpleDateFormat formatter = new SimpleDateFormat("MM/d/yyyy");		//This format is working fine with the first version, running with blockedDates_part01.js
			Date dateStr = formatter.parse(entry_Date);
			String formattedDate = formatter.format(dateStr);
//			out.println("<br> MM/dd/yyyy date is ==> " + formattedDate);
			Date date1 = formatter.parse(formattedDate);
//			formatter = new SimpleDateFormat("dd-MMM-yyyy");
//			formattedDate = formatter.format(date1);
//			out.println("<br> dd-MMM-yyyy date is ==> " + formattedDate);
			
//			formatter = new SimpleDateFormat("yyyy-MM-dd");		//this format is to test running it with blockedDates_part0123.js
			formatter 
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }else {
        	String loginReqMsg = "<h3>- Please log in to make a reservation. -</h3>";
        	request.setAttribute("loginReqMsg", loginReqMsg);
        	request.getRequestDispatcher("02_reservation_Form.jsp").forward(request, response);
               	
        }
		
	}

}