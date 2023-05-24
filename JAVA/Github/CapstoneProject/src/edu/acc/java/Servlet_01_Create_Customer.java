package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Create_Customer
 */
@WebServlet("/Create_Customer")
public class Servlet_01_Create_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_01_Create_Customer() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("01_index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out  = response.getWriter();	
		response.setContentType("text/html");
		
		LocalMySQLCP localDB = new LocalMySQLCP();
		DataManager dt = new DataManager();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String doc_Type = request.getParameter("doc_Type");
		String doc_Number = request.getParameter("doc_Number");
		String phone = request.getParameter("phone");
		Date bd = (Date)formatter.parse("birthday"); 
		String bday = formatter.format(bd);
		
		String birthday = request.getParameter("birthday");
		Date birthday01 = null;
		try {
			birthday01 = (Date)formatter.parse("birthday00");
			birthday00 = formatter.format(birthday01);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} 
	
		birthday = birthday01.toString();
		request.getParameter(formatter.format("birthday"));
		String company = request.getParameter("company");
		String origin = request.getParameter("origin");
		String occupation = request.getParameter("occupation");
		String dateCreated = new SimpleDateFormat("MM/d/yyyy").format(new Date());
		String dateCreated = request.getParameter("dateCreated");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		String sql;
		String[] parms;
	
		
		
		
		out.println("<br>" + "firstName 	: " + firstName);
		out.println("<br>" + "lastName 		: " + lastName);
		out.println("<br>" + "address 		: " + address);
		out.println("<br>" + "email 		: " + email);
		out.println("<br>" + "doc_Type 		: " + doc_Type);
		out.println("<br>" + "doc_Number	: " + doc_Number);
		out.println("<br>" + "phone			: " + phone);
		out.println("<br>" + "birthday		: " + birthday);
		out.println("<br>" + "company		: " + company);
		out.println("<br>" + "origin		: " + origin);
		out.println("<br>" + "occupation	: " + occupation);
		out.println("<br>" + "dateCreated	: " + dateCreated);
		out.println("<br>" + "userName		: " + userName);
		out.println("<br>" + "password		: " + password);

	
		int rowCount;
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			String birthday00 = request.getParameter("birthday");
			Date birthday01;
			
			try {
				birthday01 = formatter.parse(birthday00);
			    birthday00 = formatter.format(birthday01);
				
			} catch (ParseException e) {
			    e.printStackTrace();

			}
			
			
			sql = "insert into customer (firstName, lastName, address, email, document_Type, document_Number, phoneNumber, birthday, company_Name, origin_Nationality, occupation, "
					+ "account_Creation_Date, userName, password) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		    parms = new String[]
			
		}catch(SQLException ex){
			out.println("ERROR catch in Servlet_Create_Customer");
			ex.printStackTrace();
			localDB.printTrace(ex);
			
		}

	}
	
}