	package edu.acc.java;

	import java.io.IOException;
//	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	/**
	 * Servlet implementation class Servlet_Management
	 */
	@WebServlet("/Customers_Info")
	public class Servlet_18_Customers_Info extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Servlet_18_Customers_Info() {
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
//			response.setContentType("text/html");

//			String stat = "Pending";
			//=================================================================================================================
			//=================================================================================================================
			
			try {
				List<String> id_Customer = new ArrayList<String>();
				List<String> firstName = new ArrayList<String>();
				List<String> lastName = new ArrayList<String>();
				List<String> email = new ArrayList<String>();
				List<String> address = new ArrayList<String>();
				List<String> phoneNumber = new ArrayList<String>();
				List<String> birthday = new ArrayList<String>();
				List<String> nationality = new ArrayList<String>();
				List<String> documentType = new ArrayList<String>();
				List<String> documentNumber = new ArrayList<String>();
				List<String> memberSince = new ArrayList<String>();
				StringBuilder strBuilder = new StringBuilder();
				String customers_string = "";
		
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
		        PreparedStatement pst = conn.prepareStatement("Select * from customer");
//		        PreparedStatement pst = conn.prepareStatement("Select * from reservation where status=?");
//		        pst.setString(1, stat);
		        ResultSet rs = pst.executeQuery();
//		        System.out.println("1111111111111111111111111111111111");
		        int i = 0;
		        System.out.println("i = " + i);
		        while (rs.next()) {
//		        	System.out.println("2222222222222222222222222222222222");
		        	id_Customer.add(rs.getString(1));
		        	firstName.add(rs.getString(9));
		        	lastName.add(rs.getString(10));
		        	email.add(rs.getString(8));
		        	address.add(rs.getString(3));
		        	phoneNumber.add(rs.getString(14));
		        	birthday.add(rs.getString(4));
		        	nationality.add(rs.getString(12));
		        	documentType.add(rs.getString(7));
		        	documentNumber.add(rs.getString(6));
		        	memberSince.add(rs.getString(2));
		        	strBuilder.append(id_Customer.get(i) + "</td><td align=\"center\">" + firstName.get(i) + "</td><td align=\"center\">" + lastName.get(i) + " </td><td align=\"center\">" 
		        			+ email.get(i) + "</td> <td align=\"center\">" + address.get(i) + "</td> <td align=\"center\">" + phoneNumber.get(i) + "</td> <td align=\"center\">" 
		        			+ birthday.get(i) + "</td> <td align=\"center\">" + nationality.get(i) + "</td> <td align=\"center\">"
		        			+ documentType.get(i) + "</td> <td align=\"center\">" + documentNumber.get(i) + "</td> <td align=\"center\">" + memberSince.get(i) 
		            		+ "</td></tr>" + "<tr><td align=\"center\">");
		        	i++;
//		        	System.out.println("3333333333333333333333333333333333333");
//		        	System.out.println("i = " + i + " --- " + strBuilder.toString());
		        }
		        customers_string = strBuilder.toString();
		        request.getSession().setAttribute("customers_string", customers_string);
		        response.sendRedirect("18_Customers_info.jsp");
		        	
			}
			catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch");
		        	ex.printStackTrace();
		    }
			
			//=================================================================================================================
			//=================================================================================================================
			
			
			
		}

	}
